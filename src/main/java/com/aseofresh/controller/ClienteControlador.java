package com.aseofresh.controller;

import com.aseofresh.domain.Cliente;
import com.aseofresh.servicio.ClienteServicio;
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
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> listadoClientes() {
        log.info("Listado de Clientes");
        return clienteServicio.consultaClientes();
    }

    @PostMapping("/agregarCliente")
    public void crearCliente(@RequestBody Cliente cliente) {
        clienteServicio.guardarCliente(cliente);
        log.info("Cliente Agregado");
    }

    @DeleteMapping("/eliminarCliente")
    public ResponseEntity<String> eliminarCliente(@RequestBody Cliente cliente) {
        if (cliente.getIdCliente() == null) {
            return new ResponseEntity<>("ID de cliente requerido para eliminar", HttpStatus.BAD_REQUEST);
        }

        Cliente clienteExistente = clienteServicio.buscarCliente(cliente);

        if (clienteExistente == null) {
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
        
        clienteServicio.eliminarCliente(cliente);
        return new ResponseEntity<>("Cliente eliminado correctamente", HttpStatus.OK);
    }
    
    
    @PutMapping("/actualizarCliente")
    public ResponseEntity<String> actualizarCliente(@RequestBody Cliente clienteDatosnuevos){
        if(clienteDatosnuevos.getIdCliente()== null){
            return new ResponseEntity<>("ID de cliente requerido para actualizar", HttpStatus.BAD_REQUEST);
        }
        Cliente clienteExistente = clienteServicio.buscarCliente(clienteDatosnuevos);
        
        if(clienteExistente ==null ){
            return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
        }
        
        clienteExistente.setNombre(clienteDatosnuevos.getNombre());
        clienteExistente.setApellido(clienteDatosnuevos.getApellido());
        clienteExistente.setDireccion(clienteDatosnuevos.getDireccion());
        clienteExistente.setFechaNacimiento(clienteDatosnuevos.getFechaNacimiento());
        clienteExistente.setTelefono(clienteDatosnuevos.getTelefono());
        clienteExistente.setEmail(clienteDatosnuevos.getEmail());
        
        clienteServicio.guardarCliente(clienteExistente);
        
        return new ResponseEntity<>("Cliente actualizado correctamente", HttpStatus.OK);
    }
    
}
