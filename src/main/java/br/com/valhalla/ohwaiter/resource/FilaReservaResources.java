package br.com.valhalla.ohwaiter.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.valhalla.ohwaiter.mensageria.QueueSender;

@RestController
@RequestMapping("reserva")
public class FilaReservaResources {

    @Autowired
    private QueueSender queueSender;

    @GetMapping("health")
    public String health() {
        queueSender.send("It's OK!");
        return "Ok!";
    }

}
