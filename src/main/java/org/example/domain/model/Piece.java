package org.example.domain.model;

import org.example.domain.Board;
import org.example.domain.Cell;
import org.example.domain.ColorPiece;

import java.util.List;

public interface Piece {


    String getName();
    String move();
    String getIcon();
    List<Cell> analyzeHint(int row, int col, Board board);
    void setColor(ColorPiece colorPiece);
    ColorPiece getColor();
}
