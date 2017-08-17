package be.vdab.enteties;

import java.time.LocalDate;

public class OpenGesloten {
    @Override
    public String toString() {
        int dag = LocalDate.now().getDayOfWeek().getValue();
        return dag == 1 || dag == 5 ? "gesloten" : "open";
    }
}