package ma.adventure;

import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import ma.adventure.model.Direction;
import ma.adventure.model.Map;
import ma.adventure.model.Position;
import ma.adventure.characters.GameCharacter;
import ma.adventure.readers.MapReaders;
import ma.adventure.readers.ReadMapFromFile;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String filePath = getPathFile() ;

        MapReaders mapReader = new ReadMapFromFile(filePath);
        Map map = mapReader.read();

        Position initialPosition = new Position(3, 0);

        List<Direction> directions = getUserDirections();

        GameCharacter characterMovement = new GameCharacter(map, initialPosition);
        characterMovement.move(directions);

        String finalPosition = characterMovement.getCurrentPosition();
        System.out.println("Final position: " + finalPosition);
    }

    public static List<Direction> getUserDirections() {
        Scanner scanner = new Scanner(System.in);
        List<Direction> directions = new ArrayList<>();

        System.out.println("Enter directions (N/S/E/O), or 'exit' to finish:");
        String input = scanner.nextLine();

        for (char c : input.toCharArray()) {
            Direction direction = getDirectionFromChar(c);
            if (direction != null) {
                directions.add(direction);
            } else {
                System.out.println("Invalid direction character: " + c);
            }
        }

        scanner.close();
        return directions;
    }

    public static Direction getDirectionFromChar(char c) {
        switch (c) {
            case 'N':
                return Direction.N;
            case 'S':
                return Direction.S;
            case 'E':
                return Direction.E;
            case 'O':
                return Direction.O;
            default:
                return null;
        }
    }
    public static String getPathFile() throws FileNotFoundException {
        URL resource =  Main.class.getClassLoader().getResource("map.txt");
        if(resource == null) {
            throw new FileNotFoundException("No File Found");
        }
        return  resource.getPath();
    }
}