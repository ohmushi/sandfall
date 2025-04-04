package cat.ohmushi;

import java.util.ArrayDeque;
import java.util.Queue;

public class Simulation {

    private final Grid grid;
    private final Queue<Position> positionsToProcess = new ArrayDeque<>();

    public Simulation(int[][] initialState) {
        this.grid = new Grid(initialState);
    }

    public Grid addGrainsOfSand(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of grains sand must be positive.");
        }
        for (int i = 0; i < n; i++) {
            addSandAtPosition(grid.getCenter());
        }

        return this.grid;
    }

    private void addSandAtPosition(Position position) {
        positionsToProcess.offer(position);

        while (!positionsToProcess.isEmpty()) {
            tryToAddSandAt(positionsToProcess.poll());
        }
    }

    private void tryToAddSandAt(Position p) {
        if (!p.existsIn(grid)) {
            return;
        }

        if (grid.isFullAt(p)) {
            grid.resetAt(p);
            addSandToNeighborsOf(p);
        } else {
            grid.addOneGrainOfSandAt(p);
        }
    }

    private void addSandToNeighborsOf(Position p) {
        for (Direction direction : Direction.values()) {
            Position neighbor = direction.of(p);
            if (neighbor.existsIn(grid)) {
                positionsToProcess.offer(neighbor);
            }
        }
    }

    @Override
    public String toString() {
        return grid.toString();
    }

}
