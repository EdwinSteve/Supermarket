package org.example.supermarket.application.service;

import org.example.supermarket.application.dto.WorkerDto;

import java.util.List;
import java.util.UUID;

public interface WorkerService {
    WorkerDto createWorker(WorkerDto workerDto);
    void updateWorker(WorkerDto workerDto);
    List<WorkerDto> getAllWorkers();
    void removeWorker(UUID id);
    WorkerDto getWorkerById(UUID id);
}
