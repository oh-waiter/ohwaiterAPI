package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valhalla.ohwaiter.model.Funcionario;
import br.com.valhalla.ohwaiter.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario salvarProduto(Funcionario estoque){
        return funcionarioRepository.save(estoque);
    }

    public Funcionario buscarProdutoPorId(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public List<Funcionario> buscarTodosOsProdutos(){
        return funcionarioRepository.findAll();
    }

    public Funcionario alterarProdutoPorId(Long id){
        Funcionario produto = funcionarioRepository.findById(id).orElse(null);
        return funcionarioRepository.save(produto);
    }

    public void deletarProdutoPorId(Long id){
        funcionarioRepository.deleteById(id);
    }
}
