package org.example.config;

import org.example.service.StudentManagement;
import org.example.service.StudentManagementConsoleImpl;
import org.example.util.ScannerInputService;
import org.example.util.UserInputService;
import org.example.data_access.StudentDao;
import org.example.data_access.StudentDaoListImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "org.example.*")
public class AppConfig {

    @Bean("studentDao")
    public StudentDao studentDao() {
        return new StudentDaoListImpl();
    }

    // Setter injection
    @Bean("userInputService")
    public UserInputService userInputService() {
        return new ScannerInputService();
    }

    @Bean("studentManagement")
    public StudentManagement studentManagement() {
        StudentManagementConsoleImpl studentManagementConsole = new StudentManagementConsoleImpl();
        studentManagementConsole.setStudentDao(studentDao());
        studentManagementConsole.setUserInputService(userInputService());
        return studentManagementConsole;
    }
}
