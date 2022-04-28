package com.liuqiang.commons.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mq消息转换器
 * @author LiuQiang
 * @date 11:14 下午
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue monthlyQueue() {
        return new Queue(MqInfo.MONTHLY_QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange monthlyExchange() {
        return new DirectExchange(MqInfo.MONTHLY_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Binding monthlyBinding() {
        return BindingBuilder.bind(monthlyQueue()).to(monthlyExchange()).with(MqInfo.MONTHLY_ROUTING_KEY);
    }

    @Bean
    public Queue practiceQueue(){
        return new Queue(MqInfo.PRACTICE_QUEUE_NAME,true);
    }

    @Bean
    public DirectExchange practiceExchange(){
        return new DirectExchange(MqInfo.PRACTICE_EXCHANGE_NAME,true,true);
    }

    @Bean
    public Binding practiceBinding(){
        return BindingBuilder.bind(practiceQueue()).to(practiceExchange()).with(MqInfo.PRACTICE_ROUTING_KEY);
    }

//    @Bean
//    public RabbitTemplate rabbitTemplate() {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate();
//        return rabbitTemplate;
//    }
}
