package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facturacabecera")
public class FacturaCabecera {
	
	@Id
	@Column(name = "idCabecera")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCabecera;
	private String nombre;
	private String description;
	private String direction;
	private Date date;
	private int priceTotal;
	private int idformaPago;
	private int idCliente;
	
	
	@OneToMany(mappedBy = "idCabecera")
	private List<FacturaDetalle> facturadetalle;
	
	public FacturaCabecera() {}
	
	public FacturaCabecera(int idCabecera, String nombre, String description, String direction, 
			Date date, int idformaPago, int priceTotal, int idCliente) 
	{
		this.idCabecera = idCabecera;
		this.nombre = nombre;
		this.description = description;
		this.direction = direction;
		this.date = date;
		this.idformaPago = idformaPago;
		this.priceTotal = priceTotal;
		this.idCliente = idCliente;
	}

	public int getIdCabecera() {
		return idCabecera;
	}

	public void setIdCabecera(int idCabecera) {
		this.idCabecera = idCabecera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(int priceTotal) {
		this.priceTotal = priceTotal;
	}

	public int getIdformaPago() {
		return idformaPago;
	}

	public void setIdformaPago(int idformaPago) {
		this.idformaPago = idformaPago;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}