package com.mftn.cqrs.design.pattern.example.rabbitmq.publisher;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface RabbitMqPublisher {
    void publish(String queueName, String data) throws IOException, TimeoutException;
}
