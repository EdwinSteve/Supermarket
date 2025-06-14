package org.example.supermarket.application.mapper;

import org.example.supermarket.application.dto.WorkerDto;
import org.example.supermarket.domain.entity.Worker;

public final class WorkerMapper implements Mapper<Worker, WorkerDto> {

    public static WorkerMapper getInstance() {
        return new WorkerMapper();
    }

    @Override
    public WorkerDto mapTo(Worker worker) {
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

    @Override
    public Worker mapFrom(WorkerDto dto) {
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
