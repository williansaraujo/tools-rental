package com.willianaraujo.toolsrental.repository;

import com.willianaraujo.toolsrental.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
