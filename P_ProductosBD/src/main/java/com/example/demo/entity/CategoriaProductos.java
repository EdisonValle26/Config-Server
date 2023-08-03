package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "categoriaproductos")
public class CategoriaProductos {
	
	@Id
	@Column(name = "idCategoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	private String nombreCategoria;
	private String descripcionCategoria;
	
	@OneToMany(mappedBy = "idCategoria")
	private List<SubCategoriaProductos> subCategoriaProductos;
	
	public CategoriaProductos() {}
	
	public CategoriaProductos(int idCategoria, String nombreCategoria, String descripcionCategoria) 
	{
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	
}
