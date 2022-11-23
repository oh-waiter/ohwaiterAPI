package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Reserva;
import br.com.valhalla.ohwaiter.model.Enums.Status;
import br.com.valhalla.ohwaiter.resource.DTO.ReservaDTO;
import br.com.valhalla.ohwaiter.service.ReservaService;

@RestController
@RequestMapping("reserva")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservaResources {
    @Autowired
    private ReservaService reservaService;

    @GetMapping("health")
    public String health() {
        return "Ok!";
    }

    @GetMapping(path = "todas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reserva>> buscarTodasAsReserva() {
        return ResponseEntity.ok().body(reservaService.buscarTodasAsReserva());
    }

    @GetMapping(path = "abertas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reserva>> buscarReservasEmAberto() {
        return ResponseEntity.ok().body(reservaService.buscarReservasPorStatus(Status.ABERTO));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reserva> savarReserva(@RequestBody ReservaDTO reserva) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.salvarReserva(reserva));
    }

    @PatchMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reserva> alterarStatus(@RequestBody String status, @PathVariable Long id) {
        return ResponseEntity.ok().body(reservaService.alterarStatusReserva(status, id));
    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reserva> alterarReserva(Reserva reserva) {
        return ResponseEntity.ok().body(reservaService.alterarReserva(reserva));
    }
}
