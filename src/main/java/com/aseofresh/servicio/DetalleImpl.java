
package com.aseofresh.servicio;

import com.aseofresh.dao.DetalleDAO;
import com.aseofresh.domain.Detalle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetalleImpl implements DetalleServicio{

    @Autowired
    public DetalleDAO detalleDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Detalle> consultarDetalles() {
        return (List<Detalle>) detalleDao.findAll(); 
    }

    @Override
    @Transactional
    public ResponseEntity<Detalle> guardarDetalle(Detalle detalle) {
        Detalle nuevoDetalle=detalleDao.save(detalle);
        return new ResponseEntity<>(nuevoDetalle,HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public void eliminarDetalle(Detalle detalle) {
        detalleDao.delete(detalle);
    }

    @Override
    public Detalle buscarDetalle(Detalle detalle) {
         return detalleDao.findById(detalle.getIdDetalle()).orElse(null);
    }
    

 


    
}
