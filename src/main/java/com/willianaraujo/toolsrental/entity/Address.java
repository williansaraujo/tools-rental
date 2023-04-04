package com.willianaraujo.toolsrental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column (nullable = false)
    private Integer number;

    private String complement;

    @Column (nullable = false)
    private String neighborhood;

    @Column (nullable = false)
    private String city;

    @Column (nullable = false)
    private String state;

    @Column (name = "zip_code", nullable = false)
    private Integer zipCode;

    @Column (nullable = false)
    private String country;

    @ManyToOne (fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    private Boolean available;

    @Column(name="created_id", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name="updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = new Date();
    }
}
