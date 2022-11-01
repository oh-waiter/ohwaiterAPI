package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Estoque;
import br.com.valhalla.ohwaiter.service.EstoqueService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("estoque")
@Slf4j
public class EstoqueResource {

    private EstoqueService estoqueService;

    @Autowired
    public EstoqueResource(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping("/health")
    public String health() {
        log.info("Resource: Verificação de serviço health");
        return "OK!";
    }

    @GetMapping
    public List<Estoque> buscarTodosOsEstoques() {
        log.info("Resource: Pegando a lista de estoque");
        return estoqueService.buscarTodosOsProdutos();
    }

    @PostMapping
    public Estoque salvarEstoque(@RequestBody Estoque estoqueDto) {
        log.info("Resource: Salvando estoque {}", estoqueDto);
        return estoqueService.salvarProduto(estoqueDto);
    }

    @PutMapping
    public Estoque alterarEstoque(@RequestBody Estoque estoqueDto) {
        log.info("Resource: Alterando estoque {}", estoqueDto);
        return estoqueService.alterarProduto(estoqueDto);
    }

    @DeleteMapping("{id}")
    public void excluirProdutoDoEstoque(@PathVariable Long id) {
        log.info("Resource: excluindo estoque {}", id);
        estoqueService.deletarProdutoPorId(id);
    }
}
