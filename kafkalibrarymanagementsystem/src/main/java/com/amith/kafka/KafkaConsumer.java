package com.amith.kafka;

import com.amith.payload.User;
import com.amith.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private final UserRepository userRepository;

    public KafkaConsumer(UserRepository reviewRepository) {
        this.userRepository = reviewRepository;
    }

    @KafkaListener(topics = "library", groupId = "springGroup")
    public void consume(User user){
        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
        userRepository.save(user);
    }

}
