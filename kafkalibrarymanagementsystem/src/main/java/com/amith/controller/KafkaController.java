package com.amith.controller;

import com.amith.kafka.KafkaProducer;
import com.amith.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class KafkaController {

    private KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON message sent to topic.");
    }
//    @GetMapping("/add")
//    public ResponseEntity<String> getMap(){
////        kafkaProducer.sendMessage(user);
//        return ResponseEntity.ok("JSON message sent to topic.");
//    }


}
