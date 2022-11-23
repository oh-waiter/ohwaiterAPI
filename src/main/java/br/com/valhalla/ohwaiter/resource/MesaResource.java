package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Mesa;
import br.com.valhalla.ohwaiter.service.MesaService;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/mesa")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class MesaResource {

	@Autowired
	private MesaService service;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mesa buscarItem(@PathVariable Long id) {
		return service.buscarMesaID(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Mesa> buscarTodosAsMesas() {
		return service.buscarMesa();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mesa CadastrarItemCardapio(@RequestBody Mesa mesa) {
		log.debug("mesa {}", mesa);
		return service.salvarMesa(mesa);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mesa UpdateItem(@RequestBody Mesa mesa) {
		return service.salvarMesa(mesa);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> DeleteItemCardapio(@PathVariable Long id) {
		service.deletarMesaPorID(id);
		return ResponseEntity.noContent().build();
	}

}
