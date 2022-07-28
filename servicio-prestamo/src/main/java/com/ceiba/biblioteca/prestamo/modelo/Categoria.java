package com.ceiba.biblioteca.prestamo.modelo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Categoria {

    private Long id;
    private String nombre;
}
