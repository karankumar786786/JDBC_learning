package me.oneorg.jdbc;

import me.oneorg.jdbc.models.Student;
import me.oneorg.jdbc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class rest {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public void update(){
        studentRepository.update();
    }
    @GetMapping("/c")
    public void create(){
        studentRepository.create();
    }
    @GetMapping("/g")
    public List<Student> get(){
        return studentRepository.getAll();
    }
}
