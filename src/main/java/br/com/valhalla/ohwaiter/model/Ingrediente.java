package br.com.valhalla.ohwaiter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingrediente {

    private String produto;
    private Integer quantidade;
}
