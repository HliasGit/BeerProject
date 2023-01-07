package com.pintbid.project.backend.repository;


import com.pintbid.project.backend.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
