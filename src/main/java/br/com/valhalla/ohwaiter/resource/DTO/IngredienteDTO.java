package br.com.valhalla.ohwaiter.resource.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredienteDTO {
    
    private String nome;
    private Integer quantidade;

}
