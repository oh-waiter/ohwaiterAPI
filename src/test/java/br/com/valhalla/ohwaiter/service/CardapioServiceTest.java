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
import br.com.valhalla.ohwaiter.model.Cardapio;
import br.com.valhalla.ohwaiter.model.Categorias;
import br.com.valhalla.ohwaiter.repository.CardapioRepository;

@SpringBootTest
class CardapioServiceTest {

	final Long ID                 = 1L;
	final String item = "Picanha maturada";
	final Double valor = 100.90;
	final String imagem = "https://imagempicanha.com";
	Categorias categoria;
	
	@InjectMocks
	private CardapioService service;
	
	@Mock
	private CardapioRepository repository;
	
	private Cardapio cardapio;
	
	private Optional<Cardapio>optionalCardapio;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startCardapio();
	}

	@Test
	void quandoCriarUmaNovoItemRetorneSucesso() {
		when(repository.save(Mockito.any())).thenReturn(cardapio);
		Cardapio response = service.itemCardapio(cardapio);
		assertNotNull(response);
		assertEquals(Cardapio.class, response.getClass());
		assertEquals(ID, response.getID());
		Assertions.assertEquals(item, response.getDescItem());
		Assertions.assertEquals(valor, response.getValorItem());
		Assertions.assertEquals(imagem, response.getImgItem());
		Assertions.assertEquals(categoria, response.getCategoria());
	}
	@Test
	void quandoCriarUmaNovoItemRetorneUmaViolacaoDeIntegridadeDeDados() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalCardapio);
		try {
			service.itemCardapio(cardapio);
		} catch (Exception ex) {
			assertEquals(DataIntegrityViolationException.class, ex.getClass());
		}
		
	}

	@Test
	void quandoFazerUmaBuscaPorIDRetorneUmaInstanciaDeCardapio() {
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(optionalCardapio);
		Cardapio response =service.buscarItemPorID(ID);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(Cardapio.class, response.getClass());
		Assertions.assertEquals(ID, response.getID());
		Assertions.assertEquals(item, response.getDescItem());
		Assertions.assertEquals(valor, response.getValorItem());
		Assertions.assertEquals(imagem, response.getImgItem());
		Assertions.assertEquals(categoria, response.getCategoria());
	}
	@Test
	void quandoFazerUmaBuscaPorIDRetorneUmObjetoNaoEncontrado() {
		when(repository.findById(Mockito.anyLong())).thenThrow
		(new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		try {
			service.buscarItemPorID(ID);
		} catch (Exception ex) {
			assertEquals(ResourceNotFoundException.class, ex.getClass());
			assertEquals("Nenhum registro encontrado para este ID!", ex.getMessage());
		}
	}
	
	

	@Test
	void quandoBuscarTodosRetorneUmaListaDeItens() {
		when(repository.findAll()).thenReturn(List.of(cardapio));
		
		List<Cardapio>response = service.buscarTodosOsItens();
		assertEquals(1, response.size());
		assertNotNull(response);
		assertEquals(Cardapio.class, response.get(0).getClass());
		assertEquals(ID, response.get(0).getID());
		assertEquals(item, response.get(0).getDescItem());
		assertEquals(valor, response.get(0).getValorItem());
		assertEquals(imagem, response.get(0).getImgItem());
		assertEquals(categoria, response.get(0).getCategoria());
	}

	@Test
	void quandoAtualizarUmaCategoriaRetorneSucesso() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalCardapio);
		when(repository.save(Mockito.any())).thenReturn(cardapio);
		Cardapio response = service.alterarItemCardapio(cardapio);
		assertNotNull(response);
		assertEquals(Cardapio.class, response.getClass());
		assertEquals(ID, response.getID());
		assertEquals(item, response.getDescItem());
		Assertions.assertEquals(valor, response.getValorItem());
		Assertions.assertEquals(imagem, response.getImgItem());
		Assertions.assertEquals(categoria, response.getCategoria());
	}

	@Test
	void deleteComSucesso() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalCardapio);
		doNothing().when(repository).deleteById(Mockito.anyLong());
		service.deletarItemPorId(ID);
		verify(repository, times(0)).deleteById(Mockito.anyLong());
	}
	
	private void startCardapio() {
		cardapio = new Cardapio(ID,item,valor, imagem, categoria);
		optionalCardapio = Optional.of(new Cardapio(ID,item,valor, imagem, categoria));
		
		
	}

}
