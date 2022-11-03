package br.com.valhalla.ohwaiter.service;

import static org.mockito.ArgumentMatchers.any;
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
import org.mockito.Mockito;
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
    @DisplayName("Teste ao tentar salvar um funcionario com CPF repetido")
    public void TesteComFuncionarioComCPFRepetido() {
       Mockito.when(null);
    }

}
