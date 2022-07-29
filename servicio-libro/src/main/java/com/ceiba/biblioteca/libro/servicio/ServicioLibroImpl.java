package com.ceiba.biblioteca.libro.servicio;

import com.ceiba.biblioteca.libro.entidad.Categoria;
import com.ceiba.biblioteca.libro.entidad.Libro;
import com.ceiba.biblioteca.libro.repositorio.LibroRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioLibroImpl implements ServicioLibro{

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listarTodos() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro obtenerPorId(Long id) {
        return libroRepositorio.findById(id).orElse(null);
    }

    @Override
    public Libro crear(Libro libro) {
        Libro libroBD = obtenerPorId(libro.getId());

        if(libroBD == null){
            return libroRepositorio.save(libro);
        }

        return libroBD;
    }

    @Override
    public Libro actualizar(Libro libro) {
        Libro libroBD = obtenerPorId(libro.getId());

        if(libroBD == null){
            return null;
        }

        libroBD.setNombre(libro.getNombre());
        libroBD.setDescripcion(libro.getDescripcion());
        libroBD.setCategoria(libro.getCategoria());
        libroBD.setEstado(libro.getEstado());

        return libroRepositorio.save(libroBD);
    }

    @Override
    public Libro borrar(Long idLibro) {
        Libro libroBD = obtenerPorId(idLibro);

        if(libroBD == null){
            return null;
        }

        libroBD.setEstado("Eliminado");

        return libroRepositorio.save(libroBD);
    }

    @Override
    public List<Libro> buscarPorCategoria(Categoria categoria) {
        return libroRepositorio.findByCategoria(categoria);
    }

    @Override
    public Libro actualizarCantidad(Long id, int cantidad) {
        Libro libroBD = obtenerPorId(id);

        if(libroBD == null){
            return null;
        }

        int nuevaCantidad = libroBD.getCantidad() + cantidad;
        libroBD.setCantidad(nuevaCantidad);

        return libroRepositorio.save(libroBD);
    }
}
