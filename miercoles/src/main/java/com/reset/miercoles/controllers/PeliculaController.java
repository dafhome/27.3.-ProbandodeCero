package com.reset.miercoles.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reset.miercoles.entity.Peliculas;
import com.reset.miercoles.persisjpa.dto.PeliculaDTO;
import com.reset.miercoles.services.PeliculasServicio;

@RestController
@RequestMapping("/api")
public class PeliculaController {
    
    @Autowired
    private PeliculasServicio peliculasServicio;

    

    @GetMapping("/listarPeliculas")
    public List<Peliculas> consultarPeliculas() {
        return peliculasServicio.consultarPeliculas();
    }

    @PostMapping("/registrarPelicula")
    public Peliculas registrarPelicula (@RequestBody PeliculaDTO peliculaJson){
        
        Peliculas pelicula = new Peliculas();

        pelicula.setTituloPelicula(peliculaJson.getTituloPelicula());
        pelicula.setYearEstreno(peliculaJson.getYearEstreno());
        return peliculasServicio.registrarPelicula(pelicula);
        
    }

    @GetMapping("/listarPeliculaId/{id}")
    public Optional<Peliculas> listarId(@PathVariable UUID id) {
        return peliculasServicio.consultarUnaPelicula(id);
    }


    @DeleteMapping("/borrarPeliculaId/{id}")
    public void borrarId(@PathVariable UUID id) {
        peliculasServicio.borrarPelicula(id);
    }

 
    @PutMapping("/actualizarPelicula/{id}")
    public Peliculas modificarPelicula(@RequestBody PeliculaDTO peliculaJson, @PathVariable UUID id) {
        
        Optional<Peliculas> peliculaOP = listarId(id);
        
        if (!peliculaOP.isPresent()) {
            throw new IllegalArgumentException("Taquilla no encontrada");
        }
        Peliculas pelicula = peliculaOP.get();
        
        if (peliculaJson.getTituloPelicula()!=null) {
            pelicula.setTituloPelicula(peliculaJson.getTituloPelicula());
        }
        else if (peliculaJson.getYearEstreno()!=null) {
            pelicula.setYearEstreno(peliculaJson.getYearEstreno());
        }
        else{
            System.out.println("No cambiamos ningún campo.");
        }
        

        return peliculasServicio.registrarPelicula(pelicula);
    }

    // @PatchMapping("{id}/modificar")
    // public ResponseEntity<PeliculaDTO> completePelicula(@PathVariable("id") UUID id, @RequestBody PeliculaDTO peliculaJson){
    //     PeliculaDTO updatedPelicula = peliculasServicio.completePelicula(id);
    //     updatedPelicula.setTituloPelicula(peliculaJson.getTituloPelicula());
    //     updatedPelicula.setYearEstreno(peliculaJson.getYearEstreno());
    //     return updatedPelicula.registrarPelicula(updatedPelicula);
    //     // return ResponseEntity.ok(updatedPelicula);
    // }





}
