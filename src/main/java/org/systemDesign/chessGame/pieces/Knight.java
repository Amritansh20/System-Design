package org.systemDesign.chessGame.pieces;

import org.systemDesign.chessGame.Board;
import org.systemDesign.chessGame.Cell;
import org.systemDesign.chessGame.Color;

public class Knight extends Piece{
    public Knight(Color color){
        super(color);
    }
    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(from.getRow()-to.getRow());
        int colDiff = Math.abs(from.getCol()- to.getCol());
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);

    }
}
