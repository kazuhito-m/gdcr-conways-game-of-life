package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {
    @Test
    public void 死んでいるセルに隣接する生きたセルがちょうど3つあれば次の世代が誕生する() {
        Cell sut = new Cell(false);
        Cell actual = sut.nextGeneration(3);
        assertThat(actual.alive()).isTrue();
    }

    @Test
    public void 死んでいるセルに隣接する生きたセルが2つなら次の世代が誕生しない() {
        Cell sut = new Cell(false);
        Cell actual = sut.nextGeneration(2);
        assertThat(actual.alive()).isFalse();
    }

    @Test
    public void 死んでいるセルに隣接する生きたセルが4つなら次の世代が誕生しない() {
        Cell sut = new Cell(false);
        Cell actual = sut.nextGeneration(4);
        assertThat(actual.alive()).isFalse();
    }

    @Test
    public void 生きているセルに隣接する生きたセルが1つならば次の世代で死滅する() {
        Cell sut = new Cell(true);
        Cell actual = sut.nextGeneration(1);
        assertThat(actual.alive()).isFalse();
    }

    @Test
    public void 生きているセルに隣接する生きたセルが2つならば次の世代でも生存する() {
        Cell sut = new Cell(true);
        Cell actual = sut.nextGeneration(2);
        assertThat(actual.alive()).isTrue();
    }

    @Test
    public void 生きているセルに隣接する生きたセルが3つならば次の世代でも生存する() {
        Cell sut = new Cell(true);
        Cell actual = sut.nextGeneration(3);
        assertThat(actual.alive()).isTrue();
    }

    @Test
    public void 生きているセルに隣接する生きたセルが4つならば次の世代で死滅する() {
        Cell sut = new Cell(true);
        Cell actual = sut.nextGeneration(4);
        assertThat(actual.alive()).isFalse();
    }

    @Test
    public void 生死状態をランダムにしたセルを生成することができる() {
        int actual = (int) IntStream.rangeClosed(0, 10000)
                .mapToObj(i -> Cell.randomInitialize())
                .filter(cell -> cell.alive())
                .count();
        assertThat(actual).isBetween(4000, 6000);
    }
}
