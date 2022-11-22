package br.com.valhalla.ohwaiter.resource.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PratoDTO {
    
    private String nome;
    private List<IngredienteDTO> ingredientes;
    private Integer tempoPreparo;

}
