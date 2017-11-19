package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

public class Cell {

    final boolean alive;

    public boolean alive() {
        return alive;
    }

    public boolean dead() {
        return !alive();
    }

    public Cell nextGeneration(int neighborhoodCount) {
        return new Cell(nextAlive(neighborhoodCount));
    }

    private boolean nextAlive(int neighborhoodCount) {
        return nextBirth(neighborhoodCount);
    }

    private boolean nextBirth(int neighborhoodCount) {
        if (dead()) return neighborhoodCount == 3;
        return true;
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

}
