package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.repository.INotificacionDao;
import com.example.demo.service.INotificacionService;
import com.example.demo.entity.Notificacion;

@Service
public class NotificacionServicelmpl implements INotificacionService{
	HashMap<String, Object> datos;
	
	@Autowired
	private INotificacionDao iNotificacionDao;
	
	@Override
	public List<Notificacion> getNotificacion() {
		return (List<Notificacion>) iNotificacionDao.findAll();
	}
	public Optional<Notificacion> getNotificacionById(int id) {
		return this.iNotificacionDao.findById(id);
	}
	public ResponseEntity<Object> newNotificacion(Notificacion notificacion) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		iNotificacionDao.save(notificacion);
		
		datos.put("data", notificacion);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updateNotificacion(int id, Notificacion notificacion) {
		 datos = new HashMap<>();
		 notificacion.setNotiId(id);
		if(notificacion.getNotiId()==id) {
			datos.put("mensaje", "Se actualizò con èxito");
			iNotificacionDao.save(notificacion);
		}		
		datos.put("data", notificacion);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deleteNotificacion(int id) {
		 datos = new HashMap<>();
		boolean existe= this.iNotificacionDao.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe un producto con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		iNotificacionDao.deleteById(id);
		datos.put("mensaje", "El producto con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}
}
