package org.example.supermarket.application.service;

import org.example.supermarket.application.dto.WorkerDto;
import org.example.supermarket.domain.entity.Worker;
import org.example.supermarket.domain.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public WorkerDto createWorker(WorkerDto dto) {
        Worker worker = mapToEntity(dto);
        return mapToDto(workerRepository.save(worker));
    }

    @Override
    public void updateWorker(WorkerDto dto) {
        workerRepository.findById(dto.getWorkerId()).ifPresent(existing -> {
            existing.setEmail(dto.getEmail());
            existing.setPassword(dto.getPassword());
            existing.setDni(dto.getDni());
            existing.setNames(dto.getNames());
            existing.setSurNames(dto.getSurNames());
            existing.setPhone(dto.getPhone());
            existing.setAddress(dto.getAddress());
            workerRepository.save(existing);
        });
    }

    @Override
    public List<WorkerDto> getAllWorkers() {
        return workerRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeWorker(UUID id) {
        if (!workerRepository.existsById(id)) {
            throw new RuntimeException("Worker not found with ID: " + id);
        }
        workerRepository.deleteById(id);
    }

    @Override
    public WorkerDto getWorkerById(UUID id) {
        return workerRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Worker not found with ID: " + id));
    }

    // --- Mappers ---
    private WorkerDto mapToDto(Worker worker) {
        return WorkerDto.builder()
                .workerId(worker.getWorkerId())
                .email(worker.getEmail())
                .password(worker.getPassword())
                .dni(worker.getDni())
                .names(worker.getNames())
                .surNames(worker.getSurNames())
                .phone(worker.getPhone())
                .address(worker.getAddress())
                .build();
    }

    private Worker mapToEntity(WorkerDto dto) {
        return Worker.builder()
                .workerId(dto.getWorkerId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .dni(dto.getDni())
                .names(dto.getNames())
                .surNames(dto.getSurNames())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .build();
    }
}