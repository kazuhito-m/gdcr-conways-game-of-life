import java.util.Random;

public class LifeGame {

    public enum DeadOrAlive {
        DEAD, ALIVE;
    }


    public static void main(String[] args) {
        // 舞台の用意
        int butai[][] = new int[16][16];
        // 初期化、ランダム配置
        Random rand = new Random();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                butai[i][j] = rand.nextInt(2);
            }
        }


    }

    public static DeadOrAlive born(DeadOrAlive[][] butai, int x, int y) {

        DeadOrAlive target = butai[x][y];

        if (target == DeadOrAlive.ALIVE) return DeadOrAlive.ALIVE;

        int cnt = 0;
        for (int i = -1 ; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                DeadOrAlive mawari = butai[x + i][x + j];
                if (mawari)
            }
        }

        DeadOrAlive mawari = butai[x - 1][y - 1];
        mawari = butai[x - 1][y - 1];
        mawari = butai[x - 1][y - 1];
        mawari = butai[x - 1][y - 1];
        mawari = butai[x - 1][y - 1];
        mawari = butai[x - 1][y - 1];
        mawari = butai[x - 1][y - 1];
        mawari = butai[x - 1][y - 1];

        return DeadOrAlive.ALIVE;
    }
}
