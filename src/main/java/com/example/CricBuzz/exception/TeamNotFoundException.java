package com.example.CricBuzz.exception;

public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException(String s){
        super(s);
    }
}
