package Group2.BWEProject.dao;

import Group2.BWEProject.model.Offer;

import java.util.List;
import java.util.UUID;


public interface OfferDao {

    int insertOffer(UUID id, Offer offer);

    default int insertOffer(Offer offer){
        UUID id = UUID.randomUUID();
        return insertOffer(id, offer);
    }

    List<Offer> selectAllOffers();

    Offer selectOfferById(UUID id);

    int deleteOfferById(UUID id);

    int updateOfferById(UUID id, Offer offer);

    int addOffer(Offer offer);
}
