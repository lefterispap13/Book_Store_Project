package com.groupproject.repository;

import com.groupproject.entities.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepository extends JpaRepository<Pricing , Long> {
}
