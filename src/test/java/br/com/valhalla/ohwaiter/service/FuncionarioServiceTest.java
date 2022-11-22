package br.com.valhalla.ohwaiter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

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

    @DisplayName("Teste de busca de lista de funcionarios")
    @Test
    public void retornarUmaListaComFuncionarios() {

        funcionario = Funcionario.builder()
                .id(2L)
                .nome("teste")
                .cpf("98991172008")
                .ativo(true)
                .funcao(Funcao.COORDENADOR).build();

        Funcionario funcionario2 = Funcionario.builder()
                .id(1L)
                .nome("teste")
                .cpf("98991172008")
                .ativo(true)
                .funcao(Funcao.COORDENADOR)
                .build();

        when(funcionarioRepository.findAll()).thenReturn(List.of(funcionario, funcionario2));

        List<Funcionario> funcionarios = funcionarioService.buscarTodosOsFuncionarios();

        Assertions.assertThat(funcionarios.size()).isEqualTo(2);
        verify(funcionarioRepository, times(1)).findAll();

    }

    @DisplayName("Teste para salvar o funcionario")
    @Test
    public void dadoUmFuncionarioSaveOFuncionarioEFacaORetornoDoFuncionario() {
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
    public void testeDeAtualizacaoDeFuncionarios() {
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

        Assertions.assertThat(funcionarioRetorno).usingRecursiveComparison().isEqualTo(funcionario);
        verify(funcionarioRepository, times(1)).save(any(Funcionario.class));
        verifyNoMoreInteractions(funcionarioRepository);
    }

    @Test
    @DisplayName("Excluir Funcionario")
    public void excluirFuncionarioUsandoUmFuncionarioPorParametro() {
        Long funcionarioId = 1L;

        funcionarioService.deletarFuncionarioPorId(funcionarioId);

        verify(funcionarioRepository, times(1)).deleteById(funcionarioId);
    }

    @Test()
    @DisplayName("Enviar throw IllegalArgumentException ao enviar um id null")
    public void exibirThrowQuandoIdVierNull() {
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
