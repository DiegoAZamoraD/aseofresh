
package com.aseofresh.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente" )
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    private String direccion;
    
    @NotEmpty
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    
    @NotEmpty
    private String telefono;
    
    @NotEmpty
    @Email
    private String email;
}
