package Group2.BWEProject.service;

import Group2.BWEProject.dao.AuctionDao;
import Group2.BWEProject.model.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuctionService {
    private final AuctionDao auctionDao;

    @Autowired
    public AuctionService(@Qualifier("auctionDao") AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    public Auction addAuction(Auction auction) {
        return  auctionDao.save(auction);
    }

    public List<Auction> selectAllAuctions() {
        return (List<Auction>) auctionDao.findAll();
    }

    ;

    public Optional<Auction> selectAuctionById(UUID id) {
        return auctionDao.findById(id);
    }

    ;

    public Auction updateAuctionById(UUID id, Auction auction) {
        return auctionDao.save(auction);
    }

    ;

    public void deleteAuctionById(UUID id) {
        auctionDao.deleteById(id);
    }

    ;


}
