package Group2.BWEProject.dao;

import Group2.BWEProject.model.Auction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("auctionDao")
public class AuctionDataAccessService implements AuctionDao {

    private static List<Auction> DBAuction = new ArrayList<>();

    @Override
    public int addAuction(Auction auction) {
        DBAuction.add(new Auction(auction.getTitle(), auction.getDateOfStart(), auction.getDateOfEnd(), auction.getBuyerId(), auction.getSellerId(), auction.getActive()));
        return 1;
    }


    @Override
    public List<Auction> selectAllAuctions() {
        return DBAuction;
    }

    @Override
    public Auction selectAuctionById(UUID id) {
        for (Auction auction : DBAuction) {
            if (auction.getId().equals(id)) {
                return auction;
            }
        }
        return null;
    }

    @Override
    public Auction selectAuctionByState(Boolean isActive) {
        for (Auction auction : DBAuction) {
            if (auction.getActive()) {
                return auction;
            }
        }
        return null;
    }

    @Override
    public int deleteAuctionById(UUID id) {
        for (Auction auction : DBAuction) {
            if (auction.getId().equals(id)) {
                DBAuction.remove(auction);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updateAuctionById(UUID id, Auction auction) {
        for (Auction au : DBAuction) {
            if (au.getId().equals(id)) {
                DBAuction.remove(auction);
                DBAuction.add(auction);
                return 1;
            }
        }
        return 0;
    }
}