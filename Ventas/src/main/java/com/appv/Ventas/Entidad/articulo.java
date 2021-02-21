package com.appv.Ventas.Entidad;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articulo")
public class articulo {
    private String idArticulo;
    private String nombreArticulo;
    private int pesoArticulo;
    private float precioUnitarioArticulo;
    private float precioTotalArticulo;
    private int cantidadArticulo;
    private Date fechaElaboracionArticulo;
    private Date fechaVenciArticulo;
    
    public articulo() {
	super();
    }

	public articulo(String idArticulo, String nombreArticulo, int pesoArticulo, float precioUnitarioArticulo,
			float precioTotalArticulo, int cantidadArticulo, Date fechaElaboracionArticulo, Date fechaVenciArticulo) {
		super();
		this.idArticulo = idArticulo;
		this.nombreArticulo = nombreArticulo;
		this.pesoArticulo = pesoArticulo;
		this.precioUnitarioArticulo = precioUnitarioArticulo;
		this.precioTotalArticulo = precioTotalArticulo;
		this.cantidadArticulo = cantidadArticulo;
		this.fechaElaboracionArticulo = fechaElaboracionArticulo;
		this.fechaVenciArticulo = fechaVenciArticulo;
	}

	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public int getPesoArticulo() {
		return pesoArticulo;
	}

	public void setPesoArticulo(int pesoArticulo) {
		this.pesoArticulo = pesoArticulo;
	}

	public float getPrecioUnitarioArticulo() {
		return precioUnitarioArticulo;
	}

	public void setPrecioUnitarioArticulo(float precioUnitarioArticulo) {
		this.precioUnitarioArticulo = precioUnitarioArticulo;
	}

	public float getPrecioTotalArticulo() {
		return precioTotalArticulo;
	}

	public void setPrecioTotalArticulo(float precioTotalArticulo) {
		this.precioTotalArticulo = precioTotalArticulo;
	}

	public int getCantidadArticulo() {
		return cantidadArticulo;
	}

	public void setCantidadArticulo(int cantidadArticulo) {
		this.cantidadArticulo = cantidadArticulo;
	}

	public Date getFechaElaboracionArticulo() {
		return fechaElaboracionArticulo;
	}

	public void setFechaElaboracionArticulo(Date fechaElaboracionArticulo) {
		this.fechaElaboracionArticulo = fechaElaboracionArticulo;
	}

	public Date getFechaVenciArticulo() {
		return fechaVenciArticulo;
	}

	public void setFechaVenciArticulo(Date fechaVenciArticulo) {
		this.fechaVenciArticulo = fechaVenciArticulo;
	}
}
