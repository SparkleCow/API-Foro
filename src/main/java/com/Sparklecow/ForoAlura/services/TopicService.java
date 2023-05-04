package com.Sparklecow.ForoAlura.services;

import com.Sparklecow.ForoAlura.entities.Topic;
import com.Sparklecow.ForoAlura.repository.TopicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private final TopicRepository repository;
    public TopicService(TopicRepository repository) {
        this.repository = repository;
    }


    //Metodo para encontrar todos los topicos
    public ResponseEntity<List<Topic>> findAllTopics(){
        return ResponseEntity.ok(repository.findAll());
    }

    //Metodo para encontrar un topico
    public ResponseEntity<Optional<Topic>> findTopic(Long id){
        Optional<Topic> topicOpt = repository.findById(id);
        if(topicOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(topicOpt);
    }

    //Metodo para crear un topico
    public ResponseEntity<Topic> createTopic(Topic topic){
        if(topic.getId()!=null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repository.save(topic));
    }

    //Metodo para actualizar un topico
    public ResponseEntity<Topic> updateTopic(Topic topic){
        if(topic.getId()==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(repository.save(topic));
    }

    //Metodo para eliminar un topicop
    public ResponseEntity<Topic> deleteTopic(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Metodo para eliminar todos los topicos
    public ResponseEntity<Topic> deleteAllTopics(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
