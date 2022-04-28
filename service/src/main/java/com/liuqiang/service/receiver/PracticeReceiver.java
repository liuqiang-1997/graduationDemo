package com.liuqiang.service.receiver;

import com.liuqiang.commons.config.rabbitmq.MqInfo;
import com.liuqiang.model.vo.sys.MessageVo;
import com.liuqiang.service.service.sys.MessageService;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * mq实习消息监听器
 * @author LiuQiang
 * @date 11:57 下午
 */
@Component
public class PracticeReceiver {

    @Autowired
    private MessageService messageService;

    @RabbitListener(bindings = @QueueBinding(
                                             value =@Queue( value = MqInfo.PRACTICE_QUEUE_NAME,durable = "true"),
    exchange = @Exchange(value = MqInfo.PRACTICE_EXCHANGE_NAME),key={MqInfo.PRACTICE_ROUTING_KEY}))
    public void sendPractice(MessageVo messageVo, Message message, Channel channel){
        messageService.send(messageVo);
    }
}
