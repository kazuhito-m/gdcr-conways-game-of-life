package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell;

import java.util.Random;

public class Cell {

    final boolean alive;

    public boolean alive() {
        return alive;
    }

    public Cell nextGeneration(int neighborhoodCount) {
        return new Cell(nextAlive(neighborhoodCount));
    }

    private static final Random generator = new Random();

    public static Cell randomInitialize() {
        return new Cell(generator.nextBoolean());
    }

    private boolean nextAlive(int neighborhoodCount) {
        return alive() && neighborhoodCount == 2 || neighborhoodCount == 3;
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

}
