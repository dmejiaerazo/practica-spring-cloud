package com.ceiba.biblioteca.prestamo.entidad;

import com.ceiba.biblioteca.prestamo.modelo.Libro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Libro libro;

    @Column(name = "id_libro")
    private Long idLibro;

    private int cantidad;
    private Double precio;

    @Transient
    private Double subTotal;

    public Double getSubTotal() {
        if (this.precio >0  && this.cantidad >0 ){
            return this.cantidad * this.precio;
        }else {
            return (double) 0;
        }
    }
}
