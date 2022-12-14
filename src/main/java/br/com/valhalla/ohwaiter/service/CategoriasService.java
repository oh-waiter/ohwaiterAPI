package br.com.valhalla.ohwaiter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.exceptions.ObjectNotFoundException;
import br.com.valhalla.ohwaiter.exceptions.ResourceNotFoundException;
import br.com.valhalla.ohwaiter.model.Categorias;
import br.com.valhalla.ohwaiter.repository.CategoriasRepository;

@Service
public class CategoriasService {
	@Autowired
	CategoriasRepository categoriaRepository;

	public CategoriasService(CategoriasRepository categoria) {

		this.categoriaRepository = categoria;

	}

	public Categorias salvarCategoria(Categorias categorias) {
		return categoriaRepository.save(categorias);
	}

	public Categorias buscarCategoriasID(Long id) {
		Optional<Categorias> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado para este ID!"));
	}

	public List<Categorias> buscarCategorias() {
		return categoriaRepository.findAll();
	}

	public Categorias aterarCategoria(Categorias categorias) {
		Categorias entity = categoriaRepository.findById(categorias.getID())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		entity.setNomeCategoria(categorias.getNomeCategoria());
		return categoriaRepository.save(categorias);
	}

	public void deletarCategorias(Long ID) {
		Categorias entity = categoriaRepository.findById(ID)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		categoriaRepository.delete(entity);
	}

}
