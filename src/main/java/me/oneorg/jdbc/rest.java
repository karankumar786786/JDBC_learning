package me.oneorg.jdbc;

import me.oneorg.jdbc.models.Student;
import me.oneorg.jdbc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class rest {
    @Autowired
    private StudentRepository studentRepository;


    @PostMapping
    public void create(@RequestBody Student student){
        studentRepository.save(student);
    }
    @GetMapping("/{id}")
    public Student get(@PathVariable Long id){
        return studentRepository.findById(id);
    }
    @DeleteMapping
    public void delete(@PathVariable Long id){
        studentRepository.remove(id);
    }
}
