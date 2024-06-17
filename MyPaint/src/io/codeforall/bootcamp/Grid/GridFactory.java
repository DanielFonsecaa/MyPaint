package io.codeforall.bootcamp.Grid;


import io.codeforall.bootcamp.Cell;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;

public class GridFactory {

    public static final int PADDING = 10;
    private Rectangle cell;
    public static int sizeCell = 20;
    private int cols;
    private int rows;
    private Rectangle grid;
    private Cell[][] cells;

    //Constructor
    public GridFactory(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        cells = new Cell[cols][rows];
    }

    //Methods
    public void init() {
        grid = new Rectangle(PADDING, PADDING, cols * sizeCell, rows * sizeCell);
        grid.draw();
        makeCells();
    }

    public void makeCells() {
        for (int y = 0; y < cols; y++) {
            for (int x = 0; x < rows; x++) {
                cells[x][y] = new Cell(columnToX(x), rowToY(y));
            }
        }
    }

    public int getSizeCell() {
        return sizeCell;
    }

    public int getPadding() {
        return PADDING;
    }

    public int getWidth() {
        return grid.getWidth();
    }

    public int getHeight() {
        return grid.getHeight();
    }

    public int getY() {
        return grid.getY();
    }

    public int getX() {
        return grid.getX();
    }

    public int rowToY(int row) {
        return PADDING + sizeCell * row;
    }

    public int columnToX(int col) {
        return PADDING + sizeCell * col;
    }

    public Cell getCell(int c, int r) {
        return cells[c][r];
    }

    public void paintCell(int c, int r) {
        getCell(c, r).paintCell();
    }

    public void unPaintCell(int c, int r) {
        getCell(c, r).unPaintCell();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    BufferedWriter bWriter;

    public void write(String string){
        try{
            bWriter = new BufferedWriter(new FileWriter("src/io/codeforall/bootcamp/Saved"));
            bWriter.write(string);
            bWriter.close();
        }catch (IOException e){
            System.out.println("Something bad happend");
        }
    }
    public void writeFile() {
        String line;
        String result = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                line = getCell(j, i).toString();
                System.out.println(line);
                result += line;
            }
            result += "\n";
        }
        try {
            FileWriter writer = new FileWriter("src/io/codeforall/bootcamp/Saved");
            bWriter = new BufferedWriter(writer);

            bWriter.write(result);
            bWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stringToGrid(String grid) {
        int index = 0;

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                Cell cell = cells[row][col];

                if (grid.charAt(index) == '0') {
                    cell.unPaintCell();

                }else {
                    cell.paintCell();
                }
                index++;
            }
            index++;
        }

    }

    public String loadFile() {

        String line = "";
        String result = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/io/codeforall/bootcamp/Saved"));
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(result);
        return result;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                stringBuilder.append(cells[row][col]);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();

    }
}
