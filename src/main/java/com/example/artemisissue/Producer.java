package com.example.artemisissue;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * The producer of messages
 * @author JB Nizet
 */
@Component
@Transactional
public class Producer {

    private final JmsTemplate jmsTemplate;

    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(long delayAfterSendInMillis) throws InterruptedException {
        jmsTemplate.convertAndSend("queue/foo", "hello world");
        Thread.sleep(delayAfterSendInMillis);
    }
}
