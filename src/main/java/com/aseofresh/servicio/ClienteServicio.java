
package com.aseofresh.servicio;

import com.aseofresh.domain.Cliente;
import java.util.List;


public interface ClienteServicio {
    
    public List<Cliente> consultaClientes();
    
    public void guardarCliente(Cliente cliente);
    
    public void eliminarCliente(Cliente cliente);
    
    public Cliente buscarCliente(Cliente cliente);
}
