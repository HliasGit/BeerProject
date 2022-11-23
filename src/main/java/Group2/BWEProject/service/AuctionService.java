package Group2.BWEProject.service;

import Group2.BWEProject.repository.AuctionRepository;
import Group2.BWEProject.model.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionService(@Qualifier("auctionRepository") AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public Auction addAuction(Auction auction) {
        return  auctionRepository.save(auction);
    }

    public List<Auction> selectAllAuctions() {
        return (List<Auction>) auctionRepository.findAll();
    }

    public Optional<Auction> selectAuctionById(UUID id) {
        return auctionRepository.findById(id);
    }

    public Auction updateAuctionById(UUID id, Auction auction) {
        return auctionRepository.save(auction);
    }

    public Boolean deleteAuctionById(UUID id) {
        auctionRepository.deleteById(id);
        return true;
    }

}
