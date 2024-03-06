package com.example.snakeandladder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Game extends BaseModel{
    private int size;
    private int numberOfSnakes;
    private int numberOfLadders;

    private Board board;
    private Dice dice;

    private Queue<Player> players;

    public Game(int size, int numberOfSnakes, int numberOfLadders){
        this.size=size;
        this.numberOfSnakes=numberOfSnakes;
        this.numberOfLadders=numberOfLadders;
        this.players = new ArrayDeque<>();
        board=new Board(size, numberOfLadders, numberOfSnakes);
        dice = new Dice(1, 6, 2);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    public void playGame(){
        while(players.size()>=2){
            Player currPlayer=players.poll();
            int faceValue=dice.roll();
            int newPosition=currPlayer.getPosition()+faceValue;
            if(newPosition>board.getEnd()){
                players.offer(currPlayer);
            }else {
                currPlayer.setPosition(getNewPosition(newPosition));
                if(newPosition==board.getEnd()){
                    currPlayer.setWinner(true);
                    System.out.println("Player " + currPlayer.getName() + " Won.");
                }else{
                    System.out.println("Setting " + currPlayer.getName() + "'s new position to " + currPlayer.getPosition());
                    players.offer(currPlayer);
                }
            }
        }
    }
    public int getNewPosition(int position){
       if(board.getSnakeOrLadderMoveMap().containsKey(position)) {
           Move move=board.getSnakeOrLadderMoveMap().get(position);
           position = move.getEndPosition();
           System.out.println(move.getEncounterMessage());
           System.out.println(move.getString());
       }
       return position;
    }
}
