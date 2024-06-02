import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantList {
    private List<Plant> plants = new ArrayList<>();

    public void loadFromFile(String fileName) throws IOException, PlantException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                if (parts.length != 5) {
                    throw new PlantException("Invalid file format: incorrect number of fields in line: " + line);
                }
                String name = parts[0];
                String description = parts[1];
                int frequency = Integer.parseInt(parts[2]);
                LocalDate planted = LocalDate.parse(parts[3]);
                LocalDate lastWatering = LocalDate.parse(parts[4]);
                plants.add(new Plant(name, description, planted, lastWatering, frequency));
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("File not found: " + fileName);
        } catch (DateTimeParseException e) {
            throw new PlantException("Invalid date format in file: " + fileName);
        } catch (NumberFormatException e) {
            throw new PlantException("Invalid number format in file: " + fileName);
        }
    }

    public List<Plant> getAllPlants() {
        return new ArrayList<>(plants);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(int index) {
        if (index >= 0 && index < plants.size()) {
            plants.remove(index);
        }
    }

    public void saveToFile(String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Plant plant : plants) {
                writer.println(
                        plant.getName() + "\t" +
                                plant.getDescription() + "\t" +
                                plant.getWateringFrequency() + "\t" +
                                plant.getPlantedDate() + "\t" +
                                plant.getLastWateringDate());
            }
        }
    }

    public void sortByName() {
        plants.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void sortByLastWatering() {
        plants.sort((p1, p2) -> p1.getLastWateringDate().compareTo(p2.getLastWateringDate()));
    }
}
