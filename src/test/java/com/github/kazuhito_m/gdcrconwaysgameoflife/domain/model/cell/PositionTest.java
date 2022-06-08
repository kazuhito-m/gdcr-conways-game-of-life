package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell;

import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.cell.Position;
import org.junit.jupiter.api.Test;


import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void 同一の座標か否かを判断できる() {
        Position sut = new Position(2, 4);

        assertThat(sut).isNotEqualTo(new Position(2, 3));
        assertThat(sut).isEqualTo(new Position(2, 4));
        assertThat(sut).isNotEqualTo(new Position(2, 5));

        assertThat(sut).isNotEqualTo(new Position(1, 4));
        assertThat(sut).isEqualTo(new Position(2, 4));
        assertThat(sut).isNotEqualTo(new Position(3, 4));
    }

    @Test
    public void 同一か否かの判定で型違いはハネることができる() {
        Position sut = new Position(2, 4);
        assertThat(sut).isNotEqualTo(new Object());
        assertThat(sut).isNotEqualTo(null);
    }

    @Test
    public void ある座標から近隣の座標群を取得することができる() {
        Position sut = new Position(1, 1);

        Set<Position> actual = sut.neighborhoods();

        assertThat(actual).hasSize(8);
        assertThat(actual).contains(
                new Position(0, 0),
                new Position(0, 1),
                new Position(0, 2),
                new Position(1, 0),
                new Position(1, 2),
                new Position(2, 0),
                new Position(2, 1),
                new Position(2, 2)
        );
    }

}
