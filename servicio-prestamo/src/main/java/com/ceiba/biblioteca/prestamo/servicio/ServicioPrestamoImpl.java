package com.ceiba.biblioteca.prestamo.servicio;

import com.ceiba.biblioteca.prestamo.entidad.Prestamo;
import com.ceiba.biblioteca.prestamo.repositorio.PrestamoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioPrestamoImpl implements ServicioPrestamo{

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;


    @Override
    public List<Prestamo> buscarTodos() {
        return prestamoRepositorio.findAll();
    }

    @Override
    public Prestamo crear(Prestamo prestamo) {

        Prestamo prestamoBD = buscarPorNumero(prestamo.getNumero());

        if(prestamoBD != null) {
            return prestamoBD;
        }

        Calendar calendar = Calendar.getInstance();

        prestamo.setFechaCreacion(calendar.getTime());
        calendar.add(Calendar.DATE, 7);
        prestamo.setFechaEntrega(calendar.getTime());
        prestamo.setEstado("Activo");
        return prestamoRepositorio.save(prestamo);
    }

    @Override
    public Prestamo actualizar(Prestamo prestamo) {
        Prestamo prestamoBD = buscarPorNumero(prestamo.getNumero());

        if(prestamoBD == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();

        prestamoBD.setNumero(prestamo.getNumero());
        prestamoBD.setFechaCreacion(calendar.getTime());
        calendar.add(Calendar.DATE, 7);
        prestamoBD.setFechaEntrega(calendar.getTime());
        prestamoBD.setCliente(prestamo.getCliente());
        prestamoBD.getPrestamoDetalle().clear();
        prestamoBD.setPrestamoDetalle(prestamo.getPrestamoDetalle());

        return prestamoRepositorio.save(prestamoBD);

    }

    @Override
    public Prestamo borrar(Prestamo prestamo) {
        Prestamo prestamoBD = buscarPorNumero(prestamo.getNumero());

        if(prestamoBD == null) {
            return null;
        }

        prestamoBD.setEstado("Borrado");
        return prestamoRepositorio.save(prestamoBD);
    }

    @Override
    public Prestamo buscarPorNumero(String numero) {
        return prestamoRepositorio.findByNumero(numero);
    }
}
