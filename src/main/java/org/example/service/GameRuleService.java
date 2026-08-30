package org.example.service;

import org.example.domain.Board;
import org.example.domain.Cell;
import org.example.domain.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class GameRuleService {

    public void movingPiece(int row, int col,int moveRow,int moveCol, List<Cell> moveHint){

    }


    public void analyzeMove(int row, int col, Board board){

        Piece piece = board.getPieceFromCell(row,col);

        List<Cell> moveHint = piece.analyzeHint(row, col, board);

        moveHint.stream().forEach(System.out::println);



    }

}

