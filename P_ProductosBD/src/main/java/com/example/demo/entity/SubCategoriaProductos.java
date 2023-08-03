package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subcategoriaproductos")
public class SubCategoriaProductos {
	
	@Id
	@Column(name = "idSubCategoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSubCategoria;
	private String nombreSubCategoria;
	private String descripcionSubCategoria;
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private CategoriaProductos idCategoria;
	
	@OneToMany(mappedBy = "idSubCategoria")
	private List<Productos> productos;

	
	public SubCategoriaProductos() {}
	
	public SubCategoriaProductos(int idSubCategoria, String nombreSubCategoria, 
			String descripcionSubCategoria, CategoriaProductos idCategoria) 
	{
		this.idSubCategoria = idSubCategoria;
		this.nombreSubCategoria = nombreSubCategoria;
		this.descripcionSubCategoria = descripcionSubCategoria;
		this.idCategoria = idCategoria;
	}

	public int getIdSubCategoria() {
		return idSubCategoria;
	}

	public void setIdSubCategoria(int idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}

	public String getNombreSubCategoria() {
		return nombreSubCategoria;
	}

	public void setNombreSubCategoria(String nombreSubCategoria) {
		this.nombreSubCategoria = nombreSubCategoria;
	}

	public String getDescripcionSubCategoria() {
		return descripcionSubCategoria;
	}

	public void setDescripcionSubCategoria(String descripcionSubCategoria) {
		this.descripcionSubCategoria = descripcionSubCategoria;
	}

	public CategoriaProductos getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(CategoriaProductos idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
