package com.liuqiang.service.service.impl.sys;


import com.liuqiang.model.vo.sys.MessageVo;
import com.liuqiang.service.service.sys.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 发送系统消息
 * @author LiuQiang
 * @date 11:54 下午
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Override
    public boolean send(MessageVo messageVo) {



        System.err.println("++++++++++++++++++++++++++++++++++++");
        log.info(String.valueOf(messageVo));
        System.err.println(messageVo);
        System.err.println("++++++++++++++++++++++++++++++++++++");
     return true;
    }
}
