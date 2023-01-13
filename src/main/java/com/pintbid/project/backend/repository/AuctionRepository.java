package com.pintbid.project.backend.repository;

import com.pintbid.project.backend.models.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("auctionRepository")
public interface AuctionRepository extends JpaRepository<Auction,Integer> {


}
