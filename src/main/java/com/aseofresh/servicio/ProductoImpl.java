
package com.aseofresh.servicio;

import com.aseofresh.dao.ClienteDAO;
import com.aseofresh.dao.ProductoDAO;
import com.aseofresh.domain.Cliente;
import com.aseofresh.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductoImpl implements ProductoServicio{

    @Autowired
    public ProductoDAO productoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultarProductos() {
         return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public void guardarProducto(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void eliminarProducto(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional
    public Producto buscarProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    
}
