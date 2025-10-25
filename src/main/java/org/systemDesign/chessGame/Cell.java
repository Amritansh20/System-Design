package org.systemDesign.chessGame;

import com.sun.nio.sctp.AssociationChangeNotification;
import lombok.Getter;
import lombok.Setter;
import org.systemDesign.chessGame.pieces.Piece;

@Getter
@Setter
public class Cell {
    int row, col;
    Piece piece;

    Cell(int row, int col){
        this.row=row;
        this.col=col;
    }

    public boolean isOccupied(){
       return piece!=null;
    }

}
