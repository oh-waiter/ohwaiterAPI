package br.com.valhalla.ohwaiter.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @RabbitListener(queues = { "${queue.name}" })
    public void receive(@Payload String fileBody) {
        System.out.println("message " + fileBody);
    }
}
