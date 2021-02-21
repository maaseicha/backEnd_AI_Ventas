package com.appv.Ventas.Entidad;

import java.io.InputStream;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

public class documentoElectronico {
	@Id
	private String id;
	private String title;
	private InputStream pdf;
	public documentoElectronico() {
		super();
	}
	public documentoElectronico(String title) {
		super();
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public InputStream getPdf() {
		return pdf;
	}
	public void setPdf(InputStream pdf) {
		this.pdf = pdf;
	}
	
}
