import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Plant implements Comparable<Plant> {
    private String name;
    private String description;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private int wateringInterval;

    public Plant(String name, String description, LocalDate plantedDate, LocalDate lastWateringDate, int wateringInterval) {
        this.name = name;
        this.description = description;
        this.plantedDate = plantedDate;
        this.lastWateringDate = lastWateringDate;
        this.wateringInterval = wateringInterval;
    }

    public String getWateringInfo() {
        return String.format("Plant: %s, Description: %s, Last Watered: %s, Watering Interval: %d days",
                name, description, lastWateringDate.format(DateTimeFormatter.ISO_DATE), wateringInterval);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPlantedDate() {
        return plantedDate;
    }

    public LocalDate getLastWateringDate() {
        return lastWateringDate;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    @Override
    public int compareTo(Plant other) {
        return this.name.compareTo(other.name);
    }
}
