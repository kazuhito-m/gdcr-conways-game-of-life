package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import java.io.Serializable;

public class WorldCondition implements Serializable {

    public int columnCount;
    public int rowCount;

    int columnCount() {
        return columnCount;
    }

    int rowCount() {
        return rowCount;
    }

    public WorldCondition() {
    }

    public WorldCondition(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
    }

}
