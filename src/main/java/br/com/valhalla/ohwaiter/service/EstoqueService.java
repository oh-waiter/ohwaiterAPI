package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.model.Estoque;
import br.com.valhalla.ohwaiter.repository.EstoqueRepository;

@Service
public class EstoqueService {
    private EstoqueRepository estoqueRepository;

    @Autowired
    public EstoqueService(EstoqueRepository estoqueRepository){
        this.estoqueRepository = estoqueRepository;
    }

    public Estoque salvarProduto(Estoque estoque){
        return estoqueRepository.save(estoque);
    }

    public Estoque buscarProdutoPorId(Long id){
        return estoqueRepository.findById(id).orElse(null);
    }

    public List<Estoque> buscarTodosOsProdutos(){
        return estoqueRepository.findAll();
    }

    public Estoque alterarProduto(Estoque estoque){
        return estoqueRepository.save(estoque);
    }

    public void deletarProdutoPorId(Long id){
        estoqueRepository.deleteById(id);
    }
}
