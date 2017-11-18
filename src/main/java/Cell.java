import java.util.Arrays;

public class Cell {

    private final boolean 生存;

    public boolean is誕生(int 隣接数) {
        return 隣接数 == 3;
    }

    public Cell(boolean 生存) {
        this.生存 = 生存;
    }

    public boolean is次世代生存(int 隣接数) {
        return Arrays.asList(2, 3).contains(隣接数);
    }
}
