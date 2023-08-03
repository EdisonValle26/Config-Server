package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPagosDao;
import com.example.demo.service.IPagosService;
import com.example.demo.entity.Pagos;

@Service
public class PagosServicelmpl implements IPagosService{
	HashMap<String, Object> datos;
	
	@Autowired
	private IPagosDao iPagosDao ;
	
	@Override
	public List<Pagos> getPagos(){
		return (List<Pagos>) iPagosDao.findAll();
	}
	public Optional<Pagos> getPagosById(int id){
		return this.iPagosDao.findById(id);
	}
	public ResponseEntity<Object> newPago(Pagos pagos) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		iPagosDao.save(pagos);
		
		datos.put("data", pagos);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updatePago(int id, Pagos pagos) {
		 datos = new HashMap<>();
		 pagos.setPagoId(id);
		if(pagos.getPagoId()==id) {
			datos.put("mensaje", "Se actualizò con èxito");
			iPagosDao.save(pagos);
		}		
		datos.put("data", pagos);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deletePago(int id) {
		 datos = new HashMap<>();
		boolean existe= this.iPagosDao.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe un producto con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		iPagosDao.deleteById(id);
		datos.put("mensaje", "El producto con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}
}
