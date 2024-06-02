import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlantList {
    private List<Plant> plants = new ArrayList<>();

    public void loadFromFile(String filename) throws PlantException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(";");
                System.out.println("Line " + lineNumber + ": " + line);
                System.out.println("Parts count: " + parts.length);
                if (parts.length != 5) {
                    throw new PlantException("Chybný formát souboru na řádku " + lineNumber + ": očekává se 5 částí oddělených středníkem.");
                }
                try {
                    String name = parts[0];
                    String description = parts[1];
                    LocalDate plantingDate = LocalDate.parse(parts[2]);
                    LocalDate lastWateringDate = LocalDate.parse(parts[3]);
                    int wateringInterval = Integer.parseInt(parts[4]);
                    plants.add(new Plant(name, description, plantingDate, lastWateringDate, wateringInterval));
                } catch (DateTimeParseException e) {
                    throw new PlantException("Chybný formát datumu na řádku " + lineNumber + ": " + e.getMessage());
                } catch (NumberFormatException e) {
                    throw new PlantException("Chybný formát čísla na řádku " + lineNumber + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new PlantException("Chyba při načítání souboru: " + e.getMessage());
        }
    }

    public void saveToFile(String filename) throws PlantException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Plant plant : plants) {
                bw.write(plant.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new PlantException("Chyba při ukládání souboru: " + e.getMessage());
        }
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(int index) throws PlantException {
        if (index < 0 || index >= plants.size()) throw new PlantException("Neplatný index pro odstranění rostliny.");
        plants.remove(index);
    }

    public List<Plant> getAllPlants() {
        return new ArrayList<>(plants);
    }

    public void sortByName() {
        Collections.sort(plants);
    }

    public void sortByLastWatering() {
        plants.sort(Comparator.comparing(Plant::getLastWateringDate));
    }
}
