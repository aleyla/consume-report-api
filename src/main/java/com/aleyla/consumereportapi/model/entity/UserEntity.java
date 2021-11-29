package com.aleyla.consumereportapi.model.entity;

import com.aleyla.consumereportapi.enums.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

}
