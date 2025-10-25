package org.systemDesign.chessGame;

import lombok.Getter;
import lombok.Setter;
import org.systemDesign.chessGame.pieces.*;

@Getter
@Setter
public class Board {
    Cell[][] board;

    public Board(){
        board = new Cell[8][8];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j]= new Cell(i,j);
            }
        }

        setPieces();
    }

    public void setPieces(){

        for(int i=0;i<8;i++){
            board[1][i].setPiece(new Pawn(Color.WHITE));
        }

        for(int i=0;i<8;i++){
            board[6][i].setPiece(new Pawn(Color.BLACK));
        }

        board[0][0].setPiece(new Rook(Color.WHITE));
        board[0][1].setPiece(new Bishop(Color.WHITE));
        board[0][2].setPiece(new Knight(Color.WHITE));
        board[0][3].setPiece(new Queen(Color.WHITE));
        board[0][4].setPiece(new King(Color.WHITE));
        board[0][5].setPiece(new Knight(Color.WHITE));
        board[0][6].setPiece(new Bishop(Color.WHITE));
        board[0][7].setPiece(new Rook(Color.WHITE));

        board[0][0].setPiece(new Rook(Color.BLACK));
        board[0][1].setPiece(new Bishop(Color.BLACK));
        board[0][2].setPiece(new Knight(Color.BLACK));
        board[0][3].setPiece(new Queen(Color.BLACK));
        board[0][4].setPiece(new King(Color.BLACK));
        board[0][5].setPiece(new Knight(Color.BLACK));
        board[0][6].setPiece(new Bishop(Color.BLACK));
        board[0][7].setPiece(new Rook(Color.BLACK));
    }

    public Cell getCell(int row, int col){
        return board[row][col];
    }

    public synchronized boolean move(Move move){
        Cell from = move.getStart();
        Cell to = move.getEnd();
        Piece fromPiece = from.getPiece();

        if(!fromPiece.canMove(this,from,to) || fromPiece==null)
            return false;

        to.setPiece(fromPiece);
        from.setPiece(null);
        return true;
    }

    public Piece getPiece(int row, int col){
        return board[row][col].getPiece();
    }

    public void setPiece(int row, int col, Piece piece){
        board[row][col].setPiece(piece);
    }

    public boolean isCheckMate(Color color){
        // logic
        return false;
    }

    public boolean isStaleMate(Color color){
        // logic
        return false;
    }
}
