package com.liuqiang.service.service.sys;

import com.liuqiang.model.vo.sys.MessageVo;

/**
 * 消息发送
 * @author liuqiang
 */
public interface MessageService {
    /**
     * mq发送消息
     * @param messageVo 消息模版
     * @return true
     */
    boolean send(MessageVo messageVo);
}
