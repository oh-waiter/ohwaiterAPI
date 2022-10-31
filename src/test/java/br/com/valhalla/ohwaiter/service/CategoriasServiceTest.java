package br.com.valhalla.ohwaiter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.valhalla.ohwaiter.exceptions.ResourceNotFoundException;
import br.com.valhalla.ohwaiter.model.Categorias;
import br.com.valhalla.ohwaiter.repository.CategoriasRepository;

@SpringBootTest
class CategoriasServiceTest {
	
	final Long ID                 = 1L;
	final String categoria = "Bebidas";
	
	@InjectMocks
	private CategoriasService service;
	
	@Mock
	private CategoriasRepository repository;
	
	private Categorias categorias;
	
	private Optional<Categorias>optionalCategoria;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startCategotias();
	}

	@Test
	void quandoCriarUmaNovaCategoriaRetorneSucesso() {
		when(repository.save(Mockito.any())).thenReturn(categorias);
		Categorias response = service.salvarCategoria(categorias);
		assertNotNull(response);
		assertEquals(Categorias.class, response.getClass());
		assertEquals(ID, response.getID());
		assertEquals(categoria, response.getNomeCategoria());
	}
	@Test
	void quandoCriarUmaNovaCategoriaRetorneUmaViolacaoDeIntegridadeDeDados() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalCategoria);
		try {
			service.salvarCategoria(categorias);
		} catch (Exception ex) {
			assertEquals(DataIntegrityViolationException.class, ex.getClass());
		}
		
	}

	@Test
	void quandoFazerUmaBuscaPorIDRetorneUmaInstanciaDeCategoria() {
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(optionalCategoria);
		Categorias response =service.buscarCategoriasID(ID);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(Categorias.class, response.getClass());
		Assertions.assertEquals(ID, response.getID());
		Assertions.assertEquals(categoria, response.getNomeCategoria());
	}
	@Test
	void quandoFazerUmaBuscaPorIDRetorneUmObjetoNaoEncontrado() {
		when(repository.findById(Mockito.anyLong())).thenThrow
		(new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		try {
			service.buscarCategoriasID(ID);
		} catch (Exception ex) {
			assertEquals(ResourceNotFoundException.class, ex.getClass());
			assertEquals("Nenhum registro encontrado para este ID!", ex.getMessage());
		}
	}
	
	

	@Test
	void quandoBuscarTodosRetorneUmaListaDeCategorias() {
		when(repository.findAll()).thenReturn(List.of(categorias));
		
		List<Categorias>response = service.buscarCategorias();
		assertEquals(1, response.size());
		assertNotNull(response);
		assertEquals(Categorias.class, response.get(0).getClass());
		assertEquals(ID, response.get(0).getID());
		assertEquals(categoria, response.get(0).getNomeCategoria());
	}

	@Test
	void quandoAtualizarUmaCategoriaRetorneSucesso() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalCategoria);
		when(repository.save(Mockito.any())).thenReturn(categorias);
		Categorias response = service.aterarCategoria(categorias);
		assertNotNull(response);
		assertEquals(Categorias.class, response.getClass());
		assertEquals(ID, response.getID());
		assertEquals(categoria, response.getNomeCategoria());
	}

	@Test
	void deleteComSucesso() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalCategoria);
		doNothing().when(repository).deleteById(Mockito.anyLong());
		service.deletarCategorias(ID);
		verify(repository, times(0)).deleteById(Mockito.anyLong());
	}
	
	private void startCategotias() {
		categorias = new Categorias(ID,categoria);
		optionalCategoria = Optional.of(new Categorias(ID,categoria));
		
		
	}

}
