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
import br.com.valhalla.ohwaiter.model.Mesas;
import br.com.valhalla.ohwaiter.repository.MesasRepository;
@SpringBootTest
class MesasServiceTest {

	final Long ID                 = 1L;
	final int qtdCadeiras = 4;
	final Boolean disponibilidade = true;
	
	
	@InjectMocks
	private MesasService service;
	
	@Mock
	private MesasRepository repository;
	
	private Mesas mesa;
	
	private Optional<Mesas>optionalMesas;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startCardapio();
	}

	@Test
	void quandoCriarUmaNovaMesaRetorneSucesso() {
		when(repository.save(Mockito.any())).thenReturn(mesa);
		Mesas response = service.salvarMesa(mesa);
		assertNotNull(response);
		assertEquals(Mesas.class, response.getClass());
		assertEquals(ID, response.getID());
		assertEquals(qtdCadeiras, response.getQtdCadeiras());
		assertEquals(disponibilidade, response.getDispoMesa());
	}
	@Test
	void quandoCriarUmaNovaMesaRetorneUmaViolacaoDeIntegridadeDeDados() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalMesas);
		try {
			service.salvarMesa(mesa);
		} catch (Exception ex) {
			assertEquals(DataIntegrityViolationException.class, ex.getClass());
		}
		
	}

	@Test
	void quandoFazerUmaBuscaPorIDRetorneUmaInstanciaDeMesas() {
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(optionalMesas);
		Mesas response =service.buscarMesasID(ID);
		Assertions.assertNotNull(response);
		Assertions.assertEquals(Mesas.class, response.getClass());
		Assertions.assertEquals(ID, response.getID());
		Assertions.assertEquals(qtdCadeiras, response.getQtdCadeiras());
		Assertions.assertEquals(disponibilidade,response.getDispoMesa());
		
	}
	@Test
	void quandoFazerUmaBuscaPorIDRetorneUmObjetoNaoEncontrado() {
		when(repository.findById(Mockito.anyLong())).thenThrow
		(new ResourceNotFoundException("Nenhum registro encontrado para este ID!"));
		try {
			service.buscarMesasID(ID);
		} catch (Exception ex) {
			assertEquals(ResourceNotFoundException.class, ex.getClass());
			assertEquals("Nenhum registro encontrado para este ID!", ex.getMessage());
		}
	}
	
	

	@Test
	void quandoBuscarTodasRetorneUmaListaDeMesas() {
		when(repository.findAll()).thenReturn(List.of(mesa));
		
		List<Mesas>response = service.buscarMesas();
		assertEquals(1, response.size());
		assertNotNull(response);
		assertEquals(Mesas.class, response.get(0).getClass());
		assertEquals(ID, response.get(0).getID());
		assertEquals(qtdCadeiras, response.get(0).getQtdCadeiras());
		assertEquals(disponibilidade, response.get(0).getDispoMesa());
		
	}

	@Test
	void quandoAtualizarUmaMesaRetorneSucesso() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalMesas);
		when(repository.save(Mockito.any())).thenReturn(mesa);
		Mesas response = service.alterarMesasPorID(mesa);
		assertNotNull(response);
		assertEquals(Mesas.class, response.getClass());
		assertEquals(ID, response.getID());
		assertEquals(qtdCadeiras, response.getQtdCadeiras());
		Assertions.assertEquals(disponibilidade, response.getDispoMesa());
	}

	@Test
	void deleteComSucesso() {
		when(repository.findById(Mockito.anyLong())).thenReturn(optionalMesas);
		doNothing().when(repository).deleteById(Mockito.anyLong());
		service.deletarMesasPorID(ID);
		verify(repository, times(0)).deleteById(Mockito.anyLong());
	}
	
	private void startCardapio() {
		mesa = new Mesas(ID,qtdCadeiras,disponibilidade);
		optionalMesas = Optional.of(new Mesas(ID,qtdCadeiras,disponibilidade));
		
		
	}

}
