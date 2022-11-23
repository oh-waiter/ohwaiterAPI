package br.com.valhalla.ohwaiter.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Enums.Status;
import br.com.valhalla.ohwaiter.service.ReservaService;

@RestController
@RequestMapping("cozinha")
@CrossOrigin(origins = "http://localhost:4200")
public class CozinhaResources {

    @Autowired
    private ReservaService reservaService;

    @PutMapping(path = "preparando/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> preparandoReserva(@PathVariable Long id){
        reservaService.alterarStatusReserva(Status.PREPARANDO.getDescricao(), id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "finalizado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> finalizarReserva(@PathVariable Long id){
        reservaService.alterarStatusReserva(Status.AGUARDANDO.getDescricao(), id);
        return ResponseEntity.noContent().build();
    }
    
}
