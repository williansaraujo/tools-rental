package com.willianaraujo.toolsrental.entity;

import jakarta.persistence.*;
import java.util.Date;


@Entity
public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private Integer phone;

    private Boolean available;

    @Column(name = "created_at", insertable = true, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", updatable = true, nullable = false)
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
