import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlantList plantList = new PlantList();
        try {
            // Načtení seznamu rostlin ze souboru
            plantList.loadFromFile("C:/Users/m_zel/IdeaProjects/Java_Homework5/kvetiny.txt");


            // Výpis informací o zálivce pro všechny rostliny
            List<Plant> allPlants = plantList.getAllPlants();
            for (Plant plant : allPlants) {
                System.out.println(plant.getWateringInfo());
            }

            // Přidání dvou nových rostlin
            plantList.addPlant(new Plant("Růže", "Krásná růže", LocalDate.now(), LocalDate.now(), 3));
            plantList.addPlant(new Plant("Kaktus", "Nenáročný", LocalDate.now(), LocalDate.now(), 14));

            // Odebrání jedné rostliny
            plantList.removePlant(0);

            // Uložení seznamu do nového souboru
            plantList.saveToFile("novy_seznam.txt");

            // Seřazení podle názvu a výpis
            plantList.sortByName();
            System.out.println("Seřazeno podle názvu:");
            for (Plant plant : plantList.getAllPlants()) {
                System.out.println(plant.getWateringInfo());
            }

            // Seřazení podle data poslední zálivky a výpis
            plantList.sortByLastWatering();
            System.out.println("Seřazeno podle data poslední zálivky:");
            for (Plant plant : plantList.getAllPlants()) {
                System.out.println(plant.getWateringInfo());
            }

        } catch (IOException | PlantException e) {
            e.printStackTrace();
        }
    }
}
