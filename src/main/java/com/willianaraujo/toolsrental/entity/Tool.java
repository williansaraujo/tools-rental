package com.willianaraujo.toolsrental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "rental_rate_per_day", nullable = false)
    private BigDecimal rentalRatePerDay;

    @Column(name = "photo_file_path")
    private String photoFilePath;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "tool_id", nullable = false)
    private ToolGroup toolGroupId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "owner_address_id", nullable = false)
    private Address ownerAddressId;

    private Boolean available;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreated(){
        createdAt = new Date();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdated(){
        updatedAt = new Date();
    }

}
