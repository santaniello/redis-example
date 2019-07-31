package com.example.redisexample.repositories.impl;

import com.example.redisexample.models.Student;
import com.example.redisexample.repositories.StudentRepository;
import com.example.redisexample.repositories.StudentRepositoryMongoSpringData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("studentRepositoryMongoImpl")
public class StudentRepositoryMongoImpl implements StudentRepository {
    @Autowired
    private StudentRepositoryMongoSpringData repository;
    @Override
    public Optional<Student> save(Student student){
        repository.save(student);
        return Optional.of(student);
    }

    @Override
    public Optional<Student> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Optional<List<Student>> findAll() {
        return Optional.empty();
    }
}
