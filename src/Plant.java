import java.time.LocalDate;

public class Plant implements Comparable<Plant> {
    private String name;
    private String description;
    private LocalDate plantingDate;
    private LocalDate lastWateringDate;
    private int wateringInterval;

    public Plant(String name, String description, LocalDate plantingDate, LocalDate lastWateringDate, int wateringInterval) throws PlantException {
        if (name == null || name.isEmpty()) throw new PlantException("Název rostliny nesmí být prázdný.");
        if (description == null || description.isEmpty()) throw new PlantException("Popis rostliny nesmí být prázdný.");
        if (plantingDate == null) throw new PlantException("Datum zasazení nesmí být prázdné.");
        if (lastWateringDate == null) throw new PlantException("Datum poslední zálivky nesmí být prázdné.");
        if (wateringInterval <= 0) throw new PlantException("Interval zálivky musí být kladné číslo.");

        this.name = name;
        this.description = description;
        this.plantingDate = plantingDate;
        this.lastWateringDate = lastWateringDate;
        this.wateringInterval = wateringInterval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws PlantException {
        if (name == null || name.isEmpty()) throw new PlantException("Název rostliny nesmí být prázdný.");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws PlantException {
        if (description == null || description.isEmpty()) throw new PlantException("Popis rostliny nesmí být prázdný.");
        this.description = description;
    }

    public LocalDate getPlantingDate() {
        return plantingDate;
    }

    public void setPlantingDate(LocalDate plantingDate) throws PlantException {
        if (plantingDate == null) throw new PlantException("Datum zasazení nesmí být prázdné.");
        this.plantingDate = plantingDate;
    }

    public LocalDate getLastWateringDate() {
        return lastWateringDate;
    }

    public void setLastWateringDate(LocalDate lastWateringDate) throws PlantException {
        if (lastWateringDate == null) throw new PlantException("Datum poslední zálivky nesmí být prázdné.");
        this.lastWateringDate = lastWateringDate;
    }

    public int getWateringInterval() {
        return wateringInterval;
    }

    public void setWateringInterval(int wateringInterval) throws PlantException {
        if (wateringInterval <= 0) throw new PlantException("Interval zálivky musí být kladné číslo.");
        this.wateringInterval = wateringInterval;
    }

    public String getWateringInfo() {
        return name + " (" + description + "): poslední zálivka " + lastWateringDate + ", zalévat každých " + wateringInterval + " dní.";
    }

    @Override
    public int compareTo(Plant other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + ";" + description + ";" + plantingDate + ";" + lastWateringDate + ";" + wateringInterval;
    }
}
