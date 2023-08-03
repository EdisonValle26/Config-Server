package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FacturaDetalle;
import com.example.demo.repository.FacturaDetalleRepository;
import com.example.demo.service.FacturaDetalleService;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService{
	HashMap<String, Object> datos;
	
	@Autowired
	private FacturaDetalleRepository facturaDetalleRepository;
	
	public List<FacturaDetalle> getFacturaDetalle() {
		return facturaDetalleRepository.findAll();
	}
	
	public Optional<FacturaDetalle> getFacturaDetallesById(int id) {
		return this.facturaDetalleRepository.findById(id);
	}
				
	public ResponseEntity<Object> newFacturaDetalle(FacturaDetalle facturaDetalle) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		facturaDetalleRepository.save(facturaDetalle);
		
		datos.put("data", facturaDetalle);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updateFacturaDetalle(int id, FacturaDetalle facturaDetalle) {
		 datos = new HashMap<>();
		 facturaDetalle.setIdDetalle(id);
		if(facturaDetalle.getIdDetalle() == id) {
			datos.put("mensaje", "Se actualizò con èxito");
			facturaDetalleRepository.save(facturaDetalle);
		}		
		datos.put("data", facturaDetalle);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deleteFacturaDetalle(int id) {
		 datos = new HashMap<>();
		boolean existe= this.facturaDetalleRepository.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe una factura con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		facturaDetalleRepository.deleteById(id);
		datos.put("mensaje", "La factura con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}

}

