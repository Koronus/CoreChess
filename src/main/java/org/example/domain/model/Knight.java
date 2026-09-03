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
public class Knight implements Piece {

    private ColorPiece colorPiece;
    private String icon;
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
    public String toString() {
        return "Knight{" +
                "colorPiece=" + colorPiece +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    public String move() {
        return "";
    }


    @Override
    public List<Cell> analyzeHint(int row, int col, Board board) {
        int coefRow, coefCol;
        ColorPiece colorPiece = board.getPieceFromCell(row,col).getColor();
        List<Cell> moveHint = new ArrayList<>();

        int[][] arrDirectionMove = {{1,-2},{1,2},{2,-1},{2,1},{-1,-2},{-1,2},{-2,-1},{-2,1}} ;

        for(int[] arrDir : arrDirectionMove){
            coefRow = arrDir[0]; coefCol = arrDir[1];

            if(board.checkNextMove(row+coefRow,col+coefCol,colorPiece)){
                moveHint.add(board.getCell(row+coefRow,col+coefCol));
            }
        }




        return moveHint;
    }

}
