package com.Sparklecow.ForoAlura.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name="topics")
public class Topic {

    @Id
    @GeneratedValue (strategy= GenerationType.AUTO)
    public Long id;
    public String titulo;
    public String mensaje;
    public LocalDate fechaCreacion;
    public Boolean finalizado;
    public String autor;
    public String curso;
}
