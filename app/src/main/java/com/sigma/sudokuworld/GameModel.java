package com.sigma.sudokuworld;

class GameModel {

    static final int SUDOKU_ROOT_SIZE = 2;
    static final int SUDOKU_SIZE = SUDOKU_ROOT_SIZE * SUDOKU_ROOT_SIZE;
    private static final int SUDOKU_NUMBER_OF_CELLS = SUDOKU_SIZE * SUDOKU_SIZE;

    private int[] cellValues;
    private int numFilledCells = 0;
    private boolean isGameWon;

    static int cellNumToXPosition(int cellNumber) {
        return cellNumber % SUDOKU_SIZE;
    }

    static int cellNumToYPosition(int cellNumber) {
        return cellNumber / SUDOKU_SIZE;
    }

    GameModel(){
        cellValues = new int[SUDOKU_NUMBER_OF_CELLS];
        isGameWon = false;
    }

    void setValue(int x, int y, int number) {
         if (cellValues[(y * SUDOKU_SIZE) + x] == 0 && number != 0)
             numFilledCells++;
         else if (cellValues[(y * SUDOKU_SIZE) + x] != 0 && number == 0)
             numFilledCells--;

        cellValues[(y * SUDOKU_SIZE) + x] = number;
        isGameWon = checkWinConditions();
    }

    int getValue(int x, int y) {
        return cellValues[(y * SUDOKU_SIZE) + x];
    }

    int[] getFilledCells() {
        int[] filledCells = new int[numFilledCells];
        int i = 0;

        for (int j = 0; j < cellValues.length; j++) {
            if (cellValues[j] != 0)
                filledCells[i++] = j;
        }

        return filledCells;
    }

    private void sampleValues() {
        for (int i : cellValues) {
            cellValues[i] = i + 1;
        }
    }

    private boolean checkWinConditions() {
        if (numFilledCells != SUDOKU_NUMBER_OF_CELLS)
            return false;

        //Check win conditions for row, col, and square here

        return true;
    }

    public boolean isGameWon() {
        return isGameWon;
    }
}
