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

    public Funcionario salvarFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario buscarFuncionarioPorId(Long id){
        return funcionarioRepository.findById(id).orElse(null);
    }

    public List<Funcionario> buscarTodosOsFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public Funcionario alterarFuncionarioPorId(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionarioPorId(Long id){
        funcionarioRepository.deleteById(id);
    }
}
