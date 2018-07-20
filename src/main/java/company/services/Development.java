package company.services;

public class Development extends Task {
    public Development(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "Разработка \"" + getName() + " " + getDescription() + "\"";
    }
}
