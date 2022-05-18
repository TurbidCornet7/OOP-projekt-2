package com.example.project2;

public class Erind extends RuntimeException{
    private String selgitus;

    public Erind(String selgitus) {
        this.selgitus = selgitus;
    }
}
