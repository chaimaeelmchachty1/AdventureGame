package ma.adventure.characters;



import ma.adventure.model.Direction;
import ma.adventure.model.Position;

import java.util.List;

public interface Move {
	public void move(List<Direction> directions);
	public Position calculateNewPosition(Direction direction) ;
}
