package com.reset.miercoles.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reset.miercoles.entity.Peliculas;

//JpaRepository<TipodeDatos,TipoID>

public interface PeliculaRepositorio extends JpaRepository<Peliculas, UUID> {
    
    //Se pueden añadir extra métodos si los necesitamos

}
