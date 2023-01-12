package com.pintbid.project.backend.services;


import com.pintbid.project.backend.models.Offer;
import com.pintbid.project.backend.repository.OfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class OfferServiceTest {

    Offer offer1 = new Offer(12.5,1, 1, true);
    Offer offer2 = new Offer(13.4,2, 2, false);
    List<Offer> list = new ArrayList<>();

    @Autowired
    private OfferService offerService;

    @MockBean
    private OfferRepository offerRepository;

    @BeforeEach
    void setup(){
        list.add(offer1);
        list.add(offer2);
        doNothing().when(offerRepository).deleteById(offer1.getId());
        when(offerRepository.findAll()).thenReturn(list);
        when(offerRepository.save(offer1)).thenReturn(offer1);
        when(offerRepository.findById(offer1.getId())).thenReturn(Optional.ofNullable(offer1));
    }

    @Test
    public void testSelectAllOffers(){
        Integer id = offer1.getId();
        Offer offerFound = offerService.selectAllOffers().get(0);
        assertEquals(id, offerFound.getId());
    }

    @Test
    public void testSelectOfferById(){
        Integer id = offer1.getId();
        Optional<Offer> offerFound = offerService.selectOfferById(offer1.getId());
        assertEquals(id, offerFound.get().getId());
    }

    @Test
    public void testAddOffer(){
        Integer id = offer1.getId();
        Offer offerFound = offerService.addOffer(offer1);
        assertEquals(id, offerFound.getId());
    }

    @Test
    public void testUpdateOffer(){
        Integer id = offer1.getId();
        Offer offerFound = offerService.updateOfferById(offer2.getId(), offer1);
        assertEquals(id, offerFound.getId());
    }

    @Test
    public void testDeleteById(){
        Boolean res = offerService.deleteOfferById(offer1.getId());
        assertEquals(res, true);
    }
}