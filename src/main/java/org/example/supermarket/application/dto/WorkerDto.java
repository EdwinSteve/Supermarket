package org.example.supermarket.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class WorkerDto {
    private UUID workerId;
    private String email;
    private String password;
    private String dni;
    private String names;
    private String surNames;
    private String phone;
    private String address;
}
