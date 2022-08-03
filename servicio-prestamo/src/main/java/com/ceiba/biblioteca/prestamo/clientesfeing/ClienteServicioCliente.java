package com.ceiba.biblioteca.prestamo.clientesfeing;


import com.ceiba.biblioteca.prestamo.modelo.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "servicio-cliente", path = "/clientes")
public interface ClienteServicioCliente {

    @GetMapping("{idCliente}")
    ResponseEntity<Cliente> buscarPorId(@PathVariable Long idCliente);

}
