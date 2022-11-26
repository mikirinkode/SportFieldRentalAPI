package com.example.sport.model;

import com.example.sport.constant.AppConstant;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
public class BaseDao {

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate() {
        this.createAt = LocalDateTime.now();
        this.createdBy = AppConstant.CREATE_BY_SYSTEM; // TODO: CHANGE LATER
        this.isDeleted = false;
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
