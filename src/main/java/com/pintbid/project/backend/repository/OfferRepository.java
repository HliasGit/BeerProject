package com.pintbid.project.backend.repository;


import com.pintbid.project.backend.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
