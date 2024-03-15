package com.example.lunch.util;

public class AccessUserException extends RuntimeException{

    public AccessUserException(String message) {
        super("Your rights are not enough" + message);
    }
}
