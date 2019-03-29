package de.schmowser.radio;

import de.schmowser.radio.Utils.KafkaPublisher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KafkaTemplateTest {

    private KafkaPublisher kafkaPublisher = new KafkaPublisher();

    @Test
    public void sendMessageTest() throws Exception {

        kafkaPublisher.sendMessage("This is a testimonial!");

    }

}
