package org.example.Exceptions;

public class InvalidReparatieException extends RuntimeException {
    public InvalidReparatieException(String message){
        super(message);
    }
}
