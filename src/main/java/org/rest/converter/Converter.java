package org.rest.converter;

import java.util.ArrayList;
import java.util.List;

import org.rest.entity.EProducto;
import org.rest.model.*;
import org.springframework.stereotype.Component;

@Component("convertidor")
public class Converter  {
	
	public List<Producto> convertirProducto(List<EProducto> productos){
		List<Producto> modelProducto= new ArrayList<>();
		
		for(EProducto ep: productos) {
			modelProducto.add(new Producto(ep));
		}	
		
		return modelProducto;
	}
	

}
