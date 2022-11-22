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

import br.com.valhalla.ohwaiter.model.Pagamento;
import br.com.valhalla.ohwaiter.service.PagamentoService;


@RestController
@RequestMapping("pagamento")
public class PagamentoResource {
    private PagamentoService pagamentoService;

    @Autowired
    public PagamentoResource(PagamentoService pagamentoService){
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/health")
    public String health(){
        return "OK!";
    }

    @GetMapping
    public List<Pagamento> buscarTodosOsCartoes(){
        return pagamentoService.buscarTodosOsCartoes();
    }

    @GetMapping("/{id}")
    public Pagamento buscarEstoquePorId(@PathVariable Long id){
        return pagamentoService.buscarCartaoPorId(id);
    }

    @PostMapping
    public Pagamento salvarEstoque(@RequestBody Pagamento pagamento){
        return pagamentoService.salvarCartao(pagamento);
    }

    @PutMapping
    public Pagamento alterarEstoque(@RequestBody Pagamento pagamento){
        return pagamentoService.alterarCartaoPorId(pagamento);
    }

    @DeleteMapping("{id}")
    public void excluirProdutoDoEstoque(@PathVariable Long id){
        pagamentoService.deletarCartaoPorId(id);
    }
}
