package com.ceiba.biblioteca.prestamo.servicio;

import com.ceiba.biblioteca.prestamo.entidad.Prestamo;

import java.util.List;

public interface ServicioPrestamo {

    public List<Prestamo> buscarTodos();

    public Prestamo crear(Prestamo prestamo);
    public Prestamo actualizar(Prestamo prestamo);
    public Prestamo borrar(Prestamo prestamo);

    public Prestamo buscarPorNumero(String numero);
}
