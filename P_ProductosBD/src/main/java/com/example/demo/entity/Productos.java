package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {
	
	@Id
	@Column(name = "idProducto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String nombreProducto;
	private String descripcionProducto;
	private int precioProducto;
	private int cantidadProducto;

	@ManyToOne
	@JoinColumn(name = "idSubCategoria")
	private SubCategoriaProductos idSubCategoria;

	public Productos() {}
	
	public Productos(int idProducto, String nombreProducto, String descripcionProducto, 
			int precioProducto, int cantidadProducto, SubCategoriaProductos idSubCategoria) 
	{
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precioProducto = precioProducto;
		this.cantidadProducto = cantidadProducto;
		this.idSubCategoria = idSubCategoria;

	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public SubCategoriaProductos getIdSubCategoria() {
		return idSubCategoria;
	}

	public void setIdSubCategoria(SubCategoriaProductos idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}
}
