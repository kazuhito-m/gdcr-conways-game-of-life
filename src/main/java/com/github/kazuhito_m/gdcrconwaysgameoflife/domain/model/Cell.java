package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

public class Cell {

    final boolean alive;

    public boolean alive() {
        return alive;
    }

    public Cell nextGeneration(int neighborhoodCount) {
        return new Cell(nextAlive(neighborhoodCount));
    }

    private boolean nextAlive(int neighborhoodCount) {
        return alive() && neighborhoodCount == 2 || neighborhoodCount == 3;
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

}
