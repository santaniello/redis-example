package com.example.redisexample.apis;

import com.example.redisexample.models.Student;
import com.example.redisexample.services.StudentAppliactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class StudentApi {

    @Autowired
    private StudentAppliactionService service;

    @PostMapping
    public Student save(@RequestBody  Student student){
        return service.save(student);
    }

//    @GetMapping
//    public UserListDTO findAll(){
//        return service.findAll();
//    }
}
