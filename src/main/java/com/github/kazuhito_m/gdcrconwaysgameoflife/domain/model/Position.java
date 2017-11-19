package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import java.util.HashSet;
import java.util.Set;

public class Position {

    final int row;
    final int column;

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }

    public Set<Position> neighborhoods() {
        Set<Position> positions = new HashSet<>();
        for (int nowRow = row - 1; nowRow <= row + 1; nowRow++) {
            for (int nowColumn = column - 1; nowColumn <= column + 1; nowColumn++) {
                Position nowPosition = new Position(nowRow, nowColumn);
                if (equals(nowPosition)) continue;
                positions.add(nowPosition);
            }
        }
        return positions;
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
