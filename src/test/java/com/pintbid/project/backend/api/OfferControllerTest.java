package com.pintbid.project.backend.api;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class OfferControllerTest {

    Offer offer1 = new Offer(12.2, 12, 13, true);
    Offer offer2 = new Offer(32.2, 13, 14, true);
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

    //TODO FIX THIS
    @Test
    void createOffer() {
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
}