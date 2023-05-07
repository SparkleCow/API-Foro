package com.Sparklecow.ForoAlura.services;

import com.Sparklecow.ForoAlura.entities.DataRegisterTopic;
import com.Sparklecow.ForoAlura.entities.DataResponseTopic;
import com.Sparklecow.ForoAlura.entities.DataUpdateTopic;
import com.Sparklecow.ForoAlura.entities.Topic;
import com.Sparklecow.ForoAlura.repository.TopicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private final TopicRepository repository;
    public TopicService(TopicRepository repository) {
        this.repository = repository;
    }


    //Metodo para encontrar todos los topicos
    public ResponseEntity<List<DataResponseTopic>> findAllTopics(){
        List<Topic> lista = repository.findAll();
        ArrayList<DataResponseTopic> array = new ArrayList<>();
        lista.forEach(x -> array.add(new DataResponseTopic(x.getId(), x.getTitulo(), x.getMensaje(),x.getFechaCreacion(),
                                            x.status, x.getAutor(),x.getCurso())));
        return ResponseEntity.ok(array);
    }

    //Metodo para encontrar un topico
    public ResponseEntity<DataResponseTopic> findTopic(Long id){
        Optional<Topic> topicOpt = repository.findById(id);
        return topicOpt.map(topic -> ResponseEntity.ok(new DataResponseTopic(topic.getId(), topic.getTitulo(),
                topic.getMensaje(), topic.getFechaCreacion(), topic.getStatus(),
                topic.getAutor(), topic.getCurso()))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Metodo para crear un topico
    public ResponseEntity<DataResponseTopic> createTopic(DataRegisterTopic dataRegisterTopic){
        Topic topic = repository.save(new Topic(dataRegisterTopic));
        return ResponseEntity.ok(new DataResponseTopic(topic.getId(),
                topic.getTitulo(),topic.getMensaje(), topic.getFechaCreacion(),
                topic.getStatus(),topic.getAutor(),topic.getCurso()));
    }

    //Metodo para actualizar un topico
    public ResponseEntity<DataResponseTopic> updateTopic(DataUpdateTopic dataUpdateTopic){
        if(repository.existsById(dataUpdateTopic.id())){
            Topic topic = repository.getReferenceById(dataUpdateTopic.id());
            topic.updateTopic(dataUpdateTopic);
            return ResponseEntity.ok(new DataResponseTopic(topic.getId(), topic.getTitulo(),
                    topic.getMensaje(), topic.getFechaCreacion(), topic.getStatus(),
                    topic.getAutor(), topic.getCurso()));
        }
        return ResponseEntity.notFound().build();
    }

    //Metodo para eliminar un topicop
    public ResponseEntity deleteTopic(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Metodo para eliminar todos los topicos
    public ResponseEntity deleteAllTopics(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
