package com.Sparklecow.ForoAlura.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name="topics")
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    public Long id;
    public String titulo;
    public String mensaje;
    public LocalDate fechaCreacion;
    @Enumerated(EnumType.STRING)
    public StatusTopic status;
    public String autor;
    public String curso;

    public Topic(DataRegisterTopic dataRegisterTopic) {
        this.titulo = dataRegisterTopic.titulo();
        this.mensaje = dataRegisterTopic.mensaje();
        this.fechaCreacion = dataRegisterTopic.fechaCreacion();
        this.status = dataRegisterTopic.status();
        this.autor = dataRegisterTopic.autor();
        this.curso = dataRegisterTopic.curso();
    }

    public void updateTopic(DataUpdateTopic dataUpdateTopic) {
        if(dataUpdateTopic.titulo()!=null){
            this.titulo = dataUpdateTopic.titulo();
        }if(dataUpdateTopic.mensaje()!=null){
            this.mensaje = dataUpdateTopic.mensaje();
        }if(dataUpdateTopic.status()!=null){
            this.status = dataUpdateTopic.status();
        }
    }
}
