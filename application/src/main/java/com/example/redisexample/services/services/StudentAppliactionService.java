package com.example.redisexample.services.services;

import com.example.redisexample.models.Student;
import com.example.redisexample.models.StudentMongoImpl;
import com.example.redisexample.models.StudentRedisImpl;
import com.example.redisexample.repositories.StudentRepository;
import com.example.redisexample.services.dto.StudentDTO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentAppliactionService {

    @Autowired
    @Qualifier("studentRepositoryMongoImpl")
    private StudentRepository mongoRepository;

    @Autowired
    @Qualifier("studentRepositoryRedisImpl")
    private StudentRepository redisRepository;

    public StudentDTO save(StudentDTO dto){
        DozerBeanMapper mapper = new DozerBeanMapper();
        Student studentMongo = mapper.map(dto, StudentMongoImpl.class);
        Student studentRedis = mapper.map(dto, StudentRedisImpl.class);
        String id = UUID.randomUUID().toString();
        studentMongo.setId(id);
        studentRedis.setId(id);
        redisRepository.save(studentRedis);
        mongoRepository.save(studentMongo);
        return dto;
    }

    public StudentDTO findById(String id){
        Optional<Student> optionalStudent = redisRepository.findById(id);
        if(!optionalStudent.isPresent()){
           optionalStudent = mongoRepository.findById(id);
        }
        Student student = optionalStudent.get();
        DozerBeanMapper mapper = new DozerBeanMapper();
        StudentDTO dto = mapper.map(student, StudentDTO.class);

        return  dto;
    }
}
