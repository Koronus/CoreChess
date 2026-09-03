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
public class King implements Piece {

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
    public String move() {
        return "";
    }



    private List<Cell> iteratingCells(int row, int col,ColorPiece colorPiece ,Board board){
        List<Cell> moveHint = new ArrayList<>();

        if (board.checkNextMove(row,col,colorPiece)){

            if(board.getPieceFromCell(row,col) != null){
                moveHint.add(board.getCell(row,col));
                return moveHint;
            }
            moveHint.add(board.getCell(row,col));


        }
        return moveHint;

    }

    @Override
    public List<Cell> analyzeHint(int row, int col, Board board) {
        int coefRow, coefCol;
        ColorPiece colorPiece = board.getPieceFromCell(row,col).getColor();
        List<Cell> moveHint = new ArrayList<>();

        int[][] arrDirectionMove = {{-1,0},{1,0},{0,1},{0,-1},{1,-1},{-1,1},{1,1},{-1,-1}} ;

        for(int[] arrDir : arrDirectionMove){
            coefRow = arrDir[0]; coefCol = arrDir[1];
            moveHint.addAll(iteratingCells(coefRow+row, coefCol+col,colorPiece,board));
        }




        return moveHint;
    }

    @Override
    public String toString() {
        return "King{" +
                "colorPiece=" + colorPiece +
                ", icon='" + icon + '\'' +
                '}';
    }
}
