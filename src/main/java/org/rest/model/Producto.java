package org.rest.model;

import java.io.Serializable;

import org.rest.entity.EProducto;

public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String descripcion;
	private int stock;
	private String categoria;
	
	
	
	
	public Producto(EProducto ep) {		 
		this.id = ep.getId();
		this.descripcion = ep.getDescripcion();
		this.stock = ep.getStock();
		this.categoria = ep.getCategoria();
	}
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(String descripcion, int stock, String categoria) {
		super();
		this.descripcion = descripcion;
		this.stock = stock;
		this.categoria = categoria;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", stock=" + stock + ", categoria=" + categoria
				+ "]";
	}
	
	

}
