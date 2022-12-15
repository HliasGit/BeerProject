package Group2.BWEProject.service;

import Group2.BWEProject.model.Offer;
import Group2.BWEProject.model.User;
import Group2.BWEProject.repository.OfferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class OfferServiceTest {

    Offer offer1 = new Offer(12.5, UUID.randomUUID(), UUID.randomUUID(), true);
    Offer offer2 = new Offer(13.4, UUID.randomUUID(), UUID.randomUUID(), false);
    List<Offer> list = new ArrayList<>();

    @Autowired
    private OfferService offerService;

    @MockBean
    private OfferRepository offerRepository;

    @BeforeEach
    void setup(){
        list.add(offer1);
        list.add(offer2);

        //TODO DELETE METHOD
        when(offerRepository.findAll()).thenReturn(list);
        when(offerRepository.save(offer1)).thenReturn(offer1);
        when(offerRepository.findById(offer1.getId())).thenReturn(Optional.ofNullable(offer1));
    }

    @Test
    public void testSelectAllOffers(){
        UUID id = offer1.getId();
        Offer offerFound = offerService.selectAllOffers().get(0);
        assertEquals(id, offerFound.getId());
    }

    @Test
    public void testSelectOfferById(){
        UUID id = offer1.getId();
        Optional<Offer> offerFound = offerService.selectOfferById(offer1.getId());
        assertEquals(id, offerFound.get().getId());
    }

    @Test
    public void testAddOffer(){
        UUID id = offer1.getId();
        Offer offerFound = offerService.addOffer(offer1);
        assertEquals(id, offerFound.getId());
    }

    @Test
    public void testUpdateOffer(){
        UUID id = offer1.getId();
        Offer offerFound = offerService.updateOfferById(offer2.getId(), offer1);
        assertEquals(id, offerFound.getId());
    }

    //TODO DELETE METHOD
}