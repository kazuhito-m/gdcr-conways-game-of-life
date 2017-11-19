package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import java.io.Serializable;

public class WorldCondition implements Serializable {

    public int columnCount;
    public int rowCount;

    public int columnCount() {
        return columnCount;
    }

    public int rowCount() {
        return rowCount;
    }

    public int[][] blankMatrix() {
        return new int[rowCount][columnCount];
    }

    public WorldCondition() {
    }

    public WorldCondition(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
    }

}
