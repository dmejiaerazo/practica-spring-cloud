package com.ceiba.biblioteca.prestamo.modelo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Libro {

    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String estado;
    private Categoria categoria;

}
