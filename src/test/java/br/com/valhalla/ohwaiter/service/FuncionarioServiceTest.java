package br.com.valhalla.ohwaiter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.valhalla.ohwaiter.model.Funcionario;
import br.com.valhalla.ohwaiter.model.Enums.Funcao;
import br.com.valhalla.ohwaiter.repository.FuncionarioRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("Teste para o service de funcionarios")
public class FuncionarioServiceTest {

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private FuncionarioService funcionarioService;

    private Funcionario funcionario;

    @DisplayName("Teste para salvar o funcionario")
    @Test
    public void DadoUmFuncionarioSaveOFuncionarioEFacaORetornoDoFuncionario() {
        funcionario = Funcionario.builder()
                .nome("teste")
                .cpf("98991172008")
                .ativo(true)
                .funcao(Funcao.COORDENADOR).build();

        Funcionario funcionarioSave = Funcionario.builder()
                .id(1L)
                .nome("teste")
                .cpf("98991172008")
                .ativo(true)
                .funcao(Funcao.COORDENADOR)
                .build();

        when(funcionarioRepository.save(any(Funcionario.class))).thenReturn(funcionarioSave);
        Funcionario funcionarioRetorno = funcionarioService.salvarFuncionario(funcionario);

        Assertions.assertThat(funcionarioRetorno).usingRecursiveComparison().isEqualTo(funcionarioSave);
        verify(funcionarioRepository, times(1)).save(any(Funcionario.class));
        verifyNoMoreInteractions(funcionarioRepository);
    }

    @Test
    @DisplayName("Teste para atualizar funcionario")
    public void TesteDeAtualizacaoDeFuncionarios() {
        funcionario = Funcionario.builder()
                .id(1L)
                .nome("teste1")
                .cpf("98991172008")
                .ativo(true)
                .funcao(Funcao.COORDENADOR).build();

        Funcionario funcionarioUpdate = Funcionario.builder()
                .id(1L)
                .nome("teste1")
                .cpf("98991172008")
                .ativo(true)
                .funcao(Funcao.COORDENADOR)
                .build();

        when(funcionarioService.alterarFuncionario(any(Funcionario.class))).thenReturn(funcionarioUpdate);
        Funcionario funcionarioRetorno = funcionarioService.alterarFuncionario(funcionarioUpdate);

        Assertions.assertThat(funcionarioRetorno).usingRecursiveComparison().isEqualTo(funcionarioUpdate);
        verify(funcionarioRepository, times(1)).save(any(Funcionario.class));
        verifyNoMoreInteractions(funcionarioRepository);
    }

    @Test
    @DisplayName("Excluir Funcionario")
    public void ExcluirFuncionarioUsandoUmFuncionarioPorParametro() {
        Long funcionarioId = 1L;

        funcionarioService.deletarFuncionarioPorId(funcionarioId);

        verify(funcionarioRepository, times(1)).deleteById(funcionarioId);
    }

    @Test()
    @DisplayName("Enviar throw IllegalArgumentException ao enviar um id null")
    public void ExibirThrowQuandoIdVierNull() {
        Long id = null;
        doThrow(new IllegalArgumentException("Id não pode ser nulo")).when(funcionarioRepository)
                .deleteById(id);
        try {
            funcionarioService.deletarFuncionarioPorId(id);
        } catch (IllegalArgumentException e) {
            assertEquals("Id não pode ser nulo", e.getMessage());
        }
    }
}
