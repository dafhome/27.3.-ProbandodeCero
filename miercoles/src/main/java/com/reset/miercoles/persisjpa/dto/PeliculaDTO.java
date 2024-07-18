package com.reset.miercoles.persisjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDTO {

    private String tituloPelicula;
    private Integer yearEstreno;
}
