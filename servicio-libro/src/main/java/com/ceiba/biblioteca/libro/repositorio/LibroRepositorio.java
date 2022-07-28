package com.ceiba.biblioteca.libro.repositorio;

import com.ceiba.biblioteca.libro.entidad.Categoria;
import com.ceiba.biblioteca.libro.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepositorio extends JpaRepository<Libro, Long> {

    public List<Libro> findByCategoria(Categoria categoria);
}
