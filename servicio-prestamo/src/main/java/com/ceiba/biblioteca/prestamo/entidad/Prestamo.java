package com.ceiba.biblioteca.prestamo.entidad;

import com.ceiba.biblioteca.prestamo.modelo.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;

    @Transient
    private Cliente cliente;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prestamo_detalle")
    private List<PrestamoDetalle> prestamoDetalle;

    private String estado;
}
