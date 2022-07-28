package com.ceiba.biblioteca.prestamo.controlador;

import com.ceiba.biblioteca.prestamo.entidad.Prestamo;
import com.ceiba.biblioteca.prestamo.servicio.ServicioPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoControlador {

    @Autowired
    private ServicioPrestamo servicioPrestamo;

    @GetMapping
    public ResponseEntity<List<Prestamo>> listarTodos() {
        List<Prestamo> prestamos = servicioPrestamo.buscarTodos();
        if (prestamos.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(prestamos);
    }

    @GetMapping(value = "{numero}")
    public ResponseEntity<Prestamo> obtenerPorId(@PathVariable String numero) {
        Prestamo prestamo  = servicioPrestamo.buscarPorNumero(numero);
        if (null == prestamo) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(prestamo);
    }

    @PostMapping
    public ResponseEntity<Prestamo> crear(@RequestBody Prestamo prestamo) {
        Prestamo prestamoBD = servicioPrestamo.crear(prestamo);
        return  ResponseEntity.ok(prestamoBD);
    }

    @PutMapping
    public ResponseEntity<Prestamo> updateInvoice(@RequestBody Prestamo prestamo) {

        Prestamo prestamoBD = servicioPrestamo.actualizar(prestamo);

        if (prestamoBD == null) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(prestamoBD);
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Prestamo> borrar(@PathVariable String numero) {
        Prestamo prestamoBD = servicioPrestamo.buscarPorNumero(numero);
        if (prestamoBD == null) {
            return  ResponseEntity.notFound().build();
        }

        servicioPrestamo.borrar(prestamoBD);

        return ResponseEntity.ok(prestamoBD);
    }

}
