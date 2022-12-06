package br.com.valhalla.ohwaiter.resource.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaDTO {

    private List<Long> mesas;
    private List<Long> prato;
    private LocalDateTime horaDaReserva;
    private String cliente;

}
