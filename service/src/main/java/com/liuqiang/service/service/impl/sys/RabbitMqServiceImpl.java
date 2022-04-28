package com.liuqiang.service.service.impl.sys;

import com.liuqiang.service.service.sys.RabbitMqService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuQiang
 * @date 11:10 下午
 */
@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean sendMsg(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
        return true;
    }
}
