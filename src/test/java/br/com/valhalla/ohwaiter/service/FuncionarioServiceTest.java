package br.com.valhalla.ohwaiter.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.valhalla.ohwaiter.configTest.ApplicationConfigTest;
import br.com.valhalla.ohwaiter.repository.FuncionarioRepository;

@DisplayName("FuncionarioServiceTest")
public class FuncionarioServiceTest extends ApplicationConfigTest {

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @Test
    @DisplayName("Remover usuário usando ID")
    public void deveRemoverUmFuncionarioPeloId() {

    }
}
