package com.example.redisexample.apis;

import com.example.redisexample.models.Student;
import com.example.redisexample.services.dto.StudentDTO;
import com.example.redisexample.services.services.StudentAppliactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/users")
public class StudentApi {

    @Autowired
    private StudentAppliactionService service;

    @PostMapping
    public StudentDTO save(@RequestBody StudentDTO student){
        return service.save(student);
    }

    @GetMapping(path="/{id}")
    public StudentDTO findAll(@PathVariable  String id){
        return service.findById(id);
    }
}
