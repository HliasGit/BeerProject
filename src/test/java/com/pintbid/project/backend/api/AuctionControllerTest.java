package com.pintbid.project.backend.api;

import com.pintbid.project.backend.models.Auction;
import com.pintbid.project.backend.services.AuctionService;
import com.pintbid.project.backend.utils.EAuctionCategory;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class AuctionControllerTest {

    Auction auction1 = new Auction("test", "description", 12.2, 34.2, LocalDate.of(2012, 11, 13), LocalDate.of(2013, 11, 13), 12, 14, EAuctionStatus.ACTIVE, 34, EAuctionCategory.WINE);
    Auction auction2 = new Auction( "test2", "description2", 12.2, 34.2, LocalDate.of(2012, 12, 13), LocalDate.of(2013, 12, 13), 12, 14, EAuctionStatus.LOCKED, 35, EAuctionCategory.BEER);
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
        when(auctionService.deleteAuctionById(auction1.getId())).thenReturn(true);
        when(auctionService.createAuction(auction1)).thenReturn(auction1);
        when(auctionService.selectAllAuctions()).thenReturn(list);
        when(auctionService.selectAuctionById(auction1.getId())).thenReturn(Optional.ofNullable(auction1));
        when(auctionService.updateAuctionById(auction2.getId(), auction1)).thenReturn(auction1);
    }

    @Test
    void createAuction() {
        when(auctionService.createAuction(any())).thenReturn(auction1);
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
    void selectAuctionById_Success() {
        ResponseEntity<Auction> test = auctionController.selectAuctionById(auction1.getId());
        assertEquals(test.getBody(), auction1);
    }

    @Test
    void updateAuctionById_Success() {
        Integer id = auction1.getId();
        ResponseEntity<Auction> test = auctionController.updateAuctionById(auction2.getId(), auction1);
        assertEquals(id, test.getBody().getId());
    }

    @Test
    void deleteAuctionById_Success() {
        ResponseEntity<Boolean> res = auctionController.deleteAuctionById(auction1.getId());
        assertEquals(res.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    void testSelectAuctionByCategory_Success() {
        when(auctionService.selectAllAuctions()).thenReturn(Arrays.asList(auction1, auction2));
        ResponseEntity<List<Auction>> response = auctionController.selectAuctionByCategory(EAuctionCategory.WINE);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(EAuctionCategory.WINE, response.getBody().get(0).getCategory());
    }

    @Test
    void testSelectAuctionByCategory_NotFound() {
        when(auctionService.selectAllAuctions()).thenReturn(Arrays.asList(auction1, auction2));
        ResponseEntity<List<Auction>> response = auctionController.selectAuctionByCategory(EAuctionCategory.PACKAGE_OF_WINE);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testSelectAuctionByStatus_Success() {
        when(auctionService.selectAllAuctions()).thenReturn(Arrays.asList(auction1, auction2));
        ResponseEntity<List<Auction>> response = auctionController.selectAuctionByStatus(EAuctionStatus.LOCKED);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(EAuctionStatus.LOCKED, response.getBody().get(0).getEAuctionStatus());
    }

    @Test
    void testSelectAuctionByStatus_NotFound() {
        when(auctionService.selectAllAuctions()).thenReturn(Arrays.asList(auction1, auction2));
        ResponseEntity<List<Auction>> response = auctionController.selectAuctionByStatus(EAuctionStatus.CLOSED);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testSelectByEndDate_Success() {
        LocalDate endDate1 = LocalDate.of(2022, 1, 1);
        when(auctionService.selectAllAuctions()).thenReturn(Arrays.asList(auction1, auction2));
        ResponseEntity<List<Auction>> response = auctionController.selectByEndDate(auction1.getEndDate());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        assertEquals(auction1.getEndDate(), response.getBody().get(0).getEndDate());
    }

    @Test
    void testSelectByEndDate_NotFound() {
        LocalDate endDateNotUsed = LocalDate.of(2021,3,4);
        when(auctionService.selectAllAuctions()).thenReturn(Arrays.asList(auction1, auction2));
        ResponseEntity<List<Auction>> response = auctionController.selectByEndDate(endDateNotUsed);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testUpdateAuctionByID_notFound(){
        Auction not_found = new Auction();
        not_found.setId(13);
        ResponseEntity<Auction> res = auctionController.updateAuctionById(not_found.getId(), auction1);
        assertEquals(res.getStatusCode(),HttpStatus.NOT_FOUND);
    }

    @Test
    void testSelectAuctionByID_NotFound(){
        Auction not_found = new Auction();
        not_found.setId(13);
        when(auctionService.selectAuctionById(13)).thenReturn(Optional.empty());
        ResponseEntity<Auction> res = auctionController.selectAuctionById(not_found.getId());
        assertEquals(res.getStatusCode(),HttpStatus.NOT_FOUND);
    }

    @Test
    void selectAllAuctionsButIsEmpty(){
        when(auctionService.selectAllAuctions()).thenReturn(new ArrayList<>());
        ResponseEntity<List<Auction>> res = auctionController.selectAllAuctions();
        assertEquals(HttpStatus.NO_CONTENT, res.getStatusCode());
    }
}