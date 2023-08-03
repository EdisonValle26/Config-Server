package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proveedores;
import com.example.demo.repository.ProveedoresRepository;
import com.example.demo.service.ProveedoresService;


@Service
public class ProveedoresServiceImpl implements ProveedoresService{
	HashMap<String, Object> datos;
	
	@Autowired
	private ProveedoresRepository proveedoresRepository;
	
	public List<Proveedores> getProveedores() {
		return proveedoresRepository.findAll();
	}
	
	public Optional<Proveedores> getProveedoresById(int id) {
		return this.proveedoresRepository.findById(id);
	}
		
	public ResponseEntity<Object> newProveedores(Proveedores proveedores) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		proveedoresRepository.save(proveedores);
		
		datos.put("data", proveedores);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updateProveedores(int id, Proveedores proveedores) {
		 datos = new HashMap<>();
		 proveedores.setIdProveedor(id);
		if(proveedores.getIdProveedor() == id) {
			datos.put("mensaje", "Se actualizò con èxito");
			proveedoresRepository.save(proveedores);
		}		
		datos.put("data", proveedores);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deleteProveedores(int id) {
		 datos = new HashMap<>();
		boolean existe= this.proveedoresRepository.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe un proveedor con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		proveedoresRepository.deleteById(id);
		datos.put("mensaje", "El proveedor con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}

}
