package com.skyding.learn.jmstx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weichunhe
 * created at 2019/1/24
 */
@Component("notificationProcessor")
public class JmsListener implements MessageListener {

    int count = 0;
    Map<String,Object> map = new HashMap<String, Object>();

    public void onMessage(Message message) {
        System.out.println("=====================================================");
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(textMessage.getText()+":"+textMessage.getJMSRedelivered());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        if(count++ %3 != 0){
            throw new RuntimeException(count+"");
        }
        System.out.println("------------------------------------------------------");
    }
}
