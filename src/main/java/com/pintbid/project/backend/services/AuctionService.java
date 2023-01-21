package com.pintbid.project.backend.services;

import com.pintbid.project.backend.models.Auction;
import com.pintbid.project.backend.repository.AuctionRepository;
import com.pintbid.project.backend.utils.EAuctionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionService(@Qualifier("auctionRepository") AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public Auction createAuction(Auction auction) {
        return  auctionRepository.save(auction);
    }

    public List<Auction> selectAllAuctions() {

        List<Auction> auctions = new ArrayList<>();
        auctionRepository.findAll()
                .forEach(auctions::add);
        return auctions;
    }

    public Optional<Auction> selectAuctionById(Integer id) {
        return auctionRepository.findById(id);
    }

    public Auction updateAuctionById(Integer id, Auction auction) {
        return auctionRepository.save(auction);
    }

    public Boolean deleteAuctionById(Integer id) {
        auctionRepository.deleteById(id);
        return true;
    }
    public List<Auction> getUnlockedAutions(){
      List<Auction> listOfAuctions = (List<Auction>) auctionRepository.findAll();
       return listOfAuctions.stream()
               .filter(auction -> auction.getEAuctionStatus().equals(EAuctionStatus.LOCKED))
               .collect(Collectors.toList());
    }



}
