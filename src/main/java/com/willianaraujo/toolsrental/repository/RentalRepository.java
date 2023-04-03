package com.willianaraujo.toolsrental.repository;

import com.willianaraujo.toolsrental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
