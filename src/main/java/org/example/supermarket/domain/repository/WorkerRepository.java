package org.example.supermarket.domain.repository;

import org.example.supermarket.domain.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
    Worker findByEmail(String email);
    boolean existsByDni(String dni);
}
