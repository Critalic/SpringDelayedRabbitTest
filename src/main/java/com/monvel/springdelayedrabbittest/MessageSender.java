package com.monvel.springdelayedrabbittest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendDelayedMessage(String message, int delay) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.DELAYED_EXCHANGE,
                RabbitMQConfig.DELAYED_ROUTING_KEY,
                message,
                msg -> {
                    msg.getMessageProperties().setHeader("x-delay", delay);
                    return msg;
                }
        );
        System.out.println(LocalDateTime.now());
    }
}
