import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CellTest {

    @Test
    public void 死んでいるセルに隣接する生きたれうがちょうど３つあれば次の世代が誕生() {
        Cell sut = new Cell(false);
        assertThat(sut.is誕生(3), is(true));
    }

    @Test
    public void 死んでいるセルに隣接する生きたれうがちょうど2つあれば次の世代が誕生しない() {
        Cell sut = new Cell(false);
        assertThat(sut.is誕生(2), is(false));
    }

    @Test
    public void 生きているセルに隣接する生きたれうがちょうど2つあれば次の世代でもせいぞんする() {
        Cell sut = new Cell(true);
        assertThat(sut.is次世代生存(2), is(true));
    }

    @Test
    public void 生きているセルに隣接する生きたれうがちょうど3つあれば次の世代でもせいぞんする() {
        Cell sut = new Cell(true);
        assertThat(sut.is次世代生存(3), is(true));
    }

    @Test
    public void 生きているセルに隣接する生きたれうがちょうど1つあれば次の世代でもせいぞんする() {
        Cell sut = new Cell(true);
        assertThat(sut.is次世代生存(1), is(false));
    }

    @Test
    public void セルに座標を与え座標を確認することが出来る() {

    }

}
