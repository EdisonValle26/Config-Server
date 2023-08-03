package com.example.demo.entity;

import com.example.demo.entity.FacturaCabecera;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facturadetalle")
public class FacturaDetalle {
	
	@Id
	@Column(name = "idDetalle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	private String descriptionProduct;
	private int cantidadProduct;
	private int priceUnit;
	private int idProducto;
	
	@ManyToOne
	@JoinColumn(name = "idCabecera")
	private FacturaCabecera idCabecera;

	public FacturaDetalle() {}
	
	public FacturaDetalle(int idDetalle, String descriptionProduct, int cantidadProduct, 
			int priceUnit, int idProducto, FacturaCabecera idCabecera) 
	{
		this.idDetalle = idDetalle;
		this.descriptionProduct = descriptionProduct;
		this.cantidadProduct = cantidadProduct;
		this.priceUnit = priceUnit;
		this.idProducto = idProducto;
		this.idCabecera = idCabecera;
	}

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public int getCantidadProduct() {
		return cantidadProduct;
	}

	public void setCantidadProduct(int cantidadProduct) {
		this.cantidadProduct = cantidadProduct;
	}

	public int getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(int priceUnit) {
		this.priceUnit = priceUnit;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public FacturaCabecera getIdCabecera() {
		return idCabecera;
	}

	public void setIdCabecera(FacturaCabecera idCabecera) {
		this.idCabecera = idCabecera;
	}
}
