package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

import java.util.Random;

public class World {

    final int[][] matrix;

    public int[][] matrix() {
        return matrix;
    }

    public World next() {
        // 仮実装
        return new World(new WorldCondition(matrix[0].length, matrix.length));
    }

    private static int[][] initialMatrix(WorldCondition condition) {
        // 仮実装。1/2で生存になるのは良い物か…。
        final int columnCount = condition.columnCount();
        final int rowCount = condition.rowCount();
        Random random = new Random();
        int[][] matrix = new int[rowCount][columnCount];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(2);
            }
        }
        return matrix;
    }

    World(int[][] matrix) {
        this.matrix = matrix;
    }

    public World(WorldCondition condition) {
        this(initialMatrix(condition));
    }

}
