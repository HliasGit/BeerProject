package Group2.BWEProject.dao;

import Group2.BWEProject.model.Auction;

import java.util.List;
import java.util.UUID;


public interface AuctionDao {

    int insertAuction(UUID id, Auction auction);

    default int addAuction(Auction auction){
        UUID id = UUID.randomUUID();
        return insertAuction(id, auction);
    }

    List<Auction> selectAllAuctions();

    Auction selectAuctionById(UUID id);

    Auction selectAuctionByState(Boolean isActive);

    int updateAuctionById(UUID id, Auction auction);

    int deleteAuctionById(UUID id);

}
