package io.codeforall.bootcamp;

import io.codeforall.bootcamp.Grid.GridFactory;
import io.codeforall.bootcamp.Pointer.Pointer;

public class Main {
    public static void main(String[] args){
        GridFactory grid = new GridFactory(11,11);
        Pointer pointer = new Pointer(grid);
        grid.init();
        pointer.createPointer();
    }
}
