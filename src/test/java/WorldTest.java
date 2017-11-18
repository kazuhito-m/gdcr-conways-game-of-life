import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WorldTest {

    @Test
    public void 縦行と横行を3と4与えると世界が出来てセル数が解る() {
        World sut = new World(3, 4);
        int actual = sut.cellCount();
        assertThat(actual, is(12));
    }

    @Test
    public void 縦行と横行を9と9与えると世界が出来てセル数が解る() {
        World sut = new World(9, 9);
        int actual = sut.cellCount();
        assertThat(actual, is(81));
    }

}
