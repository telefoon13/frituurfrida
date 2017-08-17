package be.vdab.enteties;

import java.time.LocalDate;

public class OpenGesloten {
    @Override
    public String toString() {
        int dag = LocalDate.now().getDayOfWeek().getValue();
        return dag == 1 || dag == 4 ?
                "Onze excuses, wij zijn vandaag gesloten<br><img src=\"../../images/gesloten.png\" alt=\"Gesloten\">"
                :
                "Welkom, wij zijn vandaag open<br><img src=\"../../images/open.png\" alt=\"Open\">";
    }
}