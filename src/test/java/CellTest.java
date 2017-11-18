import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CellTest {
    @Test
    public void セルから生きてることが取れる() {
        Cell sut = new Cell(true);
        assertThat(sut.isAlive(), is(true));
    }

    @Test
    public void セルから死んでいることがとれる() {
        Cell sut = new Cell(false);
        assertThat(sut.isAlive(), is(false));

    }

    @Test
    public void 死んでいるセルが隣接セルが３のときに誕生が成功する() {
        Cell sut = new Cell(false);
        assertThat(sut.nextState(3), is(true));
    }

    @Test
    public void 死んでいるセルが隣接セルが4のときに誕生が失敗する() {
        Cell sut = new Cell(false);
        assertThat(sut.nextState(4), is(false));
    }

    @Test
    public void 生きているセルに隣接するセルが３の時は次世代でも生存する() {
        Cell sut = new Cell(true);
        assertThat(sut.nextState(3), is(true));
    }

    @Test
    public void 生きているセルに隣接するセルが2の時は次世代でも生存する() {
        Cell sut = new Cell(true);
        assertThat(sut.nextState(2), is(true));
    }
    
    @Test
    public void 生きているセルに隣接するセルが１の時は次世代では死滅する() {
        Cell sut = new Cell(true);
        assertThat(sut.nextState(1), is(false));
    }

    @Test
    public void 生きているセルに隣接する生きたセルが0なら死滅する() {
        Cell sut = new Cell(true);
        assertThat(sut.nextState(0), is(false));
    }

    @Test
    public void 生きているセルに隣接する生きたセルが4以上なら死滅する() {
        Cell sut = new Cell(true);
        assertThat(sut.nextState(4), is(false));
        assertThat(sut.nextState(5), is(false));
    }

}