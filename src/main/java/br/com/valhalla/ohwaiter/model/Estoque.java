package br.com.valhalla.ohwaiter.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import br.com.valhalla.ohwaiter.model.Enums.CategoriaProduto;
import br.com.valhalla.ohwaiter.model.Enums.UnidadeQuantidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Nome do produto é obrigatório")
    private String nome;
    @NotNull(message = "Categoria é obrigatória")
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoriaProduto;
    @NotNull(message = "Quantidade é obrigatória")
    @PositiveOrZero(message = "A quantidade deve ser de 0 ou maior")
    private Integer quantidade;
    @NotNull(message = "Unidade de médida é obrigatória")
    @Enumerated(EnumType.STRING)
    private UnidadeQuantidade unidadeQuantidade;
}