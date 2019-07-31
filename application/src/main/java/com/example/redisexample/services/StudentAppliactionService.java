package com.example.redisexample.services;

import com.example.redisexample.models.Student;
import com.example.redisexample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentAppliactionService {

    @Autowired
    @Qualifier("studentRepositoryMongoImpl")
    private StudentRepository mongoRepository;

    @Autowired
    @Qualifier("studentRepositoryRedisImpl")
    private StudentRepository redisRepository;

    public Student save(Student student){
        redisRepository.save(student);
        mongoRepository.save(student);
        return student;
    }

    public Optional<Student> findById(String id){
        Optional<Student> optionalStudent = redisRepository.findById(id);
        if(!optionalStudent.isPresent()){
           optionalStudent = mongoRepository.findById(id);
        }
        return  optionalStudent;
    }
}
