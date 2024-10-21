package com.test.instagramservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "instagram_follow")
public class Follow {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "follow_by")
    private Long followBy;

    @Column
    private boolean active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
