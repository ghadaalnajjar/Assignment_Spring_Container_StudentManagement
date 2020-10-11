package org.example.util;

import org.springframework.stereotype.Component;

@Component("userInputService")
public class ScannerInputService implements UserInputService {

    @Override
    public String  getString() {
        return "getString()";
    }

    @Override
    public Integer getInt() {
        return 1;
    }
}
