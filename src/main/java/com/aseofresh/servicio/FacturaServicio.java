
package com.aseofresh.servicio;

import com.aseofresh.domain.Factura;
import java.util.List;


public interface FacturaServicio {
    
    public List<Factura> consultarFacturas();
    
    public void guardarFactura(Factura factura);
    
    public void eliminarFactura(Factura factura);
    
    public Factura buscarFactura(Factura factura);
}
