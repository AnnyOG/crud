package com.example.crud_jpa.service.Impl;

import com.example.crud_jpa.service.CommandService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Override
    public void commandNotify(String message) {
        amqpTemplate.convertAndSend("queue", message);
    }
}
