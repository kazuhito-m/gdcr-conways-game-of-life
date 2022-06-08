package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import java.io.Serializable;

public class WorldCondition implements Serializable {
    public final int columnCount;
    public final int rowCount;

    public int[][] blankMatrix() {
        return new int[rowCount][columnCount];
    }

    public WorldCondition(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
    }
}
