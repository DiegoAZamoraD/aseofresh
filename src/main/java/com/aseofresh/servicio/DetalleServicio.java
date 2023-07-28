
package com.aseofresh.servicio;

import com.aseofresh.domain.Detalle;
import java.util.List;
import org.springframework.http.ResponseEntity;


public interface DetalleServicio {
    
    public List<Detalle> consultarDetalles();
    
    public ResponseEntity<Detalle> guardarDetalle(Detalle detalle);
    
    public void eliminarDetalle(Detalle detalle);
    
    public Detalle buscarDetalle(Detalle detalle);
    
}
