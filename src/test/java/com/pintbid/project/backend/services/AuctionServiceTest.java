package com.pintbid.project.backend.services;

import com.pintbid.project.backend.models.Auction;
import com.pintbid.project.backend.repository.AuctionRepository;
import com.pintbid.project.backend.utils.EAuctionStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuctionServiceTest {

    Auction auction1 = new Auction("test", "description", 12.2, 34.2, LocalDate.of(2012, 11, 13), LocalDate.of(2013, 11, 13), 12, 14, EAuctionStatus.ACTIVE, 34, "si");
    Auction auction2 = new Auction("test2", "description2", 12.2, 34.2, LocalDate.of(2012, 11, 13), LocalDate.of(2013, 11, 13), 12, 14, EAuctionStatus.LOCKED, 35, "si");
    List<Auction> list = new ArrayList<>();
    List<Auction> listUnl = new ArrayList<>();

    @Autowired
    private AuctionService auctionService;

    @MockBean
    private AuctionRepository auctionRepository;

    @BeforeEach
    void setup(){
        list.add(auction1);
        list.add(auction2);
        listUnl.add(auction2);
        when(auctionRepository.save(auction1)).thenReturn(auction1);
        when(auctionRepository.findAll()).thenReturn(list);
        when(auctionRepository.findById(auction1.getId())).thenReturn(Optional.ofNullable(auction1));
    }

    @Test
    void createAuction() {
        Auction auc = auctionService.createAuction(auction1);
        assertEquals("test", auc.getTitle());
    }

    @Test
    void selectAllAuctions() {
        Integer id = auction1.getId();
        Auction test = auctionService.selectAllAuctions().get(0);
        assertEquals(id, test.getId());
    }

    @Test
    void selectAuctionById() {
        Integer id = auction1.getId();
        Optional<Auction> auctionFound = auctionService.selectAuctionById(auction1.getId());
        assertEquals(id, auctionFound.get().getId());
    }

    @Test
    void updateAuctionById() {
        Integer id = auction1.getId();
        Auction auc = auctionService.updateAuctionById(auction2.getId(), auction1);
        assertEquals(id, auc.getId());
    }

    @Test
    void deleteAuctionById() {
    }

    @Test
    void getUnlockedAutions() {
        List<Auction> listOfAuctions = (List<Auction>) auctionService.getUnlockedAutions();
        assertEquals(listUnl, listOfAuctions);
    }
}