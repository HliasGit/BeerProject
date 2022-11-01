package Group2.BWEProject.service;

import Group2.BWEProject.dao.OfferDao;
import Group2.BWEProject.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OfferService {
    private final OfferDao offerDao;

    @Autowired
    public OfferService(@Qualifier("offerDao") OfferDao offerDao) {
        this.offerDao = offerDao;
    }

    public List<Offer> selectAllOffers(){return offerDao.selectAllOffers();};

    public Offer selectOfferById(UUID id){return offerDao.selectOfferById(id);};

    public int deleteOfferById(UUID id){return offerDao.deleteOfferById(id);};

    public int updateOfferById(UUID id, Offer offer){return offerDao.updateOfferById(id, offer);};

    public int addOffer(Offer offer) {return offerDao.addOffer(offer);};
}
