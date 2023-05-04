package com.Sparklecow.ForoAlura.repository;


import com.Sparklecow.ForoAlura.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
