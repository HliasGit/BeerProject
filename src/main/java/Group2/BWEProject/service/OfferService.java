package Group2.BWEProject.service;

import Group2.BWEProject.repository.OfferRepository;
import Group2.BWEProject.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<Offer> selectOfferById(UUID id){
        return offerRepository.findById(id);
    }

    public Boolean deleteOfferById(UUID id){
        offerRepository.deleteById(id);
        return true;
    }

    public Offer updateOfferById(UUID id, Offer offer){
        return offerRepository.save(offer);
    }

    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }
}
