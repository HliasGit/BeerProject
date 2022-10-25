package Group2.BWEProject.api;

import Group2.BWEProject.model.Auction;
import Group2.BWEProject.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping
    public void addAuction(@RequestBody Auction auction) {
        auctionService.addAuction(auction);
    }

    @GetMapping
    public List<Auction> selectAllAuctions(){return auctionService.selectAllAuctions();};

    @GetMapping(path="/{id}")
    public Auction selectAuctionById(@PathVariable("id") UUID id){return auctionService.selectAuctionById(id);};

    @PutMapping(path = "/{id}")
    public int updateAuctionById(@PathVariable("id") UUID id, @RequestBody Auction auction) {return auctionService.updateAuctionById(id, auction);};

    @DeleteMapping(path="/{id}")
    public int deleteAuctionById(@PathVariable("id") UUID id) {return auctionService.deleteAuctionById(id);};
}
