package com.appv.Ventas.Entidad;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="documentoVenta")
public class documentoVentaEntity {
	@Id
	private String id;
	private String idFactura;
	private String fechaVencimiento;
	private double IVA;
	private double totalVenta;
	private String fecha;
	private String nPedido;
	private String nombreCliente;
	
	public documentoVentaEntity() {
		super();
	}
	
	public documentoVentaEntity(String id, String idFactura, String fechaVencimiento, double iVA, double totalVenta,
			String fecha, String nPedido, String nombreCliente) {
		this.id = id;
		this.idFactura = idFactura;
		this.fechaVencimiento = fechaVencimiento;
		IVA = iVA;
		this.totalVenta = totalVenta;
		this.fecha = fecha;
		this.nPedido = nPedido;
		this.nombreCliente = nombreCliente;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getIVA() {
		return IVA;
	}

	public void setIVA(double iVA) {
		IVA = iVA;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getnPedido() {
		return nPedido;
	}

	public void setnPedido(String nPedido) {
		this.nPedido = nPedido;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	

}

