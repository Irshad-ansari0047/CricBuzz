package com.example.CricBuzz.exception;

public class PlayerNotFoundException extends RuntimeException{

    public PlayerNotFoundException(String s){
        super(s);
    }
}
