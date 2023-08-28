package ma.adventure.characters;



import ma.adventure.model.Direction;
import ma.adventure.model.Map;
import ma.adventure.model.Position;
import ma.adventure.exception.IllegalMovementException;

import java.util.List;

public class GameCharacter implements Move {
    private Map map;
    private Position currentPosition;

    public GameCharacter(Map map, Position initialPosition) {
        this.map = map;
        this.currentPosition = initialPosition;
    }

    public void move(List<Direction> directions) {
        for (Direction direction : directions) {
            Position newPosition = calculateNewPosition(direction);
            if (isValidPosition(newPosition)) {
                currentPosition = newPosition;
            }
            else {
               throw new IllegalMovementException("Illegal movement detected.");
            }
        }
    }

    public Position calculateNewPosition(Direction direction) {
        int newX = currentPosition.getX();
        int newY = currentPosition.getY();

        switch (direction) {
            case N:
                newY--;
                break;
            case S:
                newY++;
                break;
            case E:
                newX++;
                break;
            case O:
                newX--;
                break;
        }

        return new Position(newX, newY);
    }

    private boolean isValidPosition(Position position) {
        int x = position.getX();
        int y = position.getY();

        if (x < 0 || y < 0 || y >= map.getGrid().size() || x >= map.getGrid().get(y).size()) {
            return false; // Position is out of bounds
        }

        return map.getGrid().get(y).get(x) == ' '; // Empty space
    }

    public  String getCurrentPosition() {
        return currentPosition.getPosition();
    }
}
