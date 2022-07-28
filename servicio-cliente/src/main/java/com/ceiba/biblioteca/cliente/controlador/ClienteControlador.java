package com.ceiba.biblioteca.cliente.controlador;

import com.ceiba.biblioteca.cliente.entidad.Cliente;
import com.ceiba.biblioteca.cliente.servicio.ServicioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteControlador {
    @Autowired
    private ServicioCliente servicioCliente;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = servicioCliente.buscarTodos();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("{idCliente}")
    public ResponseEntity<Cliente> buscarPorId(
            @PathVariable Long idCliente) {
        Cliente cliente = servicioCliente.buscarPorId(idCliente);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/identificacion/{numeroIdentificacion}")
    public ResponseEntity<Cliente> buscarPorNumeroIdentificacion(
            @PathVariable String numeroIdentificacion) {
        Cliente cliente = servicioCliente.buscarPorIdentificacion(numeroIdentificacion);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = servicioCliente.crear(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente) {
        Cliente clienteActualizar = servicioCliente.actualizar(cliente);

        if (clienteActualizar == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(clienteActualizar);
    }

    @DeleteMapping("{idCliente}")
    public ResponseEntity<Cliente> eliminar(
            @PathVariable Long idCliente) {
        Cliente cliente = servicioCliente.borrar(idCliente);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }
}
