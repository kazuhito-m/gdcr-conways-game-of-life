package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell.Cell;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell.Cells;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell.Position;

public class World {
    private final WorldCondition condition;
    private final Cells cells;

    public int[][] matrix() {
        int[][] result = condition.blankMatrix();
        cells.positions().stream()
                .forEach(position -> setAlive(result, position));
        return result;
    }

    private void setAlive(int[][] matrix, Position position) {
        Cell cell = cells.of(position);
        int aliveValue = cell.alive() ? 1 : 0;
        matrix[position.row()][position.column()] = aliveValue;
    }

    public World nextGeneration() {
        return new World(condition, cells.nextGeneration());
    }

    World(WorldCondition condition, Cells cells) {
        this.condition = condition;
        this.cells = cells;
    }

    public World(WorldCondition condition) {
        this(condition, Cells.initialize(condition));
    }
}
