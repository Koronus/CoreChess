package org.example;

import org.example.domain.Board;
import org.example.domain.Cell;
import org.example.service.GameRuleService;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        GameRuleService gameRule = new GameRuleService();

          board.printBoard();
        //board.printBoardReverse();

        gameRule.analyzeMove(4,4,board);
    }
}