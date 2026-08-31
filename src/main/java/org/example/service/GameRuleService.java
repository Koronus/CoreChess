package org.example.service;

import org.example.domain.Board;
import org.example.domain.Cell;
import org.example.domain.ColorPiece;
import org.example.domain.model.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GameRuleService {
    private  Logger log = Logger.getLogger(GameRuleService.class.getName());

    private Boolean matchIndex(int moveRow,int moveCol,List<Cell> moveHint){

        for(Cell cell : moveHint){
            int rowCell = cell.getRow();
            int colCell = cell.getCol();
            if(moveRow == rowCell && moveCol == colCell){
                return true;
            }
        }
        return false;


    }

    public void movingPiece(int row, int col,int moveRow,int moveCol, Board board){

        Piece piece = board.getPieceFromCell(row,col);

        List<Cell> moveHint = piece.analyzeHint(row, col, board);


        Boolean permissionMove =   matchIndex(moveRow,moveCol,moveHint);

        moveHint.stream().forEach(System.out::println);

        log.info("permissionMove = " + permissionMove);

        if(permissionMove){
            board.setPieceCell(row, col,moveRow,moveCol,piece);
        }



    }


    public void analyzeMove(int row, int col, Board board){

        Piece piece = board.getPieceFromCell(row,col);

        List<Cell> moveHint = piece.analyzeHint(row, col, board);

        moveHint.stream().forEach(System.out::println);



    }

}

