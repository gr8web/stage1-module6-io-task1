package com.epam.mjc.io;

public class ProfileFileException extends RuntimeException {
    public ProfileFileException(String message) {
        super(message);
    }

    public ProfileFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
