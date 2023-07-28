
package com.aseofresh.servicio;

import com.aseofresh.dao.ClienteDAO;
import com.aseofresh.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ClienteImpl implements ClienteServicio{

    @Autowired
    public ClienteDAO clienteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> consultaClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void guardarCliente(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void eliminarCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional
    public Cliente buscarCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
}
