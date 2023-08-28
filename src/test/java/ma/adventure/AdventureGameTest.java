package ma.adventure;

import ma.adventure.model.Direction;
import ma.adventure.model.Map;
import ma.adventure.model.Position;
import ma.adventure.characters.GameCharacter;
import ma.adventure.readers.ReadMapFromFile;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class AdventureGameTest {
    private Map map;

    @Before
    public void setup() throws FileNotFoundException {
		URL resource =  getClass().getClassLoader().getResource("map.txt");
		if(resource == null) {
			throw new FileNotFoundException("No File Found");
		}
		System.out.println(resource.getPath());
        String filePath = resource.getPath();
        ReadMapFromFile mapReader = new ReadMapFromFile(resource.getPath());
        map = mapReader.read();

    }

    @Test
    public void shouldEndAt_9_2_WhenStartingAt_3_0() {
	        Position initialPosition = new Position(3, 0);

	        List<Direction> directions = Arrays.asList(
					Direction.S, Direction.S, Direction.S, Direction.S,
	                Direction.E, Direction.E, Direction.E, Direction.E,
					Direction.E, Direction.E,
	                Direction.N, Direction.N);

	      GameCharacter character = new GameCharacter(map, initialPosition);
	      character.move(directions);
          String finalPosition =  character.getCurrentPosition();
          String expectedPosition = "(9,2)";
        assertEquals(expectedPosition, finalPosition);
    }

	    @Test
	    public void shouldEndAt_7_5_WhenStartingAt_6_9() {
	        Position initialPosition = new Position(6, 9);
	        List<Direction> directions = Arrays.asList(
					Direction.O, Direction.O,
					Direction.N, Direction.O,
					Direction.O, Direction.O,
					Direction.S, Direction.S,
					Direction.O
	                );

	        GameCharacter character = new GameCharacter(map, initialPosition);
	        character.move(directions);

	        String finalPosition = character.getCurrentPosition();
	        String expectedPosition = "(7,5)";
	        assertEquals(expectedPosition, finalPosition);
	    }
}
