package com.example.redisexample.repositories.impl;

import com.example.redisexample.models.Student;
import com.example.redisexample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("studentRepositoryMongoImpl")
public class StudentRepositoryMongoImpl implements StudentRepository {
    @Override
    public Optional<Student> save(Student user){
        return Optional.empty();
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Student>> findAll() {
        return Optional.empty();
    }
}
