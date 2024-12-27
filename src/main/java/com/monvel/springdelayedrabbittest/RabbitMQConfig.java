package com.monvel.springdelayedrabbittest;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class RabbitMQConfig {

    public static final String DELAYED_EXCHANGE = "delayed_exchange";
    public static final String DELAYED_QUEUE = "delayed_queue";
    public static final String DELAYED_ROUTING_KEY = "delayed_routing_key";

    @Bean
    public CustomExchange delayedExchange() {
        return new CustomExchange(DELAYED_EXCHANGE, "x-delayed-message", true, false, Map.of("x-delayed-type", "direct"));
    }

    @Bean
    public Queue delayedQueue() {
        return new Queue(DELAYED_QUEUE, true);
    }

    @Bean
    public Binding delayedBinding(Queue delayedQueue, CustomExchange delayedExchange) {
        return BindingBuilder.bind(delayedQueue).to(delayedExchange).with(DELAYED_ROUTING_KEY).noargs();
    }
}
