package Group2.BWEProject.api;

import Group2.BWEProject.model.Auction;
import Group2.BWEProject.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/auction")
@RestController
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @PostMapping
    public ResponseEntity<Auction> addAuction(@RequestBody Auction auction) {
       return new ResponseEntity<>(auctionService.addAuction(auction), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Auction> selectAllAuctions(){return auctionService.selectAllAuctions();}

    @GetMapping(path="/{id}")
    public Optional<Auction> selectAuctionById(@PathVariable("id") UUID id){return auctionService.selectAuctionById(id);}

    @PutMapping(path = "/{id}")
    public Auction updateAuctionById(@PathVariable("id") UUID id, @RequestBody Auction auction) {return auctionService.updateAuctionById(id, auction);}

    @DeleteMapping(path="/{id}")
    public void deleteAuctionById(@PathVariable("id") UUID id) {auctionService.deleteAuctionById(id);}
}
