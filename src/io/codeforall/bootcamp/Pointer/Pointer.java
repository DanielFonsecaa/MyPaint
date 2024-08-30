package io.codeforall.bootcamp.Pointer;

import io.codeforall.bootcamp.Grid.*;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.*;

public class Pointer implements KeyboardHandler {
    private Rectangle pointer;
    private GridFactory grid;
    Keyboard keyboard;

    public Pointer(GridFactory grid) {
        this.grid = grid;
        keyboard = new Keyboard(this);
    }

    public void createPointer() {
        pointer = new Rectangle(grid.getPadding(), grid.getPadding(), grid.getSizeCell(), grid.getSizeCell());
        pointer.setColor(Color.MAGENTA);
        pointer.fill();
        addKeyboard();
    }

    public int getCol() {
        return pointer.getX() / grid.getSizeCell();
    }

    public int getRows() {
        return pointer.getY() / grid.getSizeCell();
    }

    private void addKeyboard() {
        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);

        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);
        //
        //
        //
        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_SPACE);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paint);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(clear);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(load);
    }

    public void moveLeft() {
        pointer.translate(-grid.getSizeCell(), 0);
    }

    public void moveRight() {
        pointer.translate(grid.getSizeCell(), 0);
    }

    public void moveUp() {
        pointer.translate(0, -grid.getSizeCell());
    }

    public void moveDown() {
        pointer.translate(0, grid.getSizeCell());
    }

    //
    //
    //
    public void paint() {
        if (grid.getCell(getCol(), getRows()).isPainted()) {
            grid.unPaintCell(getCol(), getRows());
            System.out.println("unpaint");
            return;
        }
        grid.paintCell(getCol(), getRows());
        System.out.println("paint");
    }

    public void clear() {
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                grid.unPaintCell(j, i);
            }

        }
        System.out.println("clear everything");
    }

    public void save() {
        //grid.write(grid.toString());
        grid.writeFile();
        System.out.println("save");
    }

    public void load() {
        grid.stringToGrid(grid.loadFile());
        System.out.println("load");
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int keyPressed = keyboardEvent.getKey();
        if (keyPressed == KeyboardEvent.KEY_RIGHT) {
            if (pointer.getX() < grid.getWidth() - grid.getSizeCell()) {
                moveRight();
            }

        }
        if (keyPressed == KeyboardEvent.KEY_LEFT) {
            if (pointer.getX() > grid.getX()) {
                moveLeft();
            }

        }
        if (keyPressed == KeyboardEvent.KEY_DOWN) {
            if (pointer.getY() < grid.getHeight() - grid.getSizeCell()) {
                moveDown();
            }

        }
        if (keyPressed == KeyboardEvent.KEY_UP) {
            if (pointer.getY() > grid.getY()) {
                moveUp();
            }

        }
        if (keyPressed == KeyboardEvent.KEY_SPACE) {
            paint();
        }
        if (keyPressed == KeyboardEvent.KEY_C) {
            // if () {
            clear();
            // }
        }
        if (keyPressed == KeyboardEvent.KEY_S) {
            // if () {
            save();
            // }
        }
        if (keyPressed == KeyboardEvent.KEY_L) {
            // if () {
            load();
            // }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
