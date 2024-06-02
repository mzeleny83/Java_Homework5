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
            System.out.println("Watering info for all plants:");
            List<Plant> allPlants = plantList.getAllPlants();
            for (Plant plant : allPlants) {
                System.out.println(plant.getWateringInfo());
            }

            // Add two new plants
            System.out.println("\nAdding two new plants...");
            plantList.addPlant(new Plant("Růže", "Krásná růže", LocalDate.now(), LocalDate.now(), 3));
            plantList.addPlant(new Plant("Kaktus", "Nenáročný", LocalDate.now(), LocalDate.now(), 14));

            // Print updated list
            System.out.println("Updated plant list:");
            allPlants = plantList.getAllPlants();
            for (Plant plant : allPlants) {
                System.out.println(plant.getWateringInfo());
            }

            // Remove one plant
            System.out.println("\nRemoving the first plant...");
            plantList.removePlant(0);

            // Print list after removal
            System.out.println("Plant list after removal:");
            allPlants = plantList.getAllPlants();
            for (Plant plant : allPlants) {
                System.out.println(plant.getWateringInfo());
            }

            // Save the updated list to a new file
            System.out.println("\nSaving the updated list to 'novy_seznam.txt'...");
            plantList.saveToFile("novy_seznam.txt");

            // Sort by name and print
            System.out.println("\nSorting plants by name:");
            plantList.sortByName();
            for (Plant plant : plantList.getAllPlants()) {
                System.out.println(plant.getWateringInfo());
            }

            // Sort by last watering date and print
            System.out.println("\nSorting plants by last watering date:");
            plantList.sortByLastWatering();
            for (Plant plant : plantList.getAllPlants()) {
                System.out.println(plant.getWateringInfo());
            }

        } catch (PlantException e) {
            System.err.println("Chyba: " + e.getMessage());
        }
    }
}
