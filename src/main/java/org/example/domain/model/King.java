package org.example.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.Board;
import org.example.domain.Cell;
import org.example.domain.ColorPiece;

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
    public String move() {
        return "";
    }

    @Override
    public List<Cell> analyzeHint(int col, int row, Board board) {
        return List.of();
    }

    @Override
    public String toString() {
        return "King{" +
                "colorPiece=" + colorPiece +
                ", icon='" + icon + '\'' +
                '}';
    }
}
