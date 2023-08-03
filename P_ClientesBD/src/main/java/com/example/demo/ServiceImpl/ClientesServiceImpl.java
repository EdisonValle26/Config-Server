package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Clientes;
import com.example.demo.repository.ClientesRepository;
import com.example.demo.service.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService{
	HashMap<String, Object> datos;

	@Autowired
	private ClientesRepository clientesRepository;
	
	public List<Clientes> getClientes() {
		return clientesRepository.findAll();
	}

	public Optional<Clientes> getClientesById(int id) {
		return this.clientesRepository.findById(id);
	}

	public ResponseEntity<Object> newClientes(Clientes clientes) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		clientesRepository.save(clientes);
		
		datos.put("data", clientes);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updateClientes(int id, Clientes clientes) {
		datos = new HashMap<>(); 
		clientes.setId(id);
		if(clientes.getId() == id) {
			datos.put("mensaje", "Se actualizò con èxito");
			clientesRepository.save(clientes);
		}
		datos.put("data", clientes);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deleteClientes(int id) {
		 datos = new HashMap<>();
		boolean existe= this.clientesRepository.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe un cliente con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		clientesRepository.deleteById(id);
		datos.put("mensaje", "El cliente con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}
}

