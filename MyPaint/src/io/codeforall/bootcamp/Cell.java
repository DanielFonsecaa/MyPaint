package io.codeforall.bootcamp;

import io.codeforall.bootcamp.Grid.GridFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private boolean isPainted;
    private Rectangle cell;
    private int col;
    private int row;
    public Cell(int col, int row){
        this.col = col;
        this.row = row;
        isPainted = false;
        cell = new Rectangle(col,row, GridFactory.sizeCell,GridFactory.sizeCell);
        cell.draw();
    }
    public void paintCell(){
        cell.setColor(Color.BLACK);
        cell.fill();
        isPainted = true;
    }
    public void unPaintCell(){
        cell.draw();
        isPainted = false;
    }
    public boolean isPainted(){
        return isPainted;
    }

    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    @Override
    public String toString(){
        return isPainted? "1": "0";
    }

}
