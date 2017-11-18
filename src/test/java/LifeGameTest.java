import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LifeGameTest {

    @Test
    public void ランチャー() {
        LifeGame.main(new String[0]);
    }

    @Test
    public void test誕生() {

        LifeGame.DeadOrAlive[][] butai = new LifeGame.DeadOrAlive[3][3];

        butai[0][0] = LifeGame.DeadOrAlive.ALIVE;
        butai[0][1] = LifeGame.DeadOrAlive.ALIVE;
        butai[0][2] = LifeGame.DeadOrAlive.DEAD;
        butai[1][0] = LifeGame.DeadOrAlive.ALIVE;
        butai[1][1] = LifeGame.DeadOrAlive.DEAD;
        butai[1][2] = LifeGame.DeadOrAlive.DEAD;
        butai[2][0] = LifeGame.DeadOrAlive.DEAD;
        butai[2][1] = LifeGame.DeadOrAlive.DEAD;
        butai[2][2] = LifeGame.DeadOrAlive.DEAD;

        assertThat(LifeGame.born(butai, 1, 1), is(LifeGame.DeadOrAlive.ALIVE));
    }

}
