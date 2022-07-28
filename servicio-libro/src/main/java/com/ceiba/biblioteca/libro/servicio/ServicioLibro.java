package com.ceiba.biblioteca.libro.servicio;

import com.ceiba.biblioteca.libro.entidad.Categoria;
import com.ceiba.biblioteca.libro.entidad.Libro;

import java.util.List;

public interface ServicioLibro {
    public List<Libro> listarTodos();
    public Libro obtenerPorId(Long id);
    public Libro crear(Libro libro);
    public Libro actualizar(Libro libro);
    public Libro borrar(Long id);
    public List<Libro> buscarPorCategoria(Categoria categoria);
    public Libro actualizarCantidad(Long id, int cantidad);
}
