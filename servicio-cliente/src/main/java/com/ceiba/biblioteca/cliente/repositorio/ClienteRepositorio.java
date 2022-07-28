package com.ceiba.biblioteca.cliente.repositorio;

import com.ceiba.biblioteca.cliente.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    public Cliente findByIdentificacion(String numero);

}