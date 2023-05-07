package com.Sparklecow.ForoAlura.entities;

import java.time.LocalDate;

public record DatosTopics(Long id, String titulo, String mensaje, LocalDate fechaCreacion, boolean finalizado, String autor, String curso) {
}
