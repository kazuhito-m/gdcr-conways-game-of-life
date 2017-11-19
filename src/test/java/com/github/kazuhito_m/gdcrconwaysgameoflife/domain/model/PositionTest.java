package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import org.junit.Test;

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
}
