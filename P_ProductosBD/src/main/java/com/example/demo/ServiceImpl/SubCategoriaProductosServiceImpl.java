package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SubCategoriaProductos;
import com.example.demo.repository.SubCategoriaProductosRepository;
import com.example.demo.service.SubCategoriaProductosService;


@Service
public class SubCategoriaProductosServiceImpl implements SubCategoriaProductosService{
	HashMap<String, Object> datos;
	
	@Autowired
	private SubCategoriaProductosRepository subCategoriaProductosRepository;
	
	public List<SubCategoriaProductos> getSubCategoriaProductos() {
		return subCategoriaProductosRepository.findAll();
	}
	
	public Optional<SubCategoriaProductos> getSubCategoriaProductosById(int id) {
		return this.subCategoriaProductosRepository.findById(id);
	}
		
	public ResponseEntity<Object> newSubCategoriaProductos(SubCategoriaProductos subCategoriaProductos) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		subCategoriaProductosRepository.save(subCategoriaProductos);
		
		datos.put("data", subCategoriaProductos);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updateSubCategoriaProductos(int id, SubCategoriaProductos subCategoriaProductos) {
		 datos = new HashMap<>();
		 subCategoriaProductos.setIdSubCategoria(id);
		if(subCategoriaProductos.getIdSubCategoria() == id) {
			datos.put("mensaje", "Se actualizò con èxito");
			subCategoriaProductosRepository.save(subCategoriaProductos);
		}		
		datos.put("data", subCategoriaProductos);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deleteSubCategoriaProductos(int id) {
		 datos = new HashMap<>();
		boolean existe= this.subCategoriaProductosRepository.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe un producto con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		subCategoriaProductosRepository.deleteById(id);
		datos.put("mensaje", "El producto con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}

}
