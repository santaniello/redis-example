package com.example.redisexample.repositories.impl;

import com.example.redisexample.RedisKey;
import com.example.redisexample.RedisUtil;
import com.example.redisexample.models.Student;
import com.example.redisexample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("studentRepositoryRedisImpl")
public class StudentRepositoryRedisImpl implements StudentRepository {
    private static final String TABLE_STUDENT = "TABLE_STUDENT";
    private static final String STUDENT = "STUDENT_";
    private RedisUtil<Student> redisUtilStudent;
    private RedisKey<Student> key;

    @Autowired
    public StudentRepositoryRedisImpl(RedisUtil<Student> redisUtilStudent) {
        key = new RedisKey<>(TABLE_STUDENT);
        this.redisUtilStudent = redisUtilStudent;
    }

    @Override
    public Optional<Student> save(Student student){
        key.setKey(STUDENT+student.getId());
        key.setValue(student);
        redisUtilStudent.putMap(key);
        return Optional.of(student);
    }

    @Override
    public Optional<Student> findById(String id) {
        key.setKey(STUDENT+id);
        System.out.println("**********ID"+id);
        return Optional.of(redisUtilStudent.getMapAsSingleEntry(key));
    }

    @Override
    public Optional<List<Student>> findAll() {
        return Optional.empty();
    }
}
