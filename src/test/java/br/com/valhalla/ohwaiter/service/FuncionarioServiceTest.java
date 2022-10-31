package br.com.valhalla.ohwaiter.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.valhalla.ohwaiter.model.Funcionario;
import br.com.valhalla.ohwaiter.model.Enums.Funcao;
import br.com.valhalla.ohwaiter.repository.FuncionarioRepository;

public class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    private Funcionario funcionario;

    @BeforeEach
    public void init() {
        funcionario = Funcionario.builder()
                .id(1L)
                .nome("teste")
                .cpf("98991172008")
                .ativo(true)
                .funcao(Funcao.COORDENADOR)
                .build();
    }

    @DisplayName("Teste para salvar o funcionario")
    @Test
    public void DadoUmFuncionarioSaveOFuncionarioEFacaORetornoDoFuncionario() {

    }

}
