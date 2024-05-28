import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate lastWatering;
    private int wateringFrequency;

    // První konstruktor: nastavení všech atributů
    public Plant(String name, String notes, LocalDate planted, LocalDate lastWatering, int wateringFrequency) throws PlantException {
        if (wateringFrequency <= 0) {
            throw new PlantException("Frequency of watering must be greater than 0");
        }
        if (lastWatering.isBefore(planted)) {
            throw new PlantException("Last watering date cannot be before the planting date");
        }
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.lastWatering = lastWatering;
        this.wateringFrequency = wateringFrequency;
    }

    // Druhý konstruktor: poznámky prázdný řetězec, datum poslední zálivky dnešní datum
    public Plant(String name, LocalDate planted, int wateringFrequency) throws PlantException {
        this(name, "", planted, LocalDate.now(), wateringFrequency);
    }

    // Třetí konstruktor: výchozí frekvence 7 dnů, datum zasazení a zálivky na dnešní datum
    public Plant(String name) throws PlantException {
        this(name, "", LocalDate.now(), LocalDate.now(), 7);
    }

    // Přístupové metody
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDate getPlanted() { return planted; }
    public void setPlanted(LocalDate planted) { this.planted = planted; }

    public LocalDate getLastWatering() { return lastWatering; }
    public void setLastWatering(LocalDate lastWatering) { this.lastWatering = lastWatering; }

    public int getWateringFrequency() { return wateringFrequency; }
    public void setWateringFrequency(int wateringFrequency) throws PlantException {
        if (wateringFrequency <= 0) {
            throw new PlantException("Frequency of watering must be greater than 0");
        }
        this.wateringFrequency = wateringFrequency;
    }

    // Metoda vracející informace o zalévání
    public String getWateringInfo() {
        LocalDate nextWatering = lastWatering.plusDays(wateringFrequency);
        return "Plant: " + name + ", Last Watering: " + lastWatering + ", Next Watering: " + nextWatering;
    }
}

