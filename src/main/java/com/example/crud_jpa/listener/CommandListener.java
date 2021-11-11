package com.example.crud_jpa.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
@RabbitListener(queues = "queue")
public class CommandListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        log.info("Received message from commander " + message);
    }
}
