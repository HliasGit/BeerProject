package Group2.BWEProject.api;

import Group2.BWEProject.model.Offer;
import Group2.BWEProject.model.User;
import Group2.BWEProject.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public void addOffer(@RequestBody Offer offer) {
        offerService.addOffer(offer);
    }

    @GetMapping
    public List<Offer> selectAllOffers(){return offerService.selectAllOffers();};

    @GetMapping(path="/{id}")
    public Offer selectOfferById(@PathVariable("id") UUID id){return offerService.selectOfferById(id);};

    @PutMapping(path = "/{id}")
    public int updateOfferById(@PathVariable("id") UUID id, @RequestBody Offer offer) {return offerService.updateOfferById(id, offer);};

    @DeleteMapping(path="/{id}")
    public int deleteOfferById(@PathVariable("id") UUID id) {return offerService.deleteOfferById(id);};
}
