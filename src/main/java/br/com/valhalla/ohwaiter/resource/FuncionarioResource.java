package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Funcionario;
import br.com.valhalla.ohwaiter.model.Enums.Funcao;
import br.com.valhalla.ohwaiter.resource.DTO.FuncionarioDTO;
import br.com.valhalla.ohwaiter.service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("funcionario")
@Slf4j
public class FuncionarioResource {

    private FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioResource(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/health")
    public String health() {
        return "OK!";
    }

    @GetMapping()
    public List<FuncionarioDTO> buscarTodosOsFuncionarios() {
        List<FuncionarioDTO> dtos = FuncionarioDTO.modelToDto(funcionarioService.buscarTodosOsFuncionarios());
        return dtos;
    }

    @GetMapping("/{id}")
    public Funcionario buscarFuncionarioPeloId(Long id) {
        return funcionarioService.buscarFuncionarioPorId(id);
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Funcionario salvarFuncionario(@RequestBody FuncionarioDTO funcionarioDto) {
        Funcionario funcionario = FuncionarioDTO.DtoToModel(funcionarioDto);
        return funcionarioService.salvarFuncionario(funcionario);
    }

    @PutMapping
    public Funcionario alterarFuncionario(@RequestBody FuncionarioDTO funcionarioDto) {
        Funcionario funcionario = FuncionarioDTO.DtoToModel(funcionarioDto);
        return funcionarioService.alterarFuncionarioPorId(funcionario);
    }

    @DeleteMapping("/{id}")
    public void excluirFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionarioPorId(id);
    }
}
