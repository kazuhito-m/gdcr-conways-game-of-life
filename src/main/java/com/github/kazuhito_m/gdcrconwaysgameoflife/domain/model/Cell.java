package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

public class Cell {

    final boolean alive;

    public boolean alive() {
        return alive;
    }

    public Cell nextGeneration(int neighborhoodCount) {
        return this;
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

}
