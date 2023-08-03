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

import com.example.demo.ServiceImpl.FacturaCabeceraServiceImpl;
import com.example.demo.ServiceImpl.FacturaDetalleServiceImpl;
import com.example.demo.entity.FacturaCabecera;
import com.example.demo.entity.FacturaDetalle;
import com.example.demo.service.FacturaCabeceraService;
import com.example.demo.service.FacturaDetalleService;


@RestController
public class RestApiDemoController {
	
	//-------> FacturaCabecera <-------
	@Autowired
	private  FacturaCabeceraService facturaCabeceraService;
	
	@Autowired
	private  FacturaCabeceraServiceImpl facturaCabeceraServiceImpl;
	
	//-------> FacturaDetalle <-------
	@Autowired
	private  FacturaDetalleService facturaDetalleService;
		
	@Autowired
	private  FacturaDetalleServiceImpl facturaDetalleServiceImpl;
	
	//-------> FacturaCabecera <-------	
	@GetMapping("/factura")
	public List<FacturaCabecera> getFacturaCabecera(){
		return facturaCabeceraService.getFacturaCabecera();
	}
	
	@GetMapping("/factura/{id}")
	public Optional<FacturaCabecera> getFacturaCabeceraById(@PathVariable int id){
		return facturaCabeceraServiceImpl.getFacturaCabeceraById(id);
	}
	
	@PostMapping("/factura")
	public ResponseEntity<Object> postFacturaCabecera(@RequestBody FacturaCabecera factura) {
		return this.facturaCabeceraServiceImpl.newFacturaCabecera(factura);
	}
	
	@PutMapping("/factura/{id}")
	public ResponseEntity<Object> putFacturaCabecera(@PathVariable int id, @RequestBody FacturaCabecera factura) {
		return this.facturaCabeceraServiceImpl.updateFacturaCabecera(id, factura);
	}
	
	@DeleteMapping("/factura/{id}")
	public ResponseEntity<Object> deleteFacturaCabecera(@PathVariable int id, @RequestBody FacturaCabecera factura) {
		return this.facturaCabeceraServiceImpl.deleteFacturaCabecera(id);
	}
	
	//-------> FacturaDetalle <-------	
	@GetMapping("/facturaDetalle")
	public List<FacturaDetalle> getFacturaDetalle(){
		return facturaDetalleService.getFacturaDetalle();
	}
	
	@GetMapping("/facturaDetalle/{id}")
	public Optional<FacturaDetalle> getFacturaDetalleById(@PathVariable int id){
		return facturaDetalleServiceImpl.getFacturaDetallesById(id);
	}
	
	@PostMapping("/facturaDetalle")
	public ResponseEntity<Object> postFacturaDetalle(@RequestBody FacturaDetalle facturaDetalle) {
		return this.facturaDetalleServiceImpl.newFacturaDetalle(facturaDetalle);
	}
	
	@PutMapping("/facturaDetalle/{id}")
	public ResponseEntity<Object> putFacturaDetalle(@PathVariable int id, @RequestBody FacturaDetalle facturaDetalle) {
		return this.facturaDetalleServiceImpl.updateFacturaDetalle(id, facturaDetalle);
	}
	
	@DeleteMapping("/facturaDetalle/{id}")
	public ResponseEntity<Object> deleteFacturaDetalle(@PathVariable int id, @RequestBody FacturaDetalle facturaDetalle) {
		return this.facturaDetalleServiceImpl.deleteFacturaDetalle(id);
	}
}
