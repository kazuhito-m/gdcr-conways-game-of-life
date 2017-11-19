package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WorldTest {

    @Test
    public void 初期配置で世界はランダムに生死のセルが埋まっておりほぼ同数である() {
        WorldCondition condition = new WorldCondition(100, 100);
        World sut = new World(condition);

        int[][] matrix = sut.matrix();

        assertThat(aliveCount(matrix)).isBetween(4000, 6000);
    }

    private int aliveCount(int[][] matrix) {
        return (int) Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .filter(alive -> alive == 1)
                .count();
    }

}
