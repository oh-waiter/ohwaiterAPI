package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.valhalla.ohwaiter.model.Cardapio;
import br.com.valhalla.ohwaiter.model.Mesas;
import br.com.valhalla.ohwaiter.service.CardapioService;
import br.com.valhalla.ohwaiter.service.MesasService;

public class MesasResource {
	
	@Autowired
	private MesasService service;
	
	@GetMapping
	public Mesas buscarItem(@PathVariable Long id) {
		return service.buscarMesasID(id);
	} 
	@GetMapping
	public List <Mesas> buscarTodosAsMesas() {
		return service.buscarMesas();
	} 
	@PostMapping
	public Mesas CadastrarItemCardapio(@RequestBody Mesas mesas) {
		return service.salvarMesa(mesas);
	} 
	@PutMapping
	public Mesas SaveMesa(@RequestBody Mesas mesas) {
		return service.salvarMesa(mesas);
	}
	@PutMapping
	public Mesas UpdateItem(@RequestBody Mesas mesas) {
		return service.salvarMesa(mesas);
	}
	@DeleteMapping
	public void DeleteItemCardapio(@PathVariable Long id) {
		service.deletarMesasPorID(id);
	}

}
