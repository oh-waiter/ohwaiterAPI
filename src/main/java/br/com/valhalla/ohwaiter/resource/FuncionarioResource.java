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

import br.com.valhalla.ohwaiter.model.Funcionario;
import br.com.valhalla.ohwaiter.service.FuncionarioService;

@RestController
@RequestMapping("funcionario")
public class FuncionarioResource {

    private FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioResource(FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/health")
    public String health(){
        return "OK!";
    }

    @GetMapping()
    public List<Funcionario> buscarTodosOsFuncionarios(){
        return funcionarioService.buscarTodosOsFuncionarios();
    }

    @GetMapping("/{id}")
    public Funcionario buscarFuncionarioPeloId(Long id){
        return funcionarioService.buscarFuncionarioPorId(id);
    }

    @PostMapping
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @PutMapping
    public Funcionario alterarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.alterarFuncionarioPorId(funcionario);
    }

    @DeleteMapping("/{id}")
    public void excluirFuncionario(@PathVariable Long id){
        funcionarioService.deletarFuncionarioPorId(id);
    }
}
