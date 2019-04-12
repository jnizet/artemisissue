package com.example.artemisissue;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * The consumer of messages
 * @author JB Nizet
 */
@Component
@Transactional
public class Consumer {

    private final AtomicInteger count = new AtomicInteger(0);

    @JmsListener(destination = "queue/foo")
    public void receive(String message) {
        count.incrementAndGet();
    }

    public int getReceivedCount() {
        return count.get();
    }
}


