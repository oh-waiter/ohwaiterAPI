package br.com.valhalla.ohwaiter.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.valhalla.ohwaiter.model.Enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reserva;
    @OneToMany()
    @JoinColumn(name = "mesas_id")
    private List<Mesa> mesas;
    @OneToMany()
    @JoinColumn(name = "pratos_id")
    private List<Prato> prato;
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Enumerated(EnumType.STRING)
    private Status status;
    private int tempoPrepardoTotal = 0;
    private LocalDateTime horarioDaReserva;
}
