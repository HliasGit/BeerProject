package com.pintbid.project.backend.api;

import com.pintbid.project.backend.models.Auction;
import com.pintbid.project.backend.services.AuctionService;
import com.pintbid.project.backend.utils.EAuctionStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class AuctionControllerTest {

    Auction auction1 = new Auction("test", "description", 12.2, 34.2, LocalDate.of(2012, 11, 13), LocalDate.of(2013, 11, 13), 12, 14, EAuctionStatus.ACTIVE, 34, "si");
    Auction auction2 = new Auction( "test2", "description2", 12.2, 34.2, LocalDate.of(2012, 11, 13), LocalDate.of(2013, 11, 13), 12, 14, EAuctionStatus.ACTIVE, 35, "si");
    ResponseEntity<Auction> entity = new ResponseEntity<Auction>(auction1, HttpStatus.CREATED);
    ResponseEntity<Auction> entity2 = new ResponseEntity<Auction>(auction2, HttpStatus.OK);
    List<Auction> list = new ArrayList<>();

    @Autowired
    private AuctionController auctionController;

    @MockBean
    private AuctionService auctionService;

    @BeforeEach()
    void setup(){
        list.add(auction1);
        list.add(auction2);
        when(auctionService.createAuction(auction1)).thenReturn(auction1);
        when(auctionService.selectAllAuctions()).thenReturn(list);
        when(auctionService.selectAuctionById(auction1.getId())).thenReturn(Optional.ofNullable(auction1));
        when(auctionService.updateAuctionById(auction2.getId(), auction1)).thenReturn(auction1);
    }

    //TODO this test doesn't work and I don't know why
    @Test
    void createAuction() {
        ResponseEntity<Auction> result = auctionController.createAuction(auction1);
        assertEquals(result.getBody(), auction1);
    }

    @Test
    void selectAllAuctions() {
        ResponseEntity<List<Auction>> test = auctionController.selectAllAuctions();
        List<Auction> list = test.getBody();
        Auction res = list.get(0);
        assertEquals(res, auction1);
    }

    @Test
    void selectAuctionById() {
        ResponseEntity<Auction> test = auctionController.selectAuctionById(auction1.getId());
        assertEquals(test.getBody(), auction1);
    }

    @Test
    void updateAuctionById() {
        Integer id = auction1.getId();
        ResponseEntity<Auction> test = auctionController.updateAuctionById(auction2.getId(), auction1);
        assertEquals(id, test.getBody().getId());
    }

    @Test
    void deleteAuctionById() {
    }
}