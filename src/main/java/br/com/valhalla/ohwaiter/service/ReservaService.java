package br.com.valhalla.ohwaiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.valhalla.ohwaiter.mensageria.QueueSender;
import br.com.valhalla.ohwaiter.model.Reserva;

public class ReservaService {

    @Autowired
    private QueueSender queueSender;

    private static List<Reserva> reservas;

}
