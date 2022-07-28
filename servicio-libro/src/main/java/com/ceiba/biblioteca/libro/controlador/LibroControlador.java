package com.ceiba.biblioteca.libro.controlador;

import com.ceiba.biblioteca.libro.entidad.Categoria;
import com.ceiba.biblioteca.libro.entidad.Libro;
import com.ceiba.biblioteca.libro.servicio.ServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/libros")
public class LibroControlador {

    @Autowired
    private ServicioLibro servicioLibro;

    @GetMapping
    public ResponseEntity<List<Libro>> listar() {
        List<Libro> libros = servicioLibro.listarTodos();
        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<Libro>> buscarPorCategoria(
            @PathVariable Long idCategoria) {
        Categoria categoria = Categoria.builder().id(idCategoria).build();
        List<Libro> libros = servicioLibro.buscarPorCategoria(categoria);
        if (libros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libros);
    }

    @GetMapping("{idLibro}")
    public ResponseEntity<Libro> buscarPorId(
            @PathVariable Long idLibro) {
        Libro libro = servicioLibro.obtenerPorId(idLibro);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<Libro> crear(@RequestBody Libro libro) {
        Libro nuevoLibro = servicioLibro.crear(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    @PutMapping
    public ResponseEntity<Libro> actualizar(@RequestBody Libro libro) {
        Libro libroActualizar = servicioLibro.actualizar(libro);

        if (libroActualizar == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(libroActualizar);
    }

    @DeleteMapping("{idLibro}")
    public ResponseEntity<Libro> eliminar(
            @PathVariable Long idLibro) {
        Libro libro = servicioLibro.borrar(idLibro);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PutMapping("/{idLibro}/cantidad/{cantidad}")
    public ResponseEntity<Libro> actualizarCantidad(
            @PathVariable Long idLibro, @PathVariable int cantidad) {
        Libro libro = servicioLibro.actualizarCantidad(idLibro,cantidad);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

}
