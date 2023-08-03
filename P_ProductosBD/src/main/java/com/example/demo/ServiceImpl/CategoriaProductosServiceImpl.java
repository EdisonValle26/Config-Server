package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoriaProductos;
import com.example.demo.repository.CategoriaProductosRepository;
import com.example.demo.service.CategoriaProductosService;

@Service
public class CategoriaProductosServiceImpl implements CategoriaProductosService{
	HashMap<String, Object> datos;
	
	@Autowired
	private CategoriaProductosRepository categoriaProductosRepository;
	
	public List<CategoriaProductos> getCategoriaProductos() {
		return categoriaProductosRepository.findAll();
	}
	
	public Optional<CategoriaProductos> getCategoriaProductosById(int id) {
		return this.categoriaProductosRepository.findById(id);
	}
		
	public ResponseEntity<Object> newCategoriaProductos(CategoriaProductos categoriaProductos) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		categoriaProductosRepository.save(categoriaProductos);
		
		datos.put("data", categoriaProductos);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updateCategoriaProductos(int id, CategoriaProductos categoriaProductos) {
		 datos = new HashMap<>();
		 categoriaProductos.setIdCategoria(id);
		if(categoriaProductos.getIdCategoria() == id) {
			datos.put("mensaje", "Se actualizò con èxito");
			categoriaProductosRepository.save(categoriaProductos);
		}		
		datos.put("data", categoriaProductos);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deleteCategoriaProductos(int id) {
		 datos = new HashMap<>();
		boolean existe= this.categoriaProductosRepository.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe un producto con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		categoriaProductosRepository.deleteById(id);
		datos.put("mensaje", "El producto con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}

}
