package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FacturaCabecera;
import com.example.demo.repository.FacturaCabeceraRepository;
import com.example.demo.service.FacturaCabeceraService;

@Service
public class FacturaCabeceraServiceImpl implements FacturaCabeceraService{
	HashMap<String, Object> datos;
	
	@Autowired
	private FacturaCabeceraRepository facturaCabeceraRepository;
	
	public List<FacturaCabecera> getFacturaCabecera() {
		return facturaCabeceraRepository.findAll();
	}
	
	public Optional<FacturaCabecera> getFacturaCabeceraById(int id) {
		return this.facturaCabeceraRepository.findById(id);
	}
				
	public ResponseEntity<Object> newFacturaCabecera(FacturaCabecera facturaCabecera) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		facturaCabeceraRepository.save(facturaCabecera);
		
		datos.put("data", facturaCabecera);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updateFacturaCabecera(int id, FacturaCabecera facturaCabecera) {
		 datos = new HashMap<>();
		 facturaCabecera.setIdCabecera(id);
		if(facturaCabecera.getIdCabecera() == id) {
			datos.put("mensaje", "Se actualizò con èxito");
			facturaCabeceraRepository.save(facturaCabecera);
		}		
		datos.put("data", facturaCabecera);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deleteFacturaCabecera(int id) {
		 datos = new HashMap<>();
		boolean existe= this.facturaCabeceraRepository.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe una factura con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		facturaCabeceraRepository.deleteById(id);
		datos.put("mensaje", "La factura con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}

}

