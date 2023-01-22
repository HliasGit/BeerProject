package com.pintbid.project.backend.api;

import com.pintbid.project.backend.models.Auction;
import com.pintbid.project.backend.services.AuctionService;
import com.pintbid.project.backend.utils.EAuctionCategory;
import com.pintbid.project.backend.utils.EAuctionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("api/auctions")
@RestController
public class AuctionController {
    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {this.auctionService = auctionService;}

    @PostMapping
    public ResponseEntity<Auction> createAuction(@Valid @RequestBody Auction auction) {
        try {
            Auction _auction = auctionService
                    .createAuction(new Auction(auction.getTitle(), auction.getDescription(), auction.getMinPrice(),
                            auction.getMaxPrice(), auction.getStartDate(), auction.getEndDate(),
                            auction.getBuyerId(), auction.getSellerId(), auction.getEAuctionStatus(),
                            auction.getProductId(), auction.getCategory()));
            return new ResponseEntity<>(_auction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Auction>> selectAllAuctions() {

        try {
            List<Auction> auctions = new ArrayList<Auction>();
            auctionService.selectAllAuctions().forEach(auctions::add);
            if (auctions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(auctions, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Auction> selectAuctionById(@PathVariable("id") Integer id) {

        Optional<Auction> auctionData = auctionService.selectAuctionById(id);
        if (auctionData.isPresent()) {
            return new ResponseEntity<>(auctionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

      //  return auctionData.map(auction -> new ResponseEntity<>(auction, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Auction> updateAuctionById(@PathVariable("id") Integer id, @RequestBody Auction auction) {
        Optional<Auction> auctionData = auctionService.selectAuctionById(id);

        if (auctionData.isPresent()) {
            Auction _auction = auctionData.get();
            _auction.setTitle(auction.getTitle());
            _auction.setDescription(auction.getDescription());
            _auction.setMinPrice(auction.getMinPrice());
            _auction.setMaxPrice(auction.getMaxPrice());
            _auction.setStartDate(auction.getStartDate());
            _auction.setEndDate(auction.getEndDate());
            _auction.setEndDate(auction.getEndDate());
            _auction.setEndDate(auction.getEndDate());
            _auction.setEAuctionStatus(auction.getEAuctionStatus());
            _auction.setBuyerId(auction.getBuyerId());
            _auction.setSellerId(auction.getSellerId());
            _auction.setProductId(auction.getProductId());
            _auction.setCategory(auction.getCategory());

            return new ResponseEntity<>(auctionService.updateAuctionById(id, _auction), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteAuctionById(@PathVariable("id") Integer id) {

        try {
            auctionService.deleteAuctionById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/category/{category}")
    public ResponseEntity<List<Auction>>selectAuctionByCategory(@PathVariable("category") EAuctionCategory category) {

        List<Auction> auctions = new ArrayList<Auction>();
        auctionService.selectAllAuctions().forEach(auctions::add);

        List<Auction> auctionByCategory = auctions.stream()
                .filter(auction -> auction.getCategory().equals(category))
                .collect(Collectors.toList());
        ;
        if (!auctionByCategory.isEmpty()) {
            return new ResponseEntity<>(auctionByCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/status/{status}")
    public ResponseEntity<List<Auction>>selectAuctionByStatus(@PathVariable("status") EAuctionStatus status) {

        List<Auction> auctions = new ArrayList<Auction>();
        auctionService.selectAllAuctions().forEach(auctions::add);

        List<Auction> auctionByStatus = auctions.stream()
                .filter(auction -> auction.getEAuctionStatus().equals(status))
                .collect(Collectors.toList());
        ;
        if (!auctionByStatus.isEmpty()) {
            return new ResponseEntity<>(auctionByStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/date/{endDate}")
    public ResponseEntity<List<Auction>> selectByEndDate(@PathVariable("endDate") LocalDate endDate) {

        List<Auction> auctions = new ArrayList<Auction>();
        auctionService.selectAllAuctions().forEach(auctions::add);

        List<Auction> auctionByEndDate = auctions.stream()
                .filter(auction -> auction.getEndDate().equals(endDate))
                .collect(Collectors.toList());
        ;
        if (!auctionByEndDate.isEmpty()) {
            return new ResponseEntity<>(auctionByEndDate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //  return auctionData.map(auction -> new ResponseEntity<>(auction, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}
