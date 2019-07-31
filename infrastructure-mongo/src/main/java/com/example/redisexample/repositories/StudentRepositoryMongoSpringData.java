package com.example.redisexample.repositories;

import com.example.redisexample.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositoryMongoSpringData extends MongoRepository<Student, Long> {
    List<Student> findAll();
}