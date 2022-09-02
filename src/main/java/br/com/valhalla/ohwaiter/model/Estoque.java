package br.com.valhalla.ohwaiter.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Estoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    //Pode se tornar uma tabela no futuro
    private String categoriaProduto;
    private Integer quantidade;
    //Pode se tornar uma tabela no futuro
    private String unidadeQuantidade;
    //Pode se tornar uma tabela no futuro
    private String tipoArmazenamento;
    private BigDecimal custo;
    //Pode se tornar uma tabela no futuro
    private String fornecedor;

}
