/*package com.teams.project.core.utilities.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "test_queue";
    public static final String EXCHANGE_NAME = "test_exchange";
    public static final String ROUTING_KEY = "test_routing_key";

    //true => Kuyruk kalıcıdır, RabbitMQ yeniden başlasa da silinmez
    @Bean
    public Queue My_queue() {
        return new Queue(QUEUE_NAME,true,false,false);
    }
    @Bean
    public DirectExchange My_exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
*/