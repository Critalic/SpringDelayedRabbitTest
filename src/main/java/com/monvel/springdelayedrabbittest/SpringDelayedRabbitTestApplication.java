package com.monvel.springdelayedrabbittest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDelayedRabbitTestApplication {

// Example usage:

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDelayedRabbitTestApplication.class, args);
        var sender = context.getBean(MessageSender.class);
        sender.sendDelayedMessage("Hello after 500 seconds", 500000);
        sender.sendDelayedMessage("Hello after 5 seconds", 5000);
        sender.sendDelayedMessage("Hello after 50 seconds", 50000);
        sender.sendDelayedMessage("Hello after 10 seconds", 10000);
        sender.sendDelayedMessage("Hello after 1 second", 1000);
    }

}
