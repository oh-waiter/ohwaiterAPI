package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.model.Funcionario;
import br.com.valhalla.ohwaiter.repository.FuncionarioRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j()
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        log.info("Service: Início da serviço de salvar funcionário");
        try {
            log.debug("Service: Funcionário adicionado {}", funcionario);
            return funcionarioRepository.save(funcionario);
        } catch (Exception erro) {
            log.error("Service: Erro desconhecido ao salvar o funcionário {}", erro);
            return null;
        }
    }

    public List<Funcionario> buscarTodosOsFuncionarios() {
        log.info("Service: Início do serviço de buscar todos os funcionário");
        return funcionarioRepository.findAll();
    }

    public Funcionario alterarFuncionarioPorId(Funcionario funcionario) {
        log.info("Service: Início da serviço de alterar funcionário");
        try {
            log.debug("Service: Funcionário alterado {}", funcionario);
            return funcionarioRepository.save(funcionario);
        } catch (Exception erro) {
            log.error("Service: Erro ao alterar o funcionário {}", erro);
            return null;
        }
    }

    public void deletarFuncionarioPorId(Long id) {
        log.info("Service: Início da serviço de exlcuir funcionário");
        try {
            log.debug("Service: Id do funcionário que será excluido {}", id);
            funcionarioRepository.deleteById(id);
        } catch (IllegalArgumentException erro) {
            log.error("Service: Erro ao excluir o funcionário {}", erro);
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
    }
}
