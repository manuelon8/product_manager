package org.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rest.ProductService;
import org.rest.dao.ProductsDAO;
import org.rest.entity.EProducto;
import org.rest.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p1")
public class ProductController {
	
	@Autowired
	@Qualifier("servicio")
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<EProducto> createProduct(@RequestBody EProducto p){
		if(productService.Crear(p)) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.noContent().build();
		}		
	}
	
	
	@DeleteMapping(value = "{producId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("producId") Long producId){
		productService.Borrar(producId);
			return ResponseEntity.ok(null);		 		
	}
	
	@PutMapping
	public ResponseEntity<EProducto> updateProduct(@RequestBody EProducto p){		
		if(productService.Actualizar(p)) {
			return ResponseEntity.ok(p);	
		}else
		{
			return ResponseEntity.ok(p);
		}		
	}

	
	@GetMapping
	public ResponseEntity<List<Producto>> getAllProduct(){		
		List<Producto> allProduct= new ArrayList<>(); 
		return ResponseEntity.ok(allProduct);		
	}
	
	@RequestMapping(value="hello", method = RequestMethod.GET)
	public String hello() {
		return "hello worl";
	}
}
