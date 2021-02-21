package com.appv.Ventas.Entidad;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PedidoVenta")
public class pedidoVenta {
	@Id
	private String id;
	private String numeroPedido;
	private String fechaVenta;
	private double totalProductos;
	private List<articulo> articulos;
	private String fechaEntrega;
	private String descripcion;
	
	protected pedidoVenta() {
		this.articulos = new ArrayList<>();
	}
	
	public pedidoVenta(String fechaVenta, double totalProductos, List<articulo> articulos, String fechaEntrega,
			String descripcion) {
		super();
		this.fechaVenta = fechaVenta;
		this.totalProductos = totalProductos;
		this.articulos = articulos;
		this.fechaEntrega = fechaEntrega;
		this.descripcion = descripcion;
	}
	
	
	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getId() {
		return id;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public double getTotalProductos() {
		return totalProductos;
	}
	public void setTotalProductos(double totalProductos) {
		this.totalProductos = totalProductos;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<articulo> articulos) {
		this.articulos = articulos;
	}

	public pedidoVenta(String numeroPedido, String fechaVenta, double totalProductos, List<articulo> articulos,
			String fechaEntrega, String descripcion) {
		super();
		this.numeroPedido = numeroPedido;
		this.fechaVenta = fechaVenta;
		this.totalProductos = totalProductos;
		this.articulos = articulos;
		this.fechaEntrega = fechaEntrega;
		this.descripcion = descripcion;
	}	
}
