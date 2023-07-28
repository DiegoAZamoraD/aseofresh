
package com.aseofresh.dao;

import com.aseofresh.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDAO extends JpaRepository<Producto, Long>{
    
}
