package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.model.Piece;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cell {


    private int col,row;
    private Piece pieceCell;



    public Cell(int col, int row) {
        this.col = col;
        this.row = row;
    }


    @Override
    public String toString() {
        return "Cell{" +
                "col=" + col +
                ", row=" + row +
                ", pieceCell=" + pieceCell +
                '}';
    }
}
