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

@RestController
@RequestMapping("estoque")
public class EstoqueResource {

    
    private EstoqueService estoqueService;

    @Autowired
    public EstoqueResource(EstoqueService estoqueService){
        this.estoqueService = estoqueService;
    }
    
    @GetMapping("/health")
    public String health(){
        return "OK!";
    }

    @GetMapping
    public List<Estoque> buscarTodosOsEstoques(){
        return estoqueService.buscarTodosOsProdutos();
    }

    @GetMapping("/{id}")
    public Estoque buscarEstoquePorId(@PathVariable Long id){
        return estoqueService.buscarProdutoPorId(id);
    }

    @PostMapping
    public Estoque salvarEstoque(@RequestBody Estoque estoque){
        return estoqueService.salvarProduto(estoque);
    }

    @PutMapping
    public Estoque alterarEstoque(@RequestBody Estoque estoque){
        return estoqueService.alterarProduto(estoque);
    }

    @DeleteMapping("{id}")
    public void excluirProdutoDoEstoque(@PathVariable Long id){
        estoqueService.deletarProdutoPorId(id);
    }
}
