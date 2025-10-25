package org.systemDesign.chessGame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    String name;
    Color playerColor;

    public Player(String name, Color playerColor){
        this.name=name;
        this.playerColor=playerColor;
    }
}
