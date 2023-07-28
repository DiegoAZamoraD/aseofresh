package com.aseofresh.controller;

import com.aseofresh.domain.Cliente;
import com.aseofresh.domain.Factura;
import com.aseofresh.servicio.FacturaServicio;
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
public class FacturaControlador {

    @Autowired
    private FacturaServicio facturaServicio;

    @GetMapping("/facturas")
    public List<Factura> listadoFacturas() {
        log.info("Listado de Facturas");
        return facturaServicio.consultarFacturas();
    }

    @PostMapping("/agregarFactura")
    public void crearFactura(@RequestBody Factura factura) {
        facturaServicio.guardarFactura(factura);
        log.info("Factura Agregada");
    }

    @DeleteMapping("/eliminarFactura")
    public ResponseEntity<String> eliminarFactura(@RequestBody Factura factura) {
        if (factura.getIdFactura()== null) {
            return new ResponseEntity<>("ID de factura requerido para eliminar", HttpStatus.BAD_REQUEST);
        }

        Factura facturaExistente = facturaServicio.buscarFactura(factura);

        if (facturaExistente == null) {
            return new ResponseEntity<>("Factura no encontrada", HttpStatus.NOT_FOUND);
        }
        
        facturaServicio.eliminarFactura(factura);
        return new ResponseEntity<>("Factura eliminada correctamente", HttpStatus.OK);
    }
    
    
    @PutMapping("/actualizarFactura")
    public ResponseEntity<String> actualizarFactura(@RequestBody Factura facturaDatosnuevos){
        if(facturaDatosnuevos.getIdFactura()== null){
            return new ResponseEntity<>("ID de factura requerido para actualizar", HttpStatus.BAD_REQUEST);
        }
        Factura facturaExistente = facturaServicio.buscarFactura(facturaDatosnuevos);
        
        if(facturaExistente ==null ){
            return new ResponseEntity<>("Factura no encontrada", HttpStatus.NOT_FOUND);
        }
        
        facturaExistente.setFecha(facturaDatosnuevos.getFecha());
        facturaExistente.setCliente(facturaDatosnuevos.getCliente());
        
        
        facturaServicio.guardarFactura(facturaExistente);
        
        return new ResponseEntity<>("Factura actualizada correctamente", HttpStatus.OK);
    }
    
}
