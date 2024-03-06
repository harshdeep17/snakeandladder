package com.example.snakeandladder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Board extends BaseModel{
    private int size;
    private int start;
    private int end;

    HashMap<Integer,Move> snakeOrLadderMoveMap;
    public Board(int size,int numberOfLadders,int numberOfSnakes){
        this.size=size;
        this.start=1;
        this.end=start+size-1;
        this.snakeOrLadderMoveMap=new HashMap<>();
        initBoard(numberOfLadders, numberOfSnakes);
    }
    private void initBoard(int numberOfSnakes,int numberOfLadders){
        HashSet<String> snakeLadderHst = new HashSet<>();
        Random random=new Random();

        for(int i=1;i<=numberOfSnakes;i++){
            while(true){
                int snakeStart=random.nextInt(end - start + 1) + start;
                int snakeEnd=random.nextInt(end - start + 1) + start;
                if(snakeEnd>=snakeStart)continue;
                String startEndPair= String.valueOf(snakeStart)+snakeEnd;
                if(!snakeLadderHst.contains(startEndPair)){
                    snakeOrLadderMoveMap.put(snakeStart,new Snake(snakeStart,snakeEnd));
                    snakeLadderHst.add(startEndPair);
                    break;
                }
            }
        }

        for(int i=1;i<=numberOfLadders;i++){
            while(true){
                int ladderStart=random.nextInt(end - start + 1) + start;
                int ladderEnd=random.nextInt(end - start + 1) + start;
                if(ladderStart>=ladderEnd)continue;
                String startEndPair= String.valueOf(ladderEnd)+ladderStart;
                if(!snakeLadderHst.contains(startEndPair)){
                    snakeOrLadderMoveMap.put(ladderStart,new Ladder(ladderStart,ladderEnd));
                    snakeLadderHst.add(startEndPair);
                    break;
                }
            }
        }
    }
//    public void printBoard(){
//        for(int i=end;i>=start;i--){
//            System.out.print(i+ " ");
//            if(hasSnakeOrLadder(i)){
//                System.out.print(cells.get(i).getString());
//            }else{
//                System.out.print("      ");
//            }
//            if(i % 10 == 0){
//                System.out.println();
//            }
//        }
//        System.out.println();
//    }
}
