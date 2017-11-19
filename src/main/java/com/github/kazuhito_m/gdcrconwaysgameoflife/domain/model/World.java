package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class World {

    final WorldCondition condition;
    final Map<Position, Cell> cells;

    public int[][] matrix() {
        int[][] result = condition.blankMatrix();
        cells.keySet().stream()
                .forEach(position -> setAlive(result, position));
        return result;
    }

    private void setAlive(int[][] matrix, Position position) {
        Cell cell = cells.get(position);
        int aliveValue = cell.alive() ? 1 : 0;
        matrix[position.row()][position.column()] = aliveValue;
    }

    public World nextGeneration() {
        Map<Position, Cell> nextGenerationCells = cells.keySet().stream()
                .collect(toMap(
                        position -> position,
                        position -> nextGenerationCell(position)
                ));
        return new World(condition, nextGenerationCells);
    }

    private Cell nextGenerationCell(Position position) {
        int neighborhoodCount = countNeighborhood(position);
        Cell currentCell = cells.get(position);
        return currentCell.nextGeneration(neighborhoodCount);
    }

    private int countNeighborhood(Position position) {
        int count = 0;
        int currentRow = position.row();
        int currentColumn = position.column();
        for (int row = currentRow - 1; row < currentRow + 1; row++) {
            for (int column = currentColumn - 1; column < currentColumn + 1; column++) {
                Position nowPosition = new Position(row, column);
                if (position.equals(nowPosition)) continue;
                if (cells.containsKey(nowPosition) && cells.get(nowPosition).alive()) count++;
            }
        }
        return count;
    }

    private static Map<Position, Cell> initialCells(WorldCondition condition) {
        Map<Position, Cell> cells = new HashMap<>();
        for (int row = 0; row < condition.rowCount(); row++) {
            for (int column = 0; column < condition.columnCount(); column++) {
                cells.put(new Position(row, column), Cell.randomInitialize());
            }
        }
        return Collections.unmodifiableMap(cells);
    }

    World(WorldCondition condition, Map<Position, Cell> cells) {
        this.condition = condition;
        this.cells = cells;
    }

    public World(WorldCondition condition) {
        this(condition, initialCells(condition));
    }


}
