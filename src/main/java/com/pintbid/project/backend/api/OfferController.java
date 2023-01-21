package com.pintbid.project.backend.api;

import com.pintbid.project.backend.models.Offer;
import com.pintbid.project.backend.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("api/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@Valid @RequestBody Offer offer) {

        try {
            Offer _offer = offerService
                    .addOffer(new Offer(offer.getOfferingPrice(), offer.getUserId(), offer.getAuctionId(), offer.isAccepted()));
            return new ResponseEntity<>(_offer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


    @GetMapping
    public ResponseEntity<List<Offer>> selectAllOffers() {

        try {
            List<Offer> offers = new ArrayList<Offer>();

            offerService.selectAllOffers().forEach(offers::add);
            if (offers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(offers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Offer> selectOfferById(@PathVariable("id") Integer id) {
        Optional<Offer> offerData = offerService.selectOfferById(id);


        if (offerData.isPresent()) {
            return new ResponseEntity<>(offerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Offer> updateOfferById(@PathVariable("id") Integer id, @RequestBody Offer offer) {

        Optional<Offer> offerData = offerService.selectOfferById(id);

        if (offerData.isPresent()) {
            Offer _offer = offerData.get();
            _offer.setOfferingPrice(offer.getOfferingPrice());
            _offer.setAccepted(offer.isAccepted());
            _offer.setAuctionId(offer.getAuctionId());
            _offer.setUserId(offer.getUserId());
            return new ResponseEntity<>(offerService.updateOfferById(offer.getId(), _offer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteOfferById(@PathVariable("id") Integer id) {

        try {
            offerService.deleteOfferById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
