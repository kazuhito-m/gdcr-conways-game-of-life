package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CellsTest {
    @Test
    public void セルが9x9の際に真ん中のセルから囲まれてる隣接数が取得できる() {
        Map<Position, Cell> cells = new HashMap<>();
        cells.put(new Position(0, 0), new Cell(true));
        cells.put(new Position(0, 1), new Cell(true));
        cells.put(new Position(0, 2), new Cell(false));

        cells.put(new Position(1, 0), new Cell(false));
        cells.put(new Position(1, 1), new Cell(false));
        cells.put(new Position(1, 2), new Cell(true));

        cells.put(new Position(2, 0), new Cell(false));
        cells.put(new Position(2, 1), new Cell(true));
        cells.put(new Position(2, 2), new Cell(true));
        Cells sut = new Cells(cells);

        int actual = sut.countNeighborhood(new Position(1, 1));

        assertThat(actual).isEqualTo(5);
    }
}
