package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.valhalla.ohwaiter.model.Categorias;
import br.com.valhalla.ohwaiter.service.CategoriasService;

public class CategoriasResourses {
	
	@Autowired
	private CategoriasService service;
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Categorias buscarCategoria(@PathVariable Long id) {
		return service.buscarCategoriasID(id);
	} 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List <Categorias> buscarTodosOsItens() {
		return service.buscarCategorias();
	} 
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Categorias CadastrarCategoria(@RequestBody Categorias categorias) {
		return service.salvarCategoria(categorias);
	} 
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Categorias UpdateCategoria(@RequestBody Categorias categorias) {
		return service.aterarCategoria(categorias);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> DeleteCategoria(@PathVariable Long id) {
		service.deletarCategorias(id);
		return ResponseEntity.noContent().build();
	}

}
