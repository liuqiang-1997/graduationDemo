package com.liuqiang.service.receiver;

import com.liuqiang.commons.config.rabbitmq.MqInfo;
import com.liuqiang.model.vo.sys.MessageVo;
import com.liuqiang.service.service.sys.MessageService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 月报消息监听器
 * @author LiuQiang
 * @date 12:17 上午
 */
@Component
public class MonthlyReceiver {
    @Autowired
    private MessageService messageService;

    @RabbitListener(bindings = @QueueBinding(
            value =@Queue( value = MqInfo.MONTHLY_QUEUE_NAME,durable = "true"),
            exchange = @Exchange(value = MqInfo.MONTHLY_EXCHANGE_NAME),key={MqInfo.MONTHLY_ROUTING_KEY}))
    public void sendMonthly(MessageVo messageVo, Message message, Channel channel){
        // 消息处理逻辑
        messageService.send(messageVo);
    }
}
