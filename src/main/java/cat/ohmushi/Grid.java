package cat.ohmushi;

import java.util.Arrays;

public class Grid {

    private static final int MAX_SAND_CAPACITY = 3;
    private final int[][] cells;

    public Grid(int[][] initialState) {
        var isOdd = (initialState.length & 1) == 1;
        var isInitialStateValid = isOdd && isGridASquare(initialState);
        if (!isInitialStateValid) {
            throw new IllegalArgumentException("Invalid grid.");
        }
        this.cells = deepCopy(initialState);
    }

    void addOneGrainOfSandAt(Position p) {
        if (isPositionExists(p)) {
            this.cells[p.x()][p.y()] += 1;
        }
    }

    public boolean isPositionExists(Position position) {
        var x = position.x();
        var y = position.y();
        return x >= 0 && x < cells.length && y >= 0 && y < cells.length;
    }

    private boolean isGridASquare(int[][] grid) {
        var height = grid.length;
        for (int[] row : grid) {
            var width = row.length;
            if (height != width) {
                return false;
            }
        }
        return true;
    }

    private static int[][] deepCopy(int[][] original) {
        return Arrays.stream(original)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    public Position getCenter() {
        var center = this.cells.length / 2;
        return new Position(center, center);
    }

    public boolean isFullAt(Position p) {
        return this.cells[p.x()][p.y()] >= MAX_SAND_CAPACITY;
    }

    public void resetAt(Position p) {
        this.cells[p.x()][p.y()] = 0;
    }

    public int[][] grid() {
        return deepCopy(cells);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : cells) {
            sb.append(Arrays.toString(row)).append('\n');
        }
        return sb.toString();
    }

}
