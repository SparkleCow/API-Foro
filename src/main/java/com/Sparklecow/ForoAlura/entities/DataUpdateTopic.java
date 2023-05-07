package com.Sparklecow.ForoAlura.entities;

import jakarta.validation.constraints.NotNull;

public record DataUpdateTopic(@NotNull Long id, String titulo, String mensaje, StatusTopic status){

}
