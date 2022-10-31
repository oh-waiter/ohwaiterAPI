package br.com.valhalla.ohwaiter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Insira o nome para a Promoção")
    private String nomePromocao;
    @NotNull(message = "Informe um nome ou número como código promocional")
    private String codigoPromocional;
    @NotNull(message = "Selecione o tipo de promoção")
    private String tipoPromocao;
    private String descricaoPromocao;
    private Boolean ativo;
}
