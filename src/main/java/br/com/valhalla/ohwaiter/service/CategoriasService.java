package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import br.com.valhalla.ohwaiter.model.Categorias;
import br.com.valhalla.ohwaiter.repository.CategoriasRepository;

public class CategoriasService {
	
	CategoriasRepository categoriaRepository;
	
	@Autowired
	public CategoriasService(CategoriasRepository categoria) {
		
		this.categoriaRepository=categoria;
		
	}
	
	public Categorias salvarCategoria(Categorias categorias) {
		return categoriaRepository.save(categorias);
	}
	
	public Categorias buscarCategoriasID(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	public List<Categorias> buscarCategorias(){
		return categoriaRepository.findAll();
	}
	
	public Categorias aterarCategoriasPorID(Long ID) {
		Categorias categorias = categoriaRepository.findById(ID).orElse(null);
		return categoriaRepository.save(categorias);
	}
	public void deletarCategorias(Long ID) {
		categoriaRepository.deleteById(ID);
	}
	

}
