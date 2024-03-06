package com.example.snakeandladder.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Dice extends BaseModel{
    private int minValue;
    private int maxValue;
    private int currValue;
    public int roll(){
        Random random=new Random();
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }
}
