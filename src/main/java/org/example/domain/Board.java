package org.example.domain;


import lombok.Getter;
import lombok.Setter;
import org.example.domain.model.*;

import java.util.logging.Logger;

import static org.example.domain.ColorPiece.BLACK;
import static org.example.domain.ColorPiece.WHITE;

@Setter
@Getter

public class Board {
    private static Logger log = Logger.getLogger(Board.class.getName());
    private Cell[][] fields = new Cell[8][8];
    private Piece[] pieceArrBlack = new Piece[8];
    private Piece[] pieceArrWhite = new Piece[8];


    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                fields[row][col] = new Cell(row,col);
            }
        }
        pieceArrBlack[0] = new Rook(BLACK,"\u265C");
        pieceArrBlack[1] = new Knight(BLACK,"\u265E");
        pieceArrBlack[2] = new Bishop(BLACK,"\u265D");
        pieceArrBlack[3] = new King(BLACK,"\u265A");
        pieceArrBlack[4] = new Queen(BLACK,"\u265B");
        pieceArrBlack[5] = new Bishop(BLACK,"\u265D");
        pieceArrBlack[6] = new Knight(BLACK,"\u265E");
        pieceArrBlack[7] = new Rook(BLACK,"\u265C");

        pieceArrWhite[0] = new Rook(WHITE,"\u2656");
        pieceArrWhite[1] = new Knight(WHITE,"\u2658");
        pieceArrWhite[2] = new Bishop(WHITE,"\u2657");
        pieceArrWhite[3] = new King(WHITE,"\u2654");
        pieceArrWhite[4] = new Queen(WHITE,"\u2655");
        pieceArrWhite[5] = new Bishop(WHITE,"\u2657");
        pieceArrWhite[6] = new Knight(WHITE,"\u2658");
        pieceArrWhite[7] = new Rook(WHITE,"\u2656");


        for(int col = 0;col < 8; col++){
            fields[6][col].setPieceCell(new Pawn(BLACK,"\u265F"));
            fields[1][col].setPieceCell(new Pawn(WHITE,"\u2659"));

            fields[7][col].setPieceCell(pieceArrBlack[col]);
            fields[0][col].setPieceCell(pieceArrWhite[col]);
        }
        //fields[4][4].setPieceCell(new Rook(BLACK,"\u265C"));
        fields[4][4].setPieceCell(new Bishop(BLACK,"\u265D"));
        //fields[5][6].setPieceCell(new Pawn(WHITE,"\u265F"));
//        log.info(""+fields[5][3].getPieceCell());
        //fields[5][5].setPieceCell(new Rook(BLACK,"\u265C"));

        log.info(""+fields[5][5].getPieceCell());

    }

    public Piece getPieceFromCell(int row, int col){
            return fields[row][col].getPieceCell();
    }

    public Cell getCell(int row, int col){
        return fields[row][col];
    }

    public Boolean checkNextMove(int row, int col, ColorPiece colorPiece){

        if(row < 0 || row > 7 || col < 0 || col > 7){
            return false;
        }
        if(getPieceFromCell(row,col) != null){
            Piece exploringPiece = getPieceFromCell(row,col);
            boolean mathColor = colorPiece.equals(exploringPiece.getColor());
            if(mathColor){
                return false;
            }

        }
        return true;
    }

    public void printBoardReverse() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                    if(fields[i][j].getPieceCell() != null){
                        System.out.print(fields[i][j].getPieceCell().getIcon()+" ");
                    }
                    else{
                        System.out.print("  ");
                    }

                   //log.info(fields[i][j]+"");


            }
            System.out.println();

        }
    }

    public void printBoard() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 7; j >= 0; j--) {
                if(fields[i][j].getPieceCell() != null){
                    System.out.print(fields[i][j].getPieceCell().getIcon()+" ");
                }
                else{
                    System.out.print("  ");
                }

                //log.info(fields[i][j]+"");


            }
            System.out.println();

        }
    }
}