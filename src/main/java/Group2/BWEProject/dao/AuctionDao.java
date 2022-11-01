package Group2.BWEProject.dao;

import Group2.BWEProject.model.Auction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface AuctionDao  {

    default int addAuction(Auction auction){
        return addAuction(auction);
    }

    List<Auction> selectAllAuctions();

    Auction selectAuctionById(UUID id);

    Auction selectAuctionByState(Boolean isActive);

    int updateAuctionById(UUID id, Auction auction);

    int deleteAuctionById(UUID id);

}
