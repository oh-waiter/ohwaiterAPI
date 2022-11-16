package br.com.valhalla.ohwaiter.config;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.valhalla.ohwaiter.model.Reserva;

@Component
public class QueueConsumer {

    private static List<Reserva> reservas;

    @RabbitListener(queues = { "${queue.name}" })
    public void receive(@Payload Reserva fileBody) {
        System.out.println("message " + fileBody);
    }

    publci void
}
