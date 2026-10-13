package me.oneorg.jdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.oneorg.jdbc.models.Student;
import me.oneorg.jdbc.models.StudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
         entityManager.persist(student);
    }

    public Student findById(Long id){
        return entityManager.find(Student.class,id);
    }
    public void remove(Long id){
        entityManager.remove(id);
    }
}
