package com.pintbid.project.backend.api;

import com.pintbid.project.backend.models.Auction;
import com.pintbid.project.backend.models.Offer;
import com.pintbid.project.backend.services.OfferService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class OfferControllerTest {

    Offer offer1 = new Offer(12.2, 12, 13, true, 200, LocalDate.of(2018, 10, 23));
    Offer offer2 = new Offer(32.2, 13, 14, true, 500, LocalDate.of(2019, 11, 19));
    List<Offer> list = new ArrayList();

    @Autowired
    private OfferController offerController;

    @MockBean
    private OfferService offerService;

    @BeforeEach()
    void setup(){
        list.add(offer1);
        list.add(offer2);
        when(offerService.updateOfferById(offer1.getId(), offer1)).thenReturn(offer1);
        when(offerService.selectAllOffers()).thenReturn(list);
        when(offerService.selectOfferById(offer1.getId())).thenReturn(Optional.ofNullable(offer1));
        when(offerService.deleteOfferById(offer1.getId())).thenReturn(true);
    }

    @Test
    void createOffer() {
        when(offerService.addOffer(any())).thenReturn(offer1);
        ResponseEntity<Offer> res = offerController.createOffer(offer1);
        assertEquals(res.getBody(), offer1);
    }

    @Test
    void selectAllOffers() {
        ResponseEntity<List<Offer>> res = offerController.selectAllOffers();
        assertEquals(res.getBody().get(0), offer1);
    }

    @Test
    void selectOfferById() {
        ResponseEntity<Offer> res = offerController.selectOfferById(offer1.getId());
        assertEquals(res.getBody(), offer1);
    }

    @Test
    void updateOfferById() {
        ResponseEntity<Offer> res = offerController.updateOfferById(offer1.getId(), offer2);
        assertEquals(res.getBody(), offer1);
    }

    @Test
    void deleteOfferById() {
        ResponseEntity<Boolean> res = offerController.deleteOfferById(offer1.getId());
        assertEquals(res.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    void offerByIDNotFound(){
        Offer offerNotFound = new Offer();
        offerNotFound.setId(13);
        ResponseEntity<Offer> res = offerController.updateOfferById(offerNotFound.getId(), offer1);
        assertEquals(res.getStatusCode(),HttpStatus.NOT_FOUND);
    }

    @Test
    void testSelectOfferByID_NotFound(){
        Offer not_found = new Offer();
        not_found.setId(13);
        when(offerService.selectOfferById(13)).thenReturn(Optional.empty());
        ResponseEntity<Offer> res = offerController.selectOfferById(not_found.getId());
        assertEquals(res.getStatusCode(),HttpStatus.NOT_FOUND);
    }
}