package ma.adventure.readers;

import ma.adventure.model.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadMapFromFile implements MapReaders {
    private String filePath;

    public ReadMapFromFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Map read() {
        List<List<Character>> grid = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<Character> row = new ArrayList<>();
                for (char c : line.toCharArray()) {
                    row.add(c);
                }
                grid.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Map(grid);
    }
}
