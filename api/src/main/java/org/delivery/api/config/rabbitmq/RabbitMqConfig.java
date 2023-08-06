package org.delivery.api.config.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    // Exchange, Queue 이름 설정
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("delivery.exchange");
    }
    @Bean
    public Queue queue(){
        return new Queue("delivery.queue");
    }


    // Exchange 와 QUeue Binding
    @Bean
    public Binding binding(DirectExchange directExchange, Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with("delivery.key");
    }


    // Producer -> Exchange 데이터를 보낼때 사용하는 http 프로토콜 탬플릿
    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory, //amqp.rabbit.connection.ConnectionFactory
            MessageConverter messageConverter //.amqp.support.converter.MessageConverter
    ){
        var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    // setMessageConverter : object -> json -> object ( = objectmapper )
    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper){
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    // connectionFactory -> application.yaml에 설정
}
