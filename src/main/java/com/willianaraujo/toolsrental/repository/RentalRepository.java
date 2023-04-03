package com.willianaraujo.toolsrental.repository;

import com.willianaraujo.toolsrental.entity.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rentals, Long> {
}
