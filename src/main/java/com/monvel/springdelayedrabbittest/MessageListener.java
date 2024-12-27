package com.monvel.springdelayedrabbittest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageListener {

    @RabbitListener(queues = RabbitMQConfig.DELAYED_QUEUE)
    public void handleMessage(String message) {
        System.out.println(LocalDateTime.now());
        System.out.println("Received delayed message: " + message);
    }
}

