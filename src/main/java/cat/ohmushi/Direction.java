package cat.ohmushi;

public enum Direction {
    UP, Down, Left, Right;

    public Position of(Position p) {
        var x = p.x();
        var y = p.y();
        return switch (this) {
            case UP ->
                new Position(x, y - 1);
            case Down ->
                new Position(x, y + 1);
            case Left ->
                new Position(x - 1, y);
            case Right ->
                new Position(x + 1, y);
        };
    }
}
