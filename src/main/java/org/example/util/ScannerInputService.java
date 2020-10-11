package org.example.util;

import org.example.data_access.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("userInputService")
public class ScannerInputService implements UserInputService {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String  getString() {
        return scanner.next();
    }

    @Override
    public Integer getInt() {
        return scanner.nextInt();
    }
}
