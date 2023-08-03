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

import com.example.demo.entity.Pagos;
import com.example.demo.ServiceImpl.PagosServicelmpl;
import com.example.demo.service.IPagosService;

@RestController
public class RestApiDemoController {
	
	@Autowired
	private IPagosService IpagosService;
	
	@Autowired
	private PagosServicelmpl pagosServicelmpl;
	
	
	@GetMapping("/pagos")
	public List<Pagos> getProveedores(){
		return IpagosService.getPagos();
	}
	
	@GetMapping("/pagos/{id}")
	public Optional<Pagos> getPagosById(@PathVariable int id){
		return pagosServicelmpl.getPagosById(id);
	}
	
	@PostMapping("/pagos")
	public ResponseEntity<Object> postPagos(@RequestBody Pagos pagos) {
		return this.pagosServicelmpl.newPago(pagos);
	}
	
	@PutMapping("/pagos/{id}")
	public ResponseEntity<Object> putPagos(@PathVariable int id, @RequestBody Pagos pagos) {
		return this.pagosServicelmpl.updatePago(id, pagos);
	}
	
	@DeleteMapping("/pagos/{id}")
	public ResponseEntity<Object> deletePagos(@PathVariable int id, @RequestBody Pagos pagos) {
		return this.pagosServicelmpl.deletePago(id);
	}
}
