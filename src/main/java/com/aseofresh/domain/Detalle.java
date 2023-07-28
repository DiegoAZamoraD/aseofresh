package com.aseofresh.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Data
@Table(name = "detalle")
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_detalle")
    private Long idDetalle;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_factura") 
    Factura factura;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_producto") 
    Producto producto;
    
    private int cantidad;
    
    private BigDecimal precio;
    
    
    
}
