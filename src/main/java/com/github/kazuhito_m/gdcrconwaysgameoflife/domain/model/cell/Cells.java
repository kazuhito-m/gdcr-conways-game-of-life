package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell;

import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.WorldCondition;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class Cells {
    private final Map<Position, Cell> cells;

    public Cell of(Position position) {
        if (!cells.containsKey(position)) return new Cell(false);
        return cells.get(position);
    }

    public Set<Position> positions() {
        return cells.keySet();
    }

    public Cells nextGeneration() {
        Map<Position, Cell> nextGenerations = positions().stream()
                .collect(toMap(
                        position -> position,
                        position -> nextGenerationCell(position)
                ));
        return new Cells(nextGenerations);
    }

    private Cell nextGenerationCell(Position position) {
        int neighborhoodCount = countNeighborhood(position);
        Cell currentCell = cells.get(position);
        return currentCell.nextGeneration(neighborhoodCount);
    }

    int countNeighborhood(Position position) {
        return (int) position.neighborhoods().stream()
                .filter(neighborhood -> of(neighborhood).alive())
                .count();
    }

    public static Cells initialize(WorldCondition condition) {
        Map<Position, Cell> newCells = new HashMap<>();
        for (int row = 0; row < condition.rowCount; row++) {
            for (int column = 0; column < condition.columnCount; column++) {
                newCells.put(new Position(row, column), Cell.randomInitialize());
            }
        }
        return new Cells(Collections.unmodifiableMap(newCells));
    }

    public Cells(Map<Position, Cell> cells) {
        this.cells = cells;
    }
}
