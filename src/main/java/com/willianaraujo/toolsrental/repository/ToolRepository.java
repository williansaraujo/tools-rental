package com.willianaraujo.toolsrental.repository;

import com.willianaraujo.toolsrental.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Long> {
}
