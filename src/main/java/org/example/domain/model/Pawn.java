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
    private boolean startPos = true;

    public Pawn(ColorPiece colorPiece, String icon) {
        this.colorPiece = colorPiece;
        this.icon = icon;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setColor(ColorPiece colorPiece){
        this.colorPiece = colorPiece;
    }

    @Override
    public ColorPiece getColor() {
        return colorPiece;
    }

    @Override
    public String move() {
        return "";
    }



    @Override
    public List<Cell> analyzeHint(int row, int col, Board board) {

        ColorPiece colorPiece = board.getPieceFromCell(row,col).getColor();
        int direction = colorPiece.equals(ColorPiece.WHITE) ? 1 : -1;
        List<Cell> moveHint = new ArrayList<>();
        int nextRow = row + direction;

        if(board.checkNextMove(nextRow, col, colorPiece) ){
            if(board.getPieceFromCell(nextRow, col)==null){
                moveHint.add(board.getCell(nextRow,col));
                if(board.getPieceFromCell(nextRow+direction, col)==null && startPos){
                    moveHint.add(board.getCell(nextRow+direction,col));
                }
            }

        }

        if(board.checkNextMove(nextRow, col-1, colorPiece)){
            if(board.getPieceFromCell(nextRow, col-1) !=null){
                moveHint.add(board.getCell(nextRow,col-1));
            }

        }
        if(board.checkNextMove(nextRow, col+1, colorPiece)){
            if(board.getPieceFromCell(nextRow, col+1) !=null){
                moveHint.add(board.getCell(nextRow,col+1));
            }
        }
        return moveHint;
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "colorPiece=" + colorPiece +
                ", icon='" + icon + '\'' +
                '}';
    }

}
