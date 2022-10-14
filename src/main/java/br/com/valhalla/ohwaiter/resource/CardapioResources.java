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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Cardapio;
import br.com.valhalla.ohwaiter.service.CardapioService;

@RequestMapping("/cardapio")
@RestController
public class CardapioResources {
	
	@Autowired
	private CardapioService service;
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cardapio buscarItem(@PathVariable Long id) {
		return service.buscarItemPorID(id);
	} 
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List <Cardapio> buscarTodosOsItens() {
		return service.buscarTodosOsItens();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cardapio CadastrarItemCardapio(@RequestBody Cardapio cardapio) {
		return service.itemCardapio(cardapio);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Cardapio UpdateItem(@RequestBody Cardapio cardapio) {
		return service.alterarItemCardapio(cardapio);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> DeleteItemCardapio(@PathVariable Long id) {
		service.deletarItemPorId(id);
		return ResponseEntity.noContent().build();
	}
	

}
