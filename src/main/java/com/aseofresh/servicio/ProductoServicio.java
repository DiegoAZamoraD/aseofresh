
package com.aseofresh.servicio;

import com.aseofresh.domain.Producto;
import java.util.List;


public interface ProductoServicio {
    
    public List<Producto> consultarProductos();
    
    public void guardarProducto(Producto producto);
    
    public void eliminarProducto(Producto producto);
    
    public Producto buscarProducto(Producto producto);
}
