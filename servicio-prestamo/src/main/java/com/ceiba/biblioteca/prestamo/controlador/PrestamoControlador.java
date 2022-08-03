package com.ceiba.biblioteca.prestamo.controlador;

import com.ceiba.biblioteca.prestamo.clientesfeing.ClienteServicioCliente;
import com.ceiba.biblioteca.prestamo.clientesfeing.ClienteServicioLibro;
import com.ceiba.biblioteca.prestamo.entidad.Prestamo;
import com.ceiba.biblioteca.prestamo.entidad.PrestamoDetalle;
import com.ceiba.biblioteca.prestamo.modelo.Cliente;
import com.ceiba.biblioteca.prestamo.modelo.Libro;
import com.ceiba.biblioteca.prestamo.servicio.ServicioPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prestamos")
public class PrestamoControlador {

    @Autowired
    private ServicioPrestamo servicioPrestamo;

    @Autowired
    private ClienteServicioCliente clienteServicioCliente;

    @Autowired
    private ClienteServicioLibro clienteServicioLibro;

    @GetMapping
    public ResponseEntity<List<Prestamo>> listarTodos() {
        List<Prestamo> prestamos = servicioPrestamo.buscarTodos();
        if (prestamos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping(value = "{numero}")
    public ResponseEntity<Prestamo> obtenerPorId(@PathVariable String numero) {
        Prestamo prestamo = servicioPrestamo.buscarPorNumero(numero);
        if (null == prestamo) {
            return ResponseEntity.notFound().build();
        }

        Cliente cliente = clienteServicioCliente.buscarPorId(prestamo.getIdCliente()).getBody();
        prestamo.setCliente(cliente);

        List<PrestamoDetalle> prestamos = prestamo.getPrestamoDetalle().stream().map(detalle->{
            detalle.setLibro(clienteServicioLibro.buscarPorId(detalle.getIdLibro()).getBody());
            return detalle;
        }).collect(Collectors.toList());

        prestamo.setPrestamoDetalle(prestamos);

        return ResponseEntity.ok(prestamo);
    }

    @PostMapping
    public ResponseEntity<Prestamo> crear(@RequestBody Prestamo prestamo) {
        Prestamo prestamoBD = servicioPrestamo.crear(prestamo);
        return ResponseEntity.ok(prestamoBD);
    }

    @PutMapping
    public ResponseEntity<Prestamo> updateInvoice(@RequestBody Prestamo prestamo) {

        Prestamo prestamoBD = servicioPrestamo.actualizar(prestamo);

        if (prestamoBD == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestamoBD);
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Prestamo> borrar(@PathVariable String numero) {
        Prestamo prestamoBD = servicioPrestamo.buscarPorNumero(numero);
        if (prestamoBD == null) {
            return ResponseEntity.notFound().build();
        }

        servicioPrestamo.borrar(prestamoBD);

        return ResponseEntity.ok(prestamoBD);
    }

}
