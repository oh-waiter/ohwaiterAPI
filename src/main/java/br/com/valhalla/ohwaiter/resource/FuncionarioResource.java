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

import br.com.valhalla.ohwaiter.model.Funcionario;
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

    @GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health() {
        log.info("Resource: Verificação de serviço health");
        return "OK!";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FuncionarioDTO>> buscarTodosOsFuncionarios() {
        log.info("Resource: Pegando a lista de funcionários");
        List<FuncionarioDTO> dtos = FuncionarioDTO.modelToDto(funcionarioService.buscarTodosOsFuncionarios());
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody FuncionarioDTO funcionarioDto) {
        log.info("Resource: Salvando funcionários {}", funcionarioDto);
        Funcionario funcionario = FuncionarioDTO.DtoToModel(funcionarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.salvarFuncionario(funcionario));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> alterarFuncionario(@RequestBody FuncionarioDTO funcionarioDto) {
        log.info("Resource: Editando funcionários {}", funcionarioDto);
        Funcionario funcionario = FuncionarioDTO.DtoToModel(funcionarioDto);
        return ResponseEntity.ok().body(funcionarioService.alterarFuncionario(funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable Long id) {
        log.info("Resource: Excluindo funcionários {}", id);
        funcionarioService.deletarFuncionarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}
