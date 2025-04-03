
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        int[][] pile = {
            {1, 1, 1},
            {1, 3, 1},
            {1, 1, 1}
        };
        System.out.println(Arrays.deepToString(SandFall.addSand(pile, 2)));
    }

    static public class SandFall {

        private static final int MAX_SAND_CAPACITY = 3;
        private static final int[][] NEIGHBORS = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        static public int[][] addSand(int[][] pile, int n) {
            int center = pile.length / 2;
            int[][] result = deepCopy(pile);
            for (int i = 0; i < n; i++) {
                result = addSandAt(result, center, center);
            }

            return result;
        }

        static int[][] addSandAt(int[][] pile, int x, int y) {
            int[][] newPile = deepCopy(pile);
            if (newPile[x][y] < MAX_SAND_CAPACITY) {
                newPile[x][y] += 1;
            } else {
                pile[x][y] = 0;
                for (int[] neighbor : NEIGHBORS) {
                    int nextX = x + neighbor[0];
                    int nextY = y + neighbor[1];
                    if (isCoordinateInBox(nextX, nextY, newPile.length)) {
                        newPile = addSandAt(newPile, nextX, nextY);
                    }
                }
            }

            return newPile;
        }

        static boolean isCoordinateInBox(int x, int y, int width) {
            return !(x < 0 || x >= width || y < 0 || y >= width);
        }

        private static int[][] deepCopy(int[][] original) {
            if (original == null) {
                return null;
            }

            return Arrays.stream(original)
                    .map(row -> row.clone())
                    .toArray(length -> new int[length][]);
        }
    }

}
