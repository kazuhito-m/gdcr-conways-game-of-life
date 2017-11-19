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
        if (dead()) return nextBirth(neighborhoodCount);
        return nextKeepAlive(neighborhoodCount);
    }

    private boolean nextBirth(int neighborhoodCount) {
        return neighborhoodCount == 3;
    }

    private boolean nextKeepAlive(int neighborhoodCount) {
        return neighborhoodCount == 2 || neighborhoodCount == 3;
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

}
