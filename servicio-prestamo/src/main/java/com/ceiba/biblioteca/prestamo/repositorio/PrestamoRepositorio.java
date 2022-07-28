package com.ceiba.biblioteca.prestamo.repositorio;

import com.ceiba.biblioteca.prestamo.entidad.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {

    public List<Prestamo> findByIdCliente(Long customerId );
    public Prestamo findByNumero(String numero);
}
