package me.oneorg.jdbc.repository;

import jakarta.annotation.PostConstruct;
import me.oneorg.jdbc.models.Student;
import me.oneorg.jdbc.models.StudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;
    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public void update(){
        String sql = """
                UPDATE students SET name=?,email=?,age=? WHERE id = ?
                """;
        int rowAffected = jdbcTemplate.update(sql, "king", "b", 22, 2);
        if (rowAffected == 1){
            System.out.println("updadted sucessfully");
        }else {
            System.out.println("update fauiled");
        }
    }
    public void create(){
        String sql = """
                INSERT INTO students (name,email,age) VALUES(?,?,?)
                """;
        int rowAffected = jdbcTemplate.update(sql, "khan", "a", 67);
        System.out.println(rowAffected);
    }
    public List<Student> getAll(){
        String sql = """
                SELECT id,name,email,age FROM students;
                """;
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }
}
