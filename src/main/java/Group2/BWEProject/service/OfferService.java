package Group2.BWEProject.service;

import Group2.BWEProject.dao.OfferDao;
import Group2.BWEProject.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OfferService {
    private final OfferDao offerDao;

    @Autowired
    public OfferService(@Qualifier("offerDao") OfferDao offerDao) {
        this.offerDao = offerDao;
    }

    public List<Offer> selectAllOffers(){
        return (List<Offer>) offerDao.findAll();
    }

    public Optional<Offer> selectOfferById(UUID id){
        return offerDao.findById(id);
    }

    public Boolean deleteOfferById(UUID id){
        offerDao.deleteById(id);
        return true;
    }

    public Offer updateOfferById(UUID id, Offer offer){
        return offerDao.save(offer);
    }

    public Offer addOffer(Offer offer) {
        return offerDao.save(offer);
    }
}
