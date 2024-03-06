package com.example.snakeandladder.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Move extends BaseModel{
    private int startPostion;
    private int endPosition;


    public Move(int startPostion, int endPosition) {
        this.startPostion = startPostion;
        this.endPosition = endPosition;
    }

    public abstract String getEncounterMessage();
    public abstract String getString();
}
