package br.com.valhalla.ohwaiter.resource.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.valhalla.ohwaiter.model.Promocao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromocaoDTO {
    private Long id;
    private String nomePromocao;
    private String codigoPromocional;
    private String tipoPromocao;
    private String descricaoPromocao;
    private Boolean ativo;

    public static PromocaoDTO modelToDto(Promocao promocao){
        return PromocaoDTO.builder()
        .id(promocao.getId())
        .nomePromocao(promocao.getNomePromocao())
        .codigoPromocional(promocao.getCodigoPromocional())
        .tipoPromocao(promocao.getTipoPromocao())
        .descricaoPromocao(promocao.getDescricaoPromocao())
        .ativo(promocao.getAtivo())
        .build();
    }

    public static List<PromocaoDTO> modelToDto(List<Promocao> promocoes){
        List<PromocaoDTO> promocaoDtos = new ArrayList<>();
        promocoes.forEach(promocao ->{
            promocaoDtos.add(PromocaoDTO.builder()
            .id(promocao.getId())
            .nomePromocao(promocao.getNomePromocao())
            .codigoPromocional(promocao.getCodigoPromocional())
            .tipoPromocao(promocao.getTipoPromocao())
            .descricaoPromocao(promocao.getDescricaoPromocao())
            .ativo(promocao.getAtivo())
            .build());
            });
        return promocaoDtos;
    }

    public static Promocao DtoToModel(PromocaoDTO promocaoDto){
        return Promocao.builder()
        .id(promocaoDto.getId())
            .nomePromocao(promocaoDto.getNomePromocao())
            .codigoPromocional(promocaoDto.getCodigoPromocional())
            .tipoPromocao(promocaoDto.getTipoPromocao())
            .descricaoPromocao(promocaoDto.getDescricaoPromocao())
            .ativo(promocaoDto.getAtivo())
            .build();
    }

}
