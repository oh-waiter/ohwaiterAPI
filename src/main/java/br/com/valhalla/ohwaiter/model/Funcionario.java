package br.com.valhalla.ohwaiter.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @CPF
    private String cpf;
    //Pode se tornar uma tabela no futuro
    private String funcao;
    private BigDecimal salario;
    private BigDecimal procentagemComissao;
    private Boolean ativo;
    //Pode se tornar uma tabela no futuro
    private String empresaAfiliado;
    //Pode se tornar uma tabela no futuro
    private String permissao;
    
}
