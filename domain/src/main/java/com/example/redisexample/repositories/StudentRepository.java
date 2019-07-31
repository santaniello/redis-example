package com.example.redisexample.repositories;

import com.example.redisexample.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> save(Student user);
    Optional<Student> findById(String id);
    Optional<List<Student>> findAll();
}