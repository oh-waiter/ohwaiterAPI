package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Reserva;
import br.com.valhalla.ohwaiter.model.Enums.Status;
import br.com.valhalla.ohwaiter.service.ReservaService;

@RestController
@RequestMapping("garcom")
@CrossOrigin(origins = "http://localhost:4200")
public class GarcomResources {
    
    @Autowired
    private ReservaService reservaService;

    @GetMapping(path = "verificacao-reserva/{reserva}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> verificarReserva(@PathVariable String reserva){
        return ResponseEntity.ok().body(reservaService.verificaSeReservaExiste(reserva));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reserva>> buscaReservaComStatusAguardando(){
        return ResponseEntity.ok().body(reservaService.buscarReservasPorStatus(Status.AGUARDANDO));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> finalizarReserva(@PathVariable Long id){
        reservaService.alterarStatusReserva("Finalizado", id);
        return ResponseEntity.noContent().build();
    }
}
