package Group2.BWEProject.api;

import Group2.BWEProject.model.Offer;
import Group2.BWEProject.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/offers")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public ResponseEntity<Offer> addOffer(@Valid @RequestBody Offer offer) {
        return new ResponseEntity<>(offerService.addOffer(offer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Offer>> selectAllOffers() {
        return new ResponseEntity<>(offerService.selectAllOffers(), HttpStatus.FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Offer>> selectOfferById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(offerService.selectOfferById(id), HttpStatus.FOUND);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Offer> updateOfferById(@PathVariable("id") UUID id, @RequestBody Offer offer) {
        return new ResponseEntity<>(offerService.updateOfferById(id, offer), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteOfferById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(offerService.deleteOfferById(id), HttpStatus.OK);
    }
}
