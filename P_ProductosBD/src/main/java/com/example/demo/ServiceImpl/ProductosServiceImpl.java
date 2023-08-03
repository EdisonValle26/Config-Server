package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Productos;
import com.example.demo.repository.ProductosRepository;
import com.example.demo.service.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService{
	HashMap<String, Object> datos;
	
	@Autowired
	private ProductosRepository productosRepository;
	
	public List<Productos> getProductos() {
		return productosRepository.findAll();
	}
	
	public Optional<Productos> getProductosById(int id) {
		return this.productosRepository.findById(id);
	}
				
	public ResponseEntity<Object> newProductos(Productos productos) {
		datos = new HashMap<>();
		datos.put("mensaje", "Se guardò con èxito");
		productosRepository.save(productos);
		
		datos.put("data", productos);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> updateProductos(int id, Productos productos) {
		 datos = new HashMap<>();
		 productos.setIdProducto(id);
		if(productos.getIdProducto() == id) {
			datos.put("mensaje", "Se actualizò con èxito");
			productosRepository.save(productos);
		}		
		datos.put("data", productos);
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
				);
	}
	
	public ResponseEntity<Object> deleteProductos(int id) {
		 datos = new HashMap<>();
		boolean existe= this.productosRepository.existsById(id);
		if(!existe) {
			datos.put("error", true);
			datos.put("mensaje", "No existe un producto con ese id");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
					);
		}
		productosRepository.deleteById(id);
		datos.put("mensaje", "El producto con ese id ha sido eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
				);
	}

}

