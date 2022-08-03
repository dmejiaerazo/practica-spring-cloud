package com.ceiba.biblioteca.prestamo.clientesfeing;


import com.ceiba.biblioteca.prestamo.modelo.Libro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-libro", path = "/libros")
public interface ClienteServicioLibro {

    @GetMapping("{idLibro}")
    ResponseEntity<Libro> buscarPorId(@PathVariable Long idLibro);
}
