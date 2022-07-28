package com.ceiba.biblioteca.cliente.servicio;

import com.ceiba.biblioteca.cliente.entidad.Cliente;

import java.util.List;

public interface ServicioCliente {
    public List<Cliente> buscarTodos();
    public Cliente buscarPorIdentificacion(String nombre);
    public Cliente crear(Cliente cliente);
    public Cliente actualizar(Cliente cliente);
    public Cliente borrar(Long cliente);
    public Cliente buscarPorId(Long id);
}
