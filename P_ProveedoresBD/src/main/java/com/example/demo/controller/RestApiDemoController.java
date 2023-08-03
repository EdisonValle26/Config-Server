package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProveedoresService;
import com.example.demo.ServiceImpl.ProveedoresServiceImpl;
import com.example.demo.entity.Proveedores;


@RestController
public class RestApiDemoController {
	
	//-------> Proveedores <-------
	@Autowired
	private  ProveedoresService proveedoresService;
	
	@Autowired
	private  ProveedoresServiceImpl proveedoresServiceImpl;
	
	//-------> Proveedores <-------
	@GetMapping("/proveedores")
	public List<Proveedores> getProveedores(){
		return proveedoresService.getProveedores();
	}
	
	@GetMapping("/proveedores/{id}")
	public Optional<Proveedores> getProveedoresById(@PathVariable int id){
		return proveedoresServiceImpl.getProveedoresById(id);
	}
	
	@PostMapping("/proveedores")
	public ResponseEntity<Object> postProveedores(@RequestBody Proveedores proveedores) {
		return this.proveedoresServiceImpl.newProveedores(proveedores);
	}
	
	@PutMapping("/proveedores/{id}")
	public ResponseEntity<Object> putProveedores(@PathVariable int id, @RequestBody Proveedores proveedores) {
		return this.proveedoresServiceImpl.updateProveedores(id, proveedores);
	}
	
	@DeleteMapping("/proveedores/{id}")
	public ResponseEntity<Object> deleteProveedores(@PathVariable int id, @RequestBody Proveedores proveedores) {
		return this.proveedoresServiceImpl.deleteProveedores(id);
	}
}
