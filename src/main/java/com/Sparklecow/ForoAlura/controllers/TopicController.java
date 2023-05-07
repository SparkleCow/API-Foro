package com.Sparklecow.ForoAlura.controllers;


import com.Sparklecow.ForoAlura.entities.Topic;
import com.Sparklecow.ForoAlura.services.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }
    
    @GetMapping
    public ResponseEntity<List<Topic>> findAllTopics(){
        return topicService.findAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Topic>> findTopic(@PathVariable Long id){
        return topicService.findTopic(id);
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){
        return topicService.createTopic(topic);
    }

    @PutMapping
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic){
        return topicService.updateTopic(topic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Topic> deleteTopic(@PathVariable Long id){
        return topicService.deleteTopic(id);
    }

    @DeleteMapping
    public ResponseEntity<Topic> deleteAllTopic(){
        return topicService.deleteAllTopics();

    }
}
