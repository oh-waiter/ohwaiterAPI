package br.com.valhalla.ohwaiter.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Cliente;
import br.com.valhalla.ohwaiter.service.ClienteService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("cliente")
@Slf4j
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health() {
        return "OK!";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        log.info("Resource: Salvando cliente {}", cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(cliente));
    }

    @GetMapping(path = "buscar/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> verificarSeClienteExiste(@PathVariable String cpf) {
        log.info("Resource: Verificando se cliente existe {}", cpf);
        return ResponseEntity.ok().body(clienteService.existeClienteComCpfCadastrado(cpf));
    }

    @GetMapping(path = "{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> buscarCliente(@PathVariable String cpf) {
        log.info("Resource: Buscando cliente {}", cpf);
        return ResponseEntity.ok().body(clienteService.buscarClienteComCpf(cpf));
    }
}
