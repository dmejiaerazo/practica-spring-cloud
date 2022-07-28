package com.ceiba.biblioteca.prestamo.modelo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {

    private Long id;
    private String nombre;
    private String identificacion;
    private String correo;
    private String estado;
}
