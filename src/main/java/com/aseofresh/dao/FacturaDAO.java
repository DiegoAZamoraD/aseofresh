
package com.aseofresh.dao;

import com.aseofresh.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturaDAO extends JpaRepository<Factura, Long>{
    
}
