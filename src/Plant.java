import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Plant {
    private String name;
    private String description;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private int wateringFrequency;

    public Plant(String name, String description, LocalDate plantedDate, LocalDate lastWateringDate, int wateringFrequency) {
        this.name = name;
        this.description = description;
        this.plantedDate = plantedDate;
        this.lastWateringDate = lastWateringDate;
        this.wateringFrequency = wateringFrequency;
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

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public String getWateringInfo() {
        return name + " needs watering every " + wateringFrequency + " days. Last watered on: " + lastWateringDate;
    }
}
