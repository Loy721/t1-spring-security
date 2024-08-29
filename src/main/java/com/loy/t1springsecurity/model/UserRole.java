package com.loy.t1springsecurity.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class UserRole {
    @Id
    @GeneratedValue(generator = "roles_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "roles_seq", allocationSize = 5)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", nullable = false, unique = true)
    private RoleType roleType;
}
