package com.moseoh.unio.entity._common;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Getter
@Embeddable
public class AuditableUser {
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private Long createdBy;

    @LastModifiedBy
    @Column(nullable = false)
    private Long updatedBy;
}