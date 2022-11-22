package br.com.valhalla.ohwaiter.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.valhalla.ohwaiter.model.Enums.Funcao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "")
    private String nome;
    @NotNull(message = "O CPF deve ser adicionado")
    @CPF(message = "O CPF deve ser válido")
    private String cpf;
    @NotNull(message = "A função é obrigatório")
    @Enumerated(EnumType.STRING)
    private Funcao funcao;
    private Boolean ativo;

}
