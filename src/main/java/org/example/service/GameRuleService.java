package org.example.service;

import org.example.domain.Board;
import org.example.domain.Cell;
import org.example.domain.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class GameRuleService {



    public void analyzeMove(int col, int row, Board board){

        Piece piece = board.getFields()[col][row].getPieceCell();

        List<Cell> moveHint = piece.analyzeHint(col, row, board);

        moveHint.stream().forEach(System.out::println);



    }

}

