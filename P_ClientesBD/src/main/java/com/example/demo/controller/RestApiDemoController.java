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

import com.example.demo.ServiceImpl.ClientesServiceImpl;
import com.example.demo.entity.Clientes;
import com.example.demo.service.ClientesService;


@RestController
public class RestApiDemoController {
	
	//-------> clientes <-------
	@Autowired
	private  ClientesService clientesService;
	
	@Autowired
	private  ClientesServiceImpl clientesServiceImpl;
	
	//-------> Clientes <-------	
	@GetMapping("/clientes")
	public List<Clientes> getClientes(){
		return clientesService.getClientes();
	}
	
	@GetMapping("/clientes/{id}")
	public Optional<Clientes> getClientesById(@PathVariable int id){
		return clientesServiceImpl.getClientesById(id);
	}
	
	
	@PostMapping("/clientes")
	public ResponseEntity<Object> postClientes(@RequestBody Clientes clientes) {
		return this.clientesServiceImpl.newClientes(clientes);
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Object> putClientes(@PathVariable int id, @RequestBody Clientes clientes) {
		return this.clientesServiceImpl.updateClientes(id, clientes);
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Object> deleteClientes(@PathVariable int id, @RequestBody Clientes clientes) {
		return this.clientesServiceImpl.deleteClientes(id);
	}
}
