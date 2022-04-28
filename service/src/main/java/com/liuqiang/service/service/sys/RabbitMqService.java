package com.liuqiang.service.service.sys;

/**
 * rabbitmq
 * @author liuqiang
 */
public interface RabbitMqService {
    /**
     * 发送消息
     * @param exchange 交换机
     * @param routingKey 路由键
     * @param message 消息
     * @return true成功
     */
    boolean sendMsg(String exchange,String routingKey,Object message);
}
