package Group2.BWEProject.dao;

import Group2.BWEProject.model.Offer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeOfferDao")
public class FakeOfferDataAccessService implements OfferDao {

    private static List<Offer> DBOffers = new ArrayList<>();

    @Override
    public int insertOffer(UUID id, Offer offer) {
        DBOffers.add(new Offer(id, offer.getOfferingPrice(), offer.getUser(), offer.getAuction(), offer.isAccepted()));
        return 1;
    }

    @Override
    public List<Offer> selectAllOffers() {
        return DBOffers;
    }

    @Override
    public Offer selectOfferById(UUID id) {
        for (Offer of:DBOffers){
            if(of.getId().equals(id)) {
                return of;
            }
        }
        return null;
    }

    @Override
    public int deleteOfferById(UUID id) {
        for (Offer of:DBOffers){
            if (of.getId().equals(id)){
                DBOffers.remove(of);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updateOfferById(UUID id, Offer offer) {
        for (Offer of:DBOffers){
            if(of.getId().equals(id)){
                DBOffers.remove(of);
                DBOffers.add(offer);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int addOffer(Offer offer) {
        DBOffers.add(offer);
        return 1;
    }
}