package com.aseofresh.controller;

import com.aseofresh.domain.Detalle;
import com.aseofresh.servicio.DetalleServicio;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DetalleControlador {

    @Autowired
    private DetalleServicio detalleServicio;

    @GetMapping("/detalles")
    public List<Detalle> listadoDetalles() {
        log.info("Listado de Facturas");
        return detalleServicio.consultarDetalles();
    }

    @PostMapping("/agregarDetalle")
    public ResponseEntity<Detalle> crearDetalle(@RequestBody Detalle detalle) {
        return detalleServicio.guardarDetalle(detalle);
    }
//

    @DeleteMapping("/eliminarDetalle")
    public ResponseEntity<String> eliminarDetalle(@RequestBody Detalle detalle) {
        if (detalle.getIdDetalle() == null) {
            return new ResponseEntity<>("ID de detalle requerido para eliminar", HttpStatus.BAD_REQUEST);
        }

        Detalle detalleExistente = detalleServicio.buscarDetalle(detalle);

        if (detalleExistente == null) {
            return new ResponseEntity<>("Detalle no encontrada", HttpStatus.NOT_FOUND);
        }

        detalleServicio.eliminarDetalle(detalle);
        return new ResponseEntity<>("Detalle eliminado correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizarDetalle")
    public ResponseEntity<String> actualizarDetalle(@RequestBody Detalle detalleDatosnuevos){
        if(detalleDatosnuevos.getIdDetalle()== null){
            return new ResponseEntity<>("ID de detalle requerido para actualizar", HttpStatus.BAD_REQUEST);
        }
        Detalle detalleExistente = detalleServicio.buscarDetalle(detalleDatosnuevos);
        
        if(detalleExistente ==null ){
            return new ResponseEntity<>("Detalle no encontrado", HttpStatus.NOT_FOUND);
        }
        
        detalleExistente.setFactura(detalleDatosnuevos.getFactura());
        detalleExistente.setProducto(detalleDatosnuevos.getProducto());
        detalleExistente.setCantidad(detalleDatosnuevos.getCantidad());
        detalleExistente.setPrecio(detalleDatosnuevos.getPrecio());
        
        detalleServicio.guardarDetalle(detalleExistente);
        return new ResponseEntity<>("Detalle actualizado correctamente", HttpStatus.OK);
    }
//    @PutMapping("/actualizarDetalle/{idDetalle}")
//    public ResponseEntity<Detalle> actualizarDetalle(@PathVariable Long idDetalle, @RequestBody Detalle detalleDatosNuevos) {
//        Detalle detalleExistente = detalleServicio.buscarDetalle(idDetalle);
//        if (detalleExistente == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        detalleExistente.setFactura(detalleDatosNuevos.getFactura());
//        detalleExistente.setProducto(detalleDatosNuevos.getProducto());
//        detalleExistente.setCantidad(detalleDatosNuevos.getCantidad());
//        detalleExistente.setPrecio(detalleDatosNuevos.getPrecio());
//        
//        detalleServicio.guardarDetalle(detalleExistente);
//        return new ResponseEntity<>(detalleExistente,HttpStatus.OK);
//
//    }

}
