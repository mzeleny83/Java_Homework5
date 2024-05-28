import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlantList {
    private List<Plant> plants;

    public PlantList() {
        plants = new ArrayList<>();
    }

    // Přidání nové rostliny
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    // Získání rostliny na zadaném indexu
    public Plant getPlant(int index) {
        return plants.get(index);
    }

    // Odebrání rostliny ze seznamu
    public void removePlant(int index) {
        plants.remove(index);
    }

    // Metoda vracející všechny rostliny
    public List<Plant> getAllPlants() {
        return plants;
    }

    // Načtení rostlin ze souboru
    public void loadFromFile(String filename) throws IOException, PlantException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\t");
            if (parts.length != 5) {
                throw new PlantException("Invalid file format");
            }
            String name = parts[0];
            String notes = parts[1];
            int wateringFrequency = Integer.parseInt(parts[2]);
            LocalDate planted = LocalDate.parse(parts[3]);
            LocalDate lastWatering = LocalDate.parse(parts[4]);
            Plant plant = new Plant(name, notes, planted, lastWatering, wateringFrequency);
            plants.add(plant);
        }
        reader.close();
    }

    // Uložení seznamu rostlin do souboru
    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Plant plant : plants) {
            writer.write(String.join("\t",
                    plant.getName(),
                    plant.getNotes(),
                    String.valueOf(plant.getWateringFrequency()),
                    plant.getPlanted().toString(),
                    plant.getLastWatering().toString()));
            writer.newLine();
        }
        writer.close();
    }

    // Seřazení rostlin podle názvu
    public void sortByName() {
        plants.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    // Seřazení rostlin podle data poslední zálivky
    public void sortByLastWatering() {
        plants.sort((p1, p2) -> p1.getLastWatering().compareTo(p2.getLastWatering()));
    }
}
