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


    private int row,col;
    private Piece pieceCell;



    public Cell(int  row, int col) {
        this.row = row;
        this.col = col;

    }


    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", col=" + col +
                ", pieceCell=" + pieceCell +
                '}';
    }
}
