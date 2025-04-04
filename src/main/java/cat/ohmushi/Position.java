package cat.ohmushi;


public record Position(int x, int y) {

    public boolean existsIn(Grid grid) {
        return grid.isPositionExists(this);
    }

}
