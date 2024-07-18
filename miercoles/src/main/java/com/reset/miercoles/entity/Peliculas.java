package com.reset.miercoles.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="peliculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peliculas {

    @Id
    @Column(name = "id_pelicula")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idPelicula;

    @Column(name = "titulo_pelicula")
    private String tituloPelicula;

    @Column(name = "year_estreno")
    private Integer yearEstreno;

    @JsonProperty(access = Access.READ_ONLY)
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }

    
    //Esto se sustituye con la dependencia Lombok mediante las anotaciones @Data+@AllArgsConstructor+@NoArgsConstructor
    //constructor vacio
    //constructor completo
    //getters
    //setters
    //toString

    
}
