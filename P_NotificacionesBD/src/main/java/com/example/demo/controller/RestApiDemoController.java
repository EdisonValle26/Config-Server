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

import com.example.demo.entity.Notificacion;
import com.example.demo.ServiceImpl.NotificacionServicelmpl;
import com.example.demo.service.INotificacionService;

@RestController
public class RestApiDemoController {
	
	@Autowired
	private INotificacionService INotificacionService;
	
	@Autowired
	private NotificacionServicelmpl NotificacionServicelmpl;
	
	
	@GetMapping("/notificacion")
	public List<Notificacion> getProveedores(){
		return INotificacionService.getNotificacion();
	}
	
	@GetMapping("/notificacion/{id}")
	public Optional<Notificacion> getNotificacionById(@PathVariable int id){
		return NotificacionServicelmpl.getNotificacionById(id);
	}
	
	@PostMapping("/notificacion")
	public ResponseEntity<Object> postNotificacion(@RequestBody Notificacion proveedores) {
		return this.NotificacionServicelmpl.newNotificacion(proveedores);
	}
	
	@PutMapping("/notificacion/{id}")
	public ResponseEntity<Object> putNotificacion(@PathVariable int id, @RequestBody Notificacion proveedores) {
		return this.NotificacionServicelmpl.updateNotificacion(id, proveedores);
	}
	
	@DeleteMapping("/notificacion/{id}")
	public ResponseEntity<Object> deleteNotificacion(@PathVariable int id, @RequestBody Notificacion proveedores) {
		return this.NotificacionServicelmpl.deleteNotificacion(id);
	}
}
