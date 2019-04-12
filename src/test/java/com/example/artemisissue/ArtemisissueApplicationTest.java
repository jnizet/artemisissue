package com.example.artemisissue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtemisissueApplicationTest {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    @Test
    public void shouldSendAndReceiveWithoutDelay() throws InterruptedException {
        int count = consumer.getReceivedCount();
        producer.send(0L);
        Thread.sleep(500L);
        assertThat(consumer.getReceivedCount()).isEqualTo(count + 1);
    }

    @Test
    public void shouldSendAndReceiveWithDelay() throws InterruptedException {
        int count = consumer.getReceivedCount();
        producer.send(5000L);
        Thread.sleep(500L);
        assertThat(consumer.getReceivedCount()).isEqualTo(count + 1);
    }
}
