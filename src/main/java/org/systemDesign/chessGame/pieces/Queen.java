package org.systemDesign.chessGame.pieces;

import org.systemDesign.chessGame.Board;
import org.systemDesign.chessGame.Cell;
import org.systemDesign.chessGame.Color;

public class Queen extends Piece{
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());
        return (rowDiff == colDiff) || (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}
