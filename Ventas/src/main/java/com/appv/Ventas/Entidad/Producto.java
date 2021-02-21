package com.appv.Ventas.Entidad;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Producto")
public class Producto {
	private String idProducto;
	private String descripcion;
	private float valorUnitario;
	private int cantidad;
	public Producto() {
		super();
	}
	
	public Producto(String idProducto, String descripcion, float valorUnitario, int cantidad) {
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.valorUnitario = valorUnitario;
		this.cantidad = cantidad;
	}

	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
