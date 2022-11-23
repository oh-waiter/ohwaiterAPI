package br.com.valhalla.ohwaiter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.model.Prato;
import br.com.valhalla.ohwaiter.resource.DTO.PratoDTO;
import br.com.valhalla.ohwaiter.service.PratoService;

@RestController
@RequestMapping("prato")
@CrossOrigin(origins = "http://localhost:4200")
public class PratoResources {
    
    @Autowired
    private PratoService pratoService;

    @GetMapping(path = "health", produces = MediaType.APPLICATION_JSON_VALUE)
    public String health(){
        return "Ok!";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Prato>> pegarTodosOsPratos(){
        return ResponseEntity.ok().body(pratoService.pegarTodosOsPratos());
    }

    @GetMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Prato> pegarPratosPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(pratoService.pegarUmPratoPorId(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Prato> salvarPrato(@RequestBody PratoDTO pratoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pratoService.salvarPrato(pratoDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Prato> alterarPrato(@RequestBody Prato prato){
        Prato pratoOriginal = pratoService.pegarUmPratoPorId(prato.getId());
        if(pratoOriginal.getId() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(prato);
        }
        pratoService.alterarPrato(prato);
        return ResponseEntity.ok().body(prato);
    }

    @DeleteMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> excluirPrato(@PathVariable Long id){
        pratoService.excluirPrato(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
