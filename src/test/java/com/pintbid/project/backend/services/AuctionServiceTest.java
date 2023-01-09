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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuctionServiceTest {

    Auction auction1 = new Auction("test", "description", 12.2, 34.2, LocalDate.of(2012, 11, 13), LocalDate.of(2013, 11, 13), 12, 14, EAuctionStatus.ACTIVE, 34, "si");

    @Autowired
    private AuctionService auctionService;

    @MockBean
    private AuctionRepository auctionRepository;

    @BeforeEach
    void setup(){
        when(auctionRepository.save(auction1)).thenReturn(auction1);
    }

    @Test
    void createAuction() {
        Auction auc = auctionService.createAuction(auction1);
        assertEquals("test", auc.getTitle());
    }

    @Test
    void selectAllAuctions() {
    }

    @Test
    void selectAuctionById() {
    }

    @Test
    void updateAuctionById() {
    }

    @Test
    void deleteAuctionById() {
    }

    @Test
    void getUnlockedAutions() {
    }
}