package org.systemDesign.chessGame;

import org.systemDesign.chessGame.pieces.Piece;

import java.util.Scanner;

public class ChessGame {
    private final Board board;
    private Player whitePlayer,blackPlayer;
    private Player currentPlayer;

    public ChessGame(){
        board = new Board();
    }

    public void setPlayers(String whiteName, String blackName){
        this.whitePlayer = new Player(whiteName, Color.WHITE);
        this.blackPlayer = new Player(blackName, Color.BLACK);
        this.currentPlayer = whitePlayer;
    }

    public void play(){
        while(!isGameOver()){
            Player player = currentPlayer;
            System.out.println("Current Player: "+player.getName());

            Move move = getPlayerMove(player);

            try{
                board.move(move);
            }catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                System.out.println("Try again");
                continue;
            }
            switchTurn();
        }
        getResult();
    }

    public boolean isGameOver(){
        return board.isCheckMate(Color.WHITE) || board.isCheckMate(Color.BLACK) || board.isStaleMate(Color.WHITE)|| board.isStaleMate(Color.BLACK);
    }

    public Move getPlayerMove(Player player){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();


        Piece sourcePiece = board.getPiece(sourceRow,sourceCol);
        if(sourcePiece==null || sourcePiece.getColor()!=player.getPlayerColor())
            throw  new InvalidMoveException("Invalid");

        return new Move(board.getCell(sourceRow,sourceCol), board.getCell(destRow,destCol));

    }

    private void switchTurn(){
        currentPlayer= currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
    }

    public void getResult(){
        if(board.isCheckMate(Color.WHITE))
            System.out.println("Black wins");
        else if(board.isCheckMate(Color.BLACK))
            System.out.println("White wins");
        else if(board.isStaleMate(Color.WHITE) || board.isStaleMate(Color.BLACK))
            System.out.println("Game ends in stale mate");
    }
}
