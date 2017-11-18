public class World {

    final int column;
    final int rows;

    public World(int column, int rows) {
        this.column = column;
        this.rows = rows;
    }

    public int cellCount() {
        return column * rows;
    }
}
