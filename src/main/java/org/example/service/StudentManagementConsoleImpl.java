package org.example.service;

import org.example.data_access.StudentDao;
import org.example.model.Student;
import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("studentManagement")
public class StudentManagementConsoleImpl implements StudentManagement {

    private List<Student> students = new ArrayList<>();
    private StudentDao studentDao;
    private UserInputService userInputService;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }
    @Override
    public Student create() {
        return studentDao.save(new Student(userInputService.getString()));
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student student = find(id);
        studentDao.delete(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        return studentDao.save(student);
    }

}
