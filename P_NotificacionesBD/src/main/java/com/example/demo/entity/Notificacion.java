package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Notificacion {
	@Id
	@Column(name="Notificacion_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notiId;
	
	@Column(name="Descripcion")
	private String descrip;
	
	@Column(name="Fecha")
	private Date fecha;
	
	@Column(name="Factura_id")
	private long facturaId;
	
	@Column(name="Cliente_id")
	private long clienteId;
	
	public Notificacion() {}

	public Notificacion(int notiId, String descrip, Date fecha, long facturaId, long clienteId) {
		this.notiId = notiId;
		this.descrip = descrip;
		this.fecha = fecha;
		this.facturaId = facturaId;
		this.clienteId = clienteId;
	}

	public int getNotiId() {
		return notiId;
	}

	public void setNotiId(int notiId) {
		this.notiId = notiId;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(long facturaId) {
		this.facturaId = facturaId;
	}

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
	}
}
