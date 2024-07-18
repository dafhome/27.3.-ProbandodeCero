package com.reset.miercoles.services;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reset.miercoles.entity.Peliculas;
import com.reset.miercoles.exeption.ResourceNotFoundException;
import com.reset.miercoles.persisjpa.dto.PeliculaDTO;
import com.reset.miercoles.repository.PeliculaRepositorio;

@Service
public class PeliculasServicio {

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    public List<Peliculas> consultarPeliculas(){
        return peliculaRepositorio.findAll();
    }

    public Optional<Peliculas> consultarUnaPelicula(UUID id){
        return peliculaRepositorio.findById(id);
    }


    public Peliculas registrarPelicula(Peliculas pelicula){
        System.out.println("Pelicula creada correctamente.");
        return peliculaRepositorio.save(pelicula);
    }

    public void borrarPelicula(UUID id){
        peliculaRepositorio.deleteById(id);
        System.out.println("Pelicula borrada correctamente.");
    }

    public PeliculaDTO completePelicula(UUID id){
        Peliculas pelicula = peliculaRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pelicula not found with id : " + id));

        Peliculas updatedPelicula = peliculaRepositorio.save(pelicula);

        return mapToPeliculaDto(updatedPelicula);
   
    }

    private PeliculaDTO mapToPeliculaDto(Peliculas pelicula){
        PeliculaDTO peliculadto = new PeliculaDTO();
        peliculadto.setTituloPelicula(pelicula.getTituloPelicula());
        peliculadto.setYearEstreno(pelicula.getYearEstreno());
        return peliculadto;
    }


}
