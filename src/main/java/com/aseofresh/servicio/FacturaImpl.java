
package com.aseofresh.servicio;

import com.aseofresh.dao.FacturaDAO;
import com.aseofresh.domain.Factura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaImpl implements FacturaServicio{

    @Autowired
    public FacturaDAO facturaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Factura> consultarFacturas() {
        return (List<Factura>) facturaDao.findAll(); 
    }

    @Override
    @Transactional
    public void guardarFactura(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void eliminarFactura(Factura factura) {
        facturaDao.delete(factura);
    }

    @Override
    public Factura buscarFactura(Factura factura) {
        return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }
    
}
