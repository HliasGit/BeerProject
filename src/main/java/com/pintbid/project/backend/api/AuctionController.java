package com.pintbid.project.backend.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pintbid.project.backend.models.Auction;
import com.pintbid.project.backend.models.User;
import com.pintbid.project.backend.repository.AuctionRepository;
import com.pintbid.project.backend.services.AuctionService;
import com.pintbid.project.backend.utils.EAuctionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/auctions")
@RestController
public class AuctionController {
    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {this.auctionService = auctionService;}

    @PostMapping
    public ResponseEntity<Auction> createAuction(@Valid @RequestBody Auction auction) {
        try {
            Auction _auction = auctionService
                    .createAuction(new Auction(auction.getTitle(), auction.getDescription(), auction.getMinPrice(),
                            auction.getMaxPrice(), auction.getStartDate(), auction.getEndDate(),
                            auction.getBuyerId(), auction.getSellerId(), auction.getEAuctionStatus(),
                            auction.getProductId(), auction.getCategory()));
            return new ResponseEntity<>(_auction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Auction>> selectAllAuctions() {

        try {
            List<Auction> auctions = new ArrayList<Auction>();
            auctionService.selectAllAuctions().forEach(auctions::add);
            if (auctions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(auctions, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Auction> selectAuctionById(@PathVariable("id") Integer id) {

        Optional<Auction> auctionData = auctionService.selectAuctionById(id);
        if (auctionData.isPresent()) {
            return new ResponseEntity<>(auctionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Auction> updateAuctionById(@PathVariable("id") Integer id, @RequestBody Auction auction) {
        Optional<Auction> auctionData = auctionService.selectAuctionById(id);

        if (auctionData.isPresent()) {
            Auction _auction = auctionData.get();
            _auction.setTitle(auction.getTitle());
            _auction.setDescription(auction.getDescription());
            _auction.setMinPrice(auction.getMinPrice());
            _auction.setMaxPrice(auction.getMaxPrice());
            _auction.setStartDate(auction.getStartDate());
            _auction.setEndDate(auction.getEndDate());
            _auction.setEndDate(auction.getEndDate());
            _auction.setEndDate(auction.getEndDate());
            _auction.setEAuctionStatus(auction.getEAuctionStatus());
            _auction.setBuyerId(auction.getBuyerId());
            _auction.setSellerId(auction.getSellerId());
            _auction.setProductId(auction.getProductId());
            _auction.setCategory(auction.getCategory());

            return new ResponseEntity<>(auctionService.updateAuctionById(id, _auction), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteAuctionById(@PathVariable("id") Integer id) {

        try {
            auctionService.deleteAuctionById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
