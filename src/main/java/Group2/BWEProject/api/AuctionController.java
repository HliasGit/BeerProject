package Group2.BWEProject.api;

import Group2.BWEProject.model.Auction;
import Group2.BWEProject.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("api/v1/auctions")
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
    public ResponseEntity<List<Auction>> selectAllAuctions() {
        return new ResponseEntity<>(auctionService.selectAllAuctions(), HttpStatus.FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Auction>> selectAuctionById(@PathVariable("id") UUID id) {
        return new ResponseEntity(auctionService.selectAuctionById(id), HttpStatus.FOUND);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Auction> updateAuctionById(@PathVariable("id") UUID id, @RequestBody Auction auction) {
        return new ResponseEntity<>(auctionService.updateAuctionById(id, auction), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteAuctionById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(auctionService.deleteAuctionById(id), HttpStatus.OK);
    }
}
