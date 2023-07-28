package com.aseofresh.controller;

import com.aseofresh.domain.Cliente;
import com.aseofresh.domain.Producto;
import com.aseofresh.servicio.ProductoServicio;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> listadoProductos() {
        log.info("Listado de Clientes");
        return productoServicio.consultarProductos();
    }

    @PostMapping("/agregarProducto")
    public void crearProducto(@RequestBody Producto producto) {
        productoServicio.guardarProducto(producto);
        log.info("Producto Agregado");
    }

    @DeleteMapping("/eliminarProducto")
    public ResponseEntity<String> eliminarProducto(@RequestBody Producto producto) {
        if (producto.getIdProducto() == null) {
            return new ResponseEntity<>("ID de producto requerido para eliminar", HttpStatus.BAD_REQUEST);
        }

        Producto ProductoExistente = productoServicio.buscarProducto(producto);

        if (ProductoExistente == null) {
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
        
        productoServicio.eliminarProducto(producto);
        return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.OK);
    }
    
    
    @PutMapping("/actualizarProducto")
    public ResponseEntity<String> actualizarProducto(@RequestBody Producto productoDatosnuevos){
        if(productoDatosnuevos.getIdProducto()== null){
            return new ResponseEntity<>("ID de producto requerido para actualizar", HttpStatus.BAD_REQUEST);
        }
        Producto productoExistente = productoServicio.buscarProducto(productoDatosnuevos);
        
        if(productoExistente ==null ){
            return new ResponseEntity<>("Producto no encontrado", HttpStatus.NOT_FOUND);
        }
        
        productoExistente.setNombre(productoDatosnuevos.getNombre());
        productoExistente.setPrecio(productoDatosnuevos.getPrecio());
        productoExistente.setStock(productoDatosnuevos.getStock());
        
        productoServicio.guardarProducto(productoExistente);
        
        return new ResponseEntity<>("Producto actualizado correctamente", HttpStatus.OK);
    }
    
}
