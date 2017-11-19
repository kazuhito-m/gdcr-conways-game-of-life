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

    @Test
    public void 二世代目の世界で一つ以上のセルが生存している() {
        WorldCondition condition = new WorldCondition(100, 100);
        World sut = new World(condition);

        World worldOfNextGeneration = sut.next();

        int[][] matrix = worldOfNextGeneration.matrix();

        assertThat(aliveCount(matrix)).isGreaterThanOrEqualTo(1);
    }

    private int aliveCount(int[][] matrix) {
        return (int) Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .filter(alive -> alive == 1)
                .count();
    }

}
