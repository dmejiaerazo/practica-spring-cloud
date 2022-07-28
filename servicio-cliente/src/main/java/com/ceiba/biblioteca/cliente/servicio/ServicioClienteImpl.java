package com.ceiba.biblioteca.cliente.servicio;

import com.ceiba.biblioteca.cliente.entidad.Cliente;
import com.ceiba.biblioteca.cliente.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioClienteImpl implements ServicioCliente {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarPorIdentificacion(String numero) {
        return clienteRepositorio.findByIdentificacion(numero);
    }

    @Override
    public Cliente crear(Cliente cliente) {
        Cliente clienteBD = buscarPorIdentificacion(cliente.getIdentificacion());

        if(clienteBD == null){
            return clienteRepositorio.save(cliente);
        }

        return clienteBD;
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        Cliente clienteBD = buscarPorId(cliente.getId());

        if(clienteBD == null){
            return null;
        }

        clienteBD.setNombre(cliente.getNombre());
        clienteBD.setIdentificacion(cliente.getIdentificacion());
        clienteBD.setCorreo(cliente.getCorreo());
        clienteBD.setEstado(cliente.getEstado());

        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente borrar(Long idCliente) {
        Cliente clienteBD = buscarPorId(idCliente);

        if(clienteBD == null){
            return null;
        }

        clienteBD.setEstado("Borrado");
        return clienteRepositorio.save(clienteBD);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }
}
