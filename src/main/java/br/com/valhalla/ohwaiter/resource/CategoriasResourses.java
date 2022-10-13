package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping
	public Categorias buscarCategoria(@PathVariable Long id) {
		return service.buscarCategoriasID(id);
	} 
	@GetMapping
	public List <Categorias> buscarTodosOsItens() {
		return service.buscarCategorias();
	} 
	@PostMapping
	public Categorias CadastrarCategoria(@RequestBody Categorias categorias) {
		return service.salvarCategoria(categorias);
	} 
	@PutMapping
	public Categorias UpdateCategoria(@RequestBody Categorias categorias) {
		return service.aterarCategoria(categorias);
	}
	
	@DeleteMapping
	public void DeleteItemCardapio(@PathVariable Long id) {
		service.deletarCategorias(id);
	}

}