package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.valhalla.ohwaiter.model.Estoque;
import br.com.valhalla.ohwaiter.resource.DTO.EstoqueDTO;
import br.com.valhalla.ohwaiter.service.EstoqueService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("estoque")
@Slf4j
public class EstoqueResource {

    private EstoqueService estoqueService;

    @Autowired
    public EstoqueResource(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health() {
        log.info("Resource: Verificação de serviço health");
        return "OK!";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EstoqueDTO>> buscarTodosOsEstoques() {
        log.info("Resource: Pegando a lista de estoque");
        List<EstoqueDTO> dtos = EstoqueDTO.modelToDto(estoqueService.buscarTodosOsProdutos());
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estoque> salvarEstoque(@RequestBody EstoqueDTO estoqueDto) {
        log.info("Resource: Salvando estoque {}", estoqueDto);
        Estoque estoque = EstoqueDTO.DtoToModel(estoqueDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueService.salvarProduto(estoque));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estoque> alterarEstoque(@RequestBody EstoqueDTO estoqueDto) {
        log.info("Resource: Alterando estoque {}", estoqueDto);
        Estoque estoque = EstoqueDTO.DtoToModel(estoqueDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueService.alterarProduto(estoque));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirProdutoDoEstoque(@PathVariable Long id) {
        log.info("Resource: excluindo estoque {}", id);
        estoqueService.deletarProdutoPorId(id);
        return ResponseEntity.noContent().build();
    }
}
