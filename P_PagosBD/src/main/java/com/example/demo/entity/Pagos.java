package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagos {
	@Id
	@Column(name="id_pago")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pagoId;
	
	@Column(name="tipo_pago")
	private String tipoPago;
	
	@Column(name="Fecha_pago")
	private Date fechaPago;
	
	@Column(name="Factura_id")
	private long facturaId;
	
	@Column(name="Cliente_id")
	private long clienteId;
	
	public Pagos() {}

	public Pagos(int pagoId, String tipoPago, Date fechaPago, long facturaId, long clienteId) {
		this.pagoId = pagoId;
		this.tipoPago = tipoPago;
		this.fechaPago = fechaPago;
		this.facturaId = facturaId;
		this.clienteId = clienteId;
	}

	public int getPagoId() {
		return pagoId;
	}

	public void setPagoId(int pagoId) {
		this.pagoId = pagoId;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
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
