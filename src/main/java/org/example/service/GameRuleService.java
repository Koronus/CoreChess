package org.example.service;

import org.example.domain.Board;
import org.example.domain.Cell;
import org.example.domain.ColorPiece;
import org.example.domain.model.King;
import org.example.domain.model.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GameRuleService {
    private final Logger log = Logger.getLogger(GameRuleService.class.getName());

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

        moveHint.forEach(System.out::println);

        log.info("permissionMove = " + permissionMove);

        if(permissionMove){
            board.setPieceCell(row, col,moveRow,moveCol,piece);
        }



    }

    private List<Cell> checkMatchCells(List<Cell> moveHint,List<Cell> attackMoves){

        for (Cell attackCell : attackMoves){
            for (Cell hintCell : moveHint){
                if(attackCell.getRow() == hintCell.getRow() && attackCell.getCol() == hintCell.getCol()){

                }

            }
        }
        return null;
    }

    private List<Cell> attackMovePieces(ColorPiece colorPiece, Board board){

        int lengthArr = board.getFields().length;
        List<Cell> attackMove = new ArrayList<>();
        for(int row = 0; row < lengthArr;row++){
            for(int col = 0; col < lengthArr;col++){

                Piece piece = board.getPieceFromCell(row, col);

                if(piece!=null){
                    if(!piece.getColor().equals(colorPiece)){
                        attackMove.addAll(piece.analyzeHint(row,col,board));
                    }
                }


            }
        }
        return attackMove;
    }


    public void analyzeMove(int row, int col, Board board){
        King king = new King();
        Piece piece = board.getPieceFromCell(row,col);

        List<Cell> moveHint = piece.analyzeHint(row, col, board);
        if(king.getClass() == piece.getClass()){
            List<Cell> attackMoves = attackMovePieces(piece.getColor(),board);
           // moveHint.addAll(checkMatchCells(moveHint,attackMoves));
            attackMoves.forEach(System.out::println);


        }




        //moveHint.forEach(System.out::println);



    }

}

