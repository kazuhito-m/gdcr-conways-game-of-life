package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {

    @Test
    public void 死んでいるセルに隣接する生きたセルがちょうど3つあれば次の世代が誕生する() {
        Cell sut = new Cell(false);
        Cell actual = sut.nextGeneration(3);
        assertThat(actual.alive()).isTrue();
    }

}
