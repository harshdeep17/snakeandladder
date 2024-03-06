package com.example.snakeandladder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends BaseModel{
    private String name;
    private int position;
    private boolean winner;
    public Player(String name){
        this.name=name;
        this.position=1;
        this.winner=false;
    }
}
