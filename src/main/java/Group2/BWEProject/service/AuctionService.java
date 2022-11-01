package Group2.BWEProject.service;

import Group2.BWEProject.dao.AuctionDao;
import Group2.BWEProject.model.Auction;
import Group2.BWEProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuctionService {
    private final AuctionDao auctionDao;

    @Autowired
    public AuctionService(@Qualifier("auctionDao") AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    public int addAuction(Auction auction) {
        return auctionDao.addAuction(auction);
    }

    public List<Auction> selectAllAuctions() {
        return auctionDao.selectAllAuctions();
    }

    ;

    public Auction selectAuctionById(UUID id) {
        return auctionDao.selectAuctionById(id);
    }

    ;

    public int updateAuctionById(UUID id, Auction auction) {
        return auctionDao.updateAuctionById(id, auction);
    }

    ;

    public int deleteAuctionById(UUID id) {
        return auctionDao.deleteAuctionById(id);
    }

    ;


}
