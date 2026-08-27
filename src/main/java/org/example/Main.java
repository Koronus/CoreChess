package org.example;

import org.example.domain.Board;
import org.example.service.GameRuleService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        GameRuleService gameRule = new GameRuleService();

        board.printBoard();
        gameRule.analyzeMove(6,3,board);
    }
}