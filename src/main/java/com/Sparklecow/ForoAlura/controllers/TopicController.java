package com.Sparklecow.ForoAlura.controllers;


import com.Sparklecow.ForoAlura.entities.DataRegisterTopic;
import com.Sparklecow.ForoAlura.entities.DataResponseTopic;
import com.Sparklecow.ForoAlura.entities.DataUpdateTopic;
import com.Sparklecow.ForoAlura.services.TopicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }
    
    @GetMapping
    public ResponseEntity<List<DataResponseTopic>> findAllTopics(){
        return topicService.findAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseTopic> findTopic(@PathVariable Long id){
        return topicService.findTopic(id);
    }

    @PostMapping
    public ResponseEntity<DataResponseTopic> createTopic(@RequestBody @Valid DataRegisterTopic dataRegisterTopic){
        return topicService.createTopic(dataRegisterTopic);
    }

    @PutMapping
    public ResponseEntity<DataResponseTopic> updateTopic(@RequestBody @Valid DataUpdateTopic dataUpdateTopic){
        return topicService.updateTopic(dataUpdateTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic(@PathVariable Long id){
        return topicService.deleteTopic(id);
    }

    @DeleteMapping
    public ResponseEntity deleteAllTopic(){
        return topicService.deleteAllTopics();

    }
}
