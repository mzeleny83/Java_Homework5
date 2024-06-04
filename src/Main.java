import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlantList plantList = new PlantList();
        try {
            // Load plant list from file
            plantList.loadFromFile("kvetiny.txt");

            // Print watering info for all plants
            List<Plant> allPlants = plantList.getAllPlants();
            for (Plant plant : allPlants) {
                System.out.println(plant.getWateringInfo());
            }

            // Add two new plants
            plantList.addPlant(new Plant("Růže", "Krásná růže", LocalDate.now(), LocalDate.now(), 3));
            plantList.addPlant(new Plant("Kaktus", "Nenáročný", LocalDate.now(), LocalDate.now(), 14));

            // Remove one plant
            plantList.removePlant(0);

            // Save the updated list to a new file
            plantList.saveToFile("novy_seznam.txt");

            // Sort by name and print
            plantList.sortByName();
            System.out.println("Sorted by name:");
            for (Plant plant : plantList.getAllPlants()) {
                System.out.println(plant.getWateringInfo());
            }

            // Sort by last watering date and print
            plantList.sortByLastWatering();
            System.out.println("Sorted by last watering date:");
            for (Plant plant : plantList.getAllPlants()) {
                System.out.println(plant.getWateringInfo());
            }

        } catch (IOException | PlantException e) {
            e.printStackTrace();
        }
    }
}
