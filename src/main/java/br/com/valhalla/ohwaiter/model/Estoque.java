package br.com.valhalla.ohwaiter.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
@Entity
public class Estoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome do produto é obrigatório")
    private String nome;
    //Pode se tornar uma tabela no futuro
    @NotNull(message = "Categoria é obrigatória")
    private String categoriaProduto;
    @NotNull(message = "Quantidade é obrigatória")
    @PositiveOrZero(message = "A quantidade deve ser de 0 ou maior")
    private Integer quantidade;
    //Pode se tornar uma tabela no futuro
    @NotNull(message = "Unidade de médida é obrigatória")
    private String unidadeQuantidade;
    //Pode se tornar uma tabela no futuro
    @NotNull(message = "Tipo de armazenamento é obrigatório")
    private String tipoArmazenamento;
    @NotNull(message = "Custo é obrigatório")
    @PositiveOrZero(message = "O custo deve ser de 0 ou maior")
    private BigDecimal custo;
    //Pode se tornar uma tabela no futuro
    private String fornecedor;

}
