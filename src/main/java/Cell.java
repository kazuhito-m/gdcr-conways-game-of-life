public class Cell {

    final boolean value;

    public Cell(boolean value) {
        this.value = value;
    }

    public boolean isAlive() {
        return value;
    }

    private boolean isBirth(int neighborhoodCount) {
        return neighborhoodCount == 3;
    }

    private boolean isSurvival(int neighborhoodCount) {
        return (neighborhoodCount == 2 || neighborhoodCount == 3);
    }

    public boolean nextState(int neighborhoodCount) {
        if (isAlive()) return isSurvival(neighborhoodCount);
        return isBirth(neighborhoodCount);
    }
    
}
