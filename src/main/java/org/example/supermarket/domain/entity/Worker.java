package org.example.supermarket.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worker")
public class Worker implements BaseEntity<UUID> {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID workerId;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true, length = 20)
    private String dni;

    @Column(nullable = false, length = 50)
    private String names;

    @Column(nullable = false, length = 50)
    private String surNames;

    @Column(length = 20)
    private String phone;

    @Column(length = 150)
    private String address;

    // ✅ Implementación del método requerido por BaseEntity
    @Override
    public UUID getId() {
        return workerId;
    }
}
