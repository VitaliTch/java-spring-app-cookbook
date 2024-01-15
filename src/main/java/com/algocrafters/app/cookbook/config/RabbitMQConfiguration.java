package com.algocrafters.app.cookbook.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * A Configuration class serves Bean instances for connecting to RabbitMQ Messaging Server.
 *
 * TODO: status - work in progress
 *
 * @see ApiSecurityConfiguration
 * @since 0.1
 *
 * @author Vitali Tchalov (github.com/VitaliTch)
 * @author {name}
 */
//@Configuration
//@EnableRabbit
//@ComponentScan(basePackages = )
public class RabbitMQConfiguration {
    @Bean
    public Queue hello() {
        return new Queue("testqueue");
    }

//    @Bean
//    public RabbitQueueListener rabbitQueueListener() {
//        return new RabbitQueueListener();
//    }
}
