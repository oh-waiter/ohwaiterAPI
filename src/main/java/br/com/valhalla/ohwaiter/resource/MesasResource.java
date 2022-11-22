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
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Mesas;
import br.com.valhalla.ohwaiter.service.MesasService;
@RequestMapping("/Mesas")
@RestController
public class MesasResource {
	
	@Autowired
	private MesasService service;
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Mesas buscarItem(@PathVariable Long id) {
		return service.buscarMesasID(id);
	} 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List <Mesas> buscarTodosAsMesas() {
		return service.buscarMesas();
	} 
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Mesas CadastrarItemCardapio(@RequestBody Mesas mesas) {
		return service.salvarMesa(mesas);
	} 
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Mesas UpdateItem(@RequestBody Mesas mesas) {
		return service.salvarMesa(mesas);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> DeleteItemCardapio(@PathVariable Long id) {
		service.deletarMesasPorID(id);
		return ResponseEntity.noContent().build();
	}

}
