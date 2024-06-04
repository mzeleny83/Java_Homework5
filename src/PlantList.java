import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlantList {
    private List<Plant> plants = new ArrayList<>();

    public void loadFromFile(String fileName) throws IOException, PlantException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            // Replace tabs with semicolons for consistent processing
            String standardizedLine = line.replace('\t', ';');
            String[] parts = standardizedLine.split(";");
            if (parts.length != 5) {
                throw new PlantException("Invalid file format: incorrect number of fields in line '" + line + "'");
            }
            try {
                String name = parts[0];
                String description = parts[1];
                LocalDate plantedDate = LocalDate.parse(parts[2]);
                LocalDate lastWateringDate = LocalDate.parse(parts[3]);
                int wateringInterval = Integer.parseInt(parts[4]);
                plants.add(new Plant(name, description, plantedDate, lastWateringDate, wateringInterval));
            } catch (DateTimeParseException e) {
                throw new PlantException("Invalid file format: date parsing error in line '" + line + "'");
            } catch (NumberFormatException e) {
                throw new PlantException("Invalid file format: number parsing error in line '" + line + "'");
            }
        }
    }

    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (Plant plant : plants) {
                writer.write(String.format("%s;%s;%s;%s;%d\n",
                        plant.getName(),
                        plant.getDescription(),
                        plant.getPlantedDate().toString(),
                        plant.getLastWateringDate().toString(),
                        plant.getWateringInterval()));
            }
        }
    }

    public List<Plant> getAllPlants() {
        return new ArrayList<>(plants);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(int index) throws PlantException {
        if (index < 0 || index >= plants.size()) {
            throw new PlantException("Invalid plant index");
        }
        plants.remove(index);
    }

    public void sortByName() {
        Collections.sort(plants);
    }

    public void sortByLastWatering() {
        plants.sort(Comparator.comparing(Plant::getLastWateringDate));
    }
}
