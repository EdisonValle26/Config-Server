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

import com.example.demo.service.CategoriaProductosService;
import com.example.demo.service.ProductosService;
import com.example.demo.service.SubCategoriaProductosService;
import com.example.demo.ServiceImpl.CategoriaProductosServiceImpl;
import com.example.demo.ServiceImpl.ProductosServiceImpl;
import com.example.demo.ServiceImpl.SubCategoriaProductosServiceImpl;
import com.example.demo.entity.CategoriaProductos;
import com.example.demo.entity.Productos;
import com.example.demo.entity.SubCategoriaProductos;

@RestController
public class RestApiDemoController {
	
	//-------> Productos <-------
	@Autowired
	private  ProductosService productosService;
	
	@Autowired
	private  ProductosServiceImpl productosServiceImpl;
	
	//-------> SubCategoriaProductos <-------
	@Autowired
	private  SubCategoriaProductosService subCategoriaProductosService;
	
	@Autowired
	private  SubCategoriaProductosServiceImpl subCategoriaProductosServiceImpl;
	
	//-------> CategoriaProductos <-------
	@Autowired
	private  CategoriaProductosService categoriaProductosService;
	
	@Autowired
	private  CategoriaProductosServiceImpl categoriaProductosServiceImpl;
	
	
	//-------> Productos <-------	
	@GetMapping("/productos")
	public List<Productos> getProductos(){
		return productosService.getProductos();
	}
	
	@GetMapping("/productos/{id}")
	public Optional<Productos> getProductosById(@PathVariable int id){
		return productosServiceImpl.getProductosById(id);
	}
	
	@PostMapping("/productos")
	public ResponseEntity<Object> postProductos(@RequestBody Productos productos) {
		return this.productosServiceImpl.newProductos(productos);
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Object> putProductos(@PathVariable int id, @RequestBody Productos productos) {
		return this.productosServiceImpl.updateProductos(id, productos);
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Object> deleteProductos(@PathVariable int id, @RequestBody Productos productos) {
		return this.productosServiceImpl.deleteProductos(id);
	}
	
	//-------> SubCategoriaProductos <-------
	@GetMapping("/subCategoria")
	public List<SubCategoriaProductos> getSubCategoriaProductos(){
		return subCategoriaProductosService.getSubCategoriaProductos();
	}
	
	@GetMapping("/subCategoria/{id}")
	public Optional<SubCategoriaProductos> getSubCategoriaProductosById(@PathVariable int id){
		return subCategoriaProductosServiceImpl.getSubCategoriaProductosById(id);
	}
	
	@PostMapping("/subCategoria")
	public ResponseEntity<Object> postSubCategoriaProductos(@RequestBody SubCategoriaProductos subCategoriaProductos) {
		return this.subCategoriaProductosServiceImpl.newSubCategoriaProductos(subCategoriaProductos);
	}
	
	@PutMapping("/subCategoria/{id}")
	public ResponseEntity<Object> putSubCategoriaProductos(@PathVariable int id, @RequestBody SubCategoriaProductos subCategoriaProductos) {
		return this.subCategoriaProductosServiceImpl.updateSubCategoriaProductos(id, subCategoriaProductos);
	}
	
	@DeleteMapping("/subCategoria/{id}")
	public ResponseEntity<Object> deleteSubCategoriaProductos(@PathVariable int id, @RequestBody SubCategoriaProductos subCategoriaProductos) {
		return this.subCategoriaProductosServiceImpl.deleteSubCategoriaProductos(id);
	}
	
	//-------> CategoriaProductos <-------
	@GetMapping("/categoria")
	public List<CategoriaProductos> getCategoriaProductos(){
		return categoriaProductosService.getCategoriaProductos();
	}
	
	@GetMapping("/categoria/{id}")
	public Optional<CategoriaProductos> getCategoriaProductosById(@PathVariable int id){
		return categoriaProductosServiceImpl.getCategoriaProductosById(id);
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<Object> postCategoria(@RequestBody CategoriaProductos categoria) {
		return this.categoriaProductosServiceImpl.newCategoriaProductos(categoria);
	}
	
	@PutMapping("/categoria/{id}")
	public ResponseEntity<Object> putCategoriaProductos(@PathVariable int id, @RequestBody CategoriaProductos categoria) {
		return this.categoriaProductosServiceImpl.updateCategoriaProductos(id, categoria);
	}
	
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<Object> deleteCategoriaProductos(@PathVariable int id, @RequestBody CategoriaProductos categoria) {
		return this.categoriaProductosServiceImpl.deleteCategoriaProductos(id);
	}
	
}
