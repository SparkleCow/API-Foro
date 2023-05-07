package com.Sparklecow.ForoAlura.entities;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DataResponseTopic(Long id, String titulo, String mensaje, LocalDate fechaCreacion,
                                StatusTopic status, String autor, String curso) {
}
