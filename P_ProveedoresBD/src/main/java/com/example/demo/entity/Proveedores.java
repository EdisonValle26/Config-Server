package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedores {
	
	@Id
	@Column(name = "idProveedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProveedor;
	private String nombreProveedor;
	private String direccionProveedor;
	private String contactoProveedor;

	public Proveedores() {}
	
	public Proveedores(int idProveedor, String nombreProveedor, 
			String direccionProveedor, String contactoProveedor) 
	{
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.direccionProveedor = direccionProveedor;
		this.contactoProveedor = contactoProveedor;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getContactoProveedor() {
		return contactoProveedor;
	}

	public void setContactoProveedor(String contactoProveedor) {
		this.contactoProveedor = contactoProveedor;
	}
}
