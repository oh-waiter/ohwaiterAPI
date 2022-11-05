package br.com.valhalla.ohwaiter.resource.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.valhalla.ohwaiter.model.Estoque;
import br.com.valhalla.ohwaiter.model.Enums.CategoriaProduto;
import br.com.valhalla.ohwaiter.model.Enums.UnidadeQuantidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {

    private Long id;
    private String nome;
    private String categoriaProduto;
    private Integer quantidade;
    private String unidadeQuantidade;

    public static EstoqueDTO modelToDto(Estoque estoque) {
        return EstoqueDTO.builder()
                .id(estoque.getId())
                .nome(estoque.getNome())
                .categoriaProduto(estoque.getCategoriaProduto().getDescricao())
                .quantidade(estoque.getQuantidade())
                .unidadeQuantidade(estoque.getUnidadeQuantidade().getDescricao())
                .build();
    }

    public static List<EstoqueDTO> modelToDto(List<Estoque> estoques) {
        List<EstoqueDTO> dtos = new ArrayList<>();
        estoques.forEach(estoque -> {
            dtos.add(EstoqueDTO.builder()
                    .id(estoque.getId())
                    .nome(estoque.getNome())
                    .categoriaProduto(estoque.getCategoriaProduto().getDescricao())
                    .quantidade(estoque.getQuantidade())
                    .unidadeQuantidade(estoque.getUnidadeQuantidade().getDescricao())
                    .build());
        });
        return dtos;
    }

    public static Estoque DtoToModel(EstoqueDTO estoqueDTO) {
        return Estoque.builder()
                .id(estoqueDTO.getId())
                .nome(estoqueDTO.getNome())
                .categoriaProduto(CategoriaProduto.getEnum(estoqueDTO.getCategoriaProduto()))
                .quantidade(estoqueDTO.getQuantidade())
                .unidadeQuantidade(UnidadeQuantidade.getEnum(estoqueDTO.getUnidadeQuantidade()))
                .build();
    }

}
