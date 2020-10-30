package org.rest;

import org.rest.dao.ProductsDAO;
import org.rest.entity.EProducto;
import org.rest.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.rest.converter.Converter;

@Service("servicio")
public class ProductService {
		
		
	@Autowired
	@Qualifier("repositorio")
	private ProductsDAO  repositorio; 
	
	@Autowired
	@Qualifier("convertidor")
	private Converter convertidor;
	
	
	public boolean Crear(EProducto p) {
		try {
			repositorio.save(p);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	public EProducto Obtener(Long id) {
		try {
			EProducto p=new EProducto();
			Optional<EProducto> optionalProduct=repositorio.findById(id);
			if(optionalProduct.isPresent()) {
				EProducto epx=optionalProduct.get();
				return epx;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public boolean Actualizar(EProducto p) {
		try {			
			EProducto p1=new EProducto();
			Optional<EProducto> optionalProduct=repositorio.findById(p.getId());
			if(optionalProduct.isPresent()) {
				EProducto epx=optionalProduct.get();
				epx.setDescripcion(p.getDescripcion());
				epx.setStock(p.getStock());
				epx.setCategoria(p.getCategoria());
				repositorio.save(epx);
			}
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	
	public boolean Borrar(Long id) {
		try {
			repositorio.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public List<Producto> ListadoProducto() {	
		return convertidor.convertirProducto(repositorio.findAll());		 
	}
	
	
	
}
