
package com.aseofresh.dao;

import com.aseofresh.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteDAO extends JpaRepository<Cliente, Long>{
    
}
