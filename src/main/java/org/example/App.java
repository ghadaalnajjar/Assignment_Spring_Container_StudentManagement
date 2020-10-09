package org.example;

import org.example.config.AppConfig;
import org.example.data_access.StudentDao;
import org.example.data_access.StudentDaoListImpl;
import org.example.model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App {

    public static void main(String args[]) {
        StudentDao studentDao = new StudentDaoListImpl();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); //using for AnnotationConfigApplicationContext

        StudentDao dao = context.getBean("studentDao", StudentDao.class);
        Student student = new Student("Ana");
        Student student1 = dao.save(student);
        Student student2 = dao.save(new Student("ana2"));
        System.out.println("student.toString() = " + student1.toString());

        Student findStudent = dao.find(student.getId());
        System.out.println("findStudent = " + findStudent.toString());

        List<Student> findAllStudent = dao.findAll();
        System.out.println("findAllStudent = " + findAllStudent.toString());

    }
}

