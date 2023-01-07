package com.pintbid.project.backend.services;

import com.pintbid.project.backend.models.Offer;
import com.pintbid.project.backend.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(@Qualifier("offerRepository") OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> selectAllOffers(){
        return (List<Offer>) offerRepository.findAll();
    }

    public Optional<Offer> selectOfferById(Integer id){
        return offerRepository.findById(id);
    }

    public Boolean deleteOfferById(Integer id){
        offerRepository.deleteById(id);
        return true;
    }

    public Offer updateOfferById(Integer id, Offer offer){
        return offerRepository.save(offer);
    }

    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }
}
