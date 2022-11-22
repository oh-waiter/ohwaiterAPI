package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.model.Estoque;
import br.com.valhalla.ohwaiter.repository.EstoqueRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EstoqueService {
    private EstoqueRepository estoqueRepository;

    @Autowired
    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    public Estoque salvarProduto(Estoque estoque) {
        log.info("Service: Início da serviço de salvar estoque");
        try {
            log.debug("Service: Estoque adicionado {}", estoque);
            return estoqueRepository.save(estoque);
        } catch (Exception erro) {
            log.error("Service: Erro desconhecido ao salvar o estoque {}", erro);
            return null;
        }
    }

    public List<Estoque> buscarTodosOsProdutos() {
        log.info("Service: Início do serviço de buscar todos os estoques");
        return estoqueRepository.findAll();
    }

    public Estoque alterarProduto(Estoque estoque) {
        log.info("Service: Início da serviço de alterar estoque");
        try {
            log.debug("Service: Estoque alterado {}", estoque);
            return estoqueRepository.save(estoque);
        } catch (Exception erro) {
            log.error("Service: Erro desconhecido ao alterar o estoque {}", erro);
            return null;
        }
    }

    public void deletarProdutoPorId(Long id) {
        log.info("Service: Início da serviço de exlcuir estoque");
        try {
            log.debug("Service: Id do estoque que será excluido {}", id);
            estoqueRepository.deleteById(id);
        } catch (Exception erro) {
            log.error("Service: Erro ao excluir o estoque {}", erro);
        }
    }
}
