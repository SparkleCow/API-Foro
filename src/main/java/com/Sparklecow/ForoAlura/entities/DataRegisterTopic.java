package com.Sparklecow.ForoAlura.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataRegisterTopic(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull LocalDate fechaCreacion,
        @NotNull StatusTopic status,
        @NotBlank String autor,
        @NotBlank String curso){
}
