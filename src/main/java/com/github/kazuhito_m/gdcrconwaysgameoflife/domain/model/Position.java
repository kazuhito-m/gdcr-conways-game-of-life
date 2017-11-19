package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

public class Position {

    final int row;
    final int column;

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Position)) return false;
        return other.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return row * 100000 + column;
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

}
