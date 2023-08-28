package ma.adventure.model;

import java.util.List;

public class Map {
    private final List<List<Character>> grid;

    public Map(List<List<Character>> grid) {
        this.grid = grid;
    }

    public List<List<Character>> getGrid() {
        return grid;
    }
}
