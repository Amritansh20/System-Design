package org.systemDesign.chessGame;

import lombok.Getter;

@Getter
public class Move {
    Cell start;
    Cell end;

    public Move(Cell start, Cell end){
        this.start=start;
        this.end=end;
    }
}
