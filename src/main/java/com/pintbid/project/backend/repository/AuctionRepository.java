package com.pintbid.project.backend.repository;

import com.pintbid.project.backend.models.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("auctionRepository")
public interface AuctionRepository extends JpaRepository<Auction,Integer> {


}
