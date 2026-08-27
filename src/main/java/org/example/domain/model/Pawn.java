package org.example.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.Board;
import org.example.domain.Cell;
import org.example.domain.ColorPiece;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Pawn implements Piece {

    private ColorPiece colorPiece;
    private String icon;
    @Override
    public String getName() {
        return "";
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "colorPiece=" + colorPiece +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    public void setColor(ColorPiece colorPiece){
        this.colorPiece = colorPiece;
    }

    @Override
    public String move() {
        return "";
    }

    @Override
    public List<Cell> analyzeHint(int col, int row, Board board) {
        Cell[][] cellArr = board.getFields();
        List<Cell> moveHint = new ArrayList<>();
        if(cellArr[col-1][row].getPieceCell() == null){
            moveHint.add(new Cell(col-1,row));
        }
        if(cellArr[col-1][row-1].getPieceCell() == null){
            moveHint.add(new Cell(col-1,row-1));
        }
        if(cellArr[col-1][row+1].getPieceCell() == null){
            moveHint.add(new Cell(col-1,row+1));
        }
        return moveHint;
    }

}
