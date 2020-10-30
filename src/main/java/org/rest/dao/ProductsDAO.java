package org.rest.dao;

import java.util.List;

import org.rest.entity.EProducto;
import org.rest.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositorio")
public interface ProductsDAO extends JpaRepository<EProducto, Long> {
	
	 
	

}
