package br.com.valhalla.ohwaiter.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "")
    private String nome;
    @NotNull(message = "O CPF deve ser adicionado")
    @CPF(message = "O CPF deve ser válido")
    private String cpf;
    //Pode se tornar uma tabela no futuro
    @NotNull(message = "A função é obrigatório")
    private String funcao;
    @NotNull(message = "O salário é obrigatório")
    @PositiveOrZero(message = "O salário deve ser de 0 ou maior")
    private BigDecimal salario;
    @PositiveOrZero(message = "A porcetagem da comissão deve ser maior ou igual a 0")
    private BigDecimal procentagemComissao;
    private Boolean ativo;
    //Pode se tornar uma tabela no futuro
    private String empresaAfiliado;
    //Pode se tornar uma tabela no futuro
    @NotNull(message = "A permissão é obrigatório")
    private String permissao;

    
    
}
