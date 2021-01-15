package com.groupproject.repository;

import com.groupproject.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails , Long> {
}
