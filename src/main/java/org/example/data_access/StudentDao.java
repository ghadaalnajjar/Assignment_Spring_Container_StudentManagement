package org.example.data_access;

import org.example.model.Student;
import java.util.List;

public interface StudentDao {

    Student save (Student student);
    Student find(Integer id);
    List<Student> findAll();
    void delete (int id);
}
