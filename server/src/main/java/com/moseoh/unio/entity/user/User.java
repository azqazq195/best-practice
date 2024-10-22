package com.moseoh.unio.entity.user;

import com.moseoh.unio.entity._common.AuditableDate;
import com.moseoh.unio.entity._common.AuditableUser;
import com.moseoh.unio.entity.IdentifiableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class User extends IdentifiableEntity {

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Embedded
    private AuditableDate auditableDate;

    @Embedded
    private AuditableUser auditableUser;
}
