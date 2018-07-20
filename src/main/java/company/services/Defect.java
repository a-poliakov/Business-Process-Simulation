package company.services;

public class Defect extends Task {
    public Defect(String name, String description) {
        super(name, description);
    }

    @Override
    public String toString() {
        return "Дефект \"" + getName() + " " + getDescription() + "\"";
    }
}
