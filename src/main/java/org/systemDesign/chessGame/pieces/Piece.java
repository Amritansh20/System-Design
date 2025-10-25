package org.systemDesign.chessGame.pieces;

import org.systemDesign.chessGame.Board;
import org.systemDesign.chessGame.Cell;
import org.systemDesign.chessGame.Color;


public abstract class Piece {
    Color color;
    public Piece(Color color){
        this.color=color;
    }

    public abstract boolean canMove(Board board, Cell from, Cell to);

    public Color getColor(){
        return this.color;
    }
}
