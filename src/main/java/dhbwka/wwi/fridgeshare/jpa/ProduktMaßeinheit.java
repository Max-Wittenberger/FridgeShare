package dhbwka.wwi.fridgeshare.jpa;
/**
 * Aufzählung der verfügbaren Maßeinheiten,
 */
public enum ProduktMaßeinheit{

    Stück, Packung , kg, g, l, ml, Sonstiges;

    /**
     * Bezeichnung ermitteln
     *
     * @return Bezeichnung
     */
    public String getLabel() {
        switch (this) {
            case Stück:
                return "Stück";
            case Packung:
                return "Packung";
            case kg:
                return "kg";
            case g:
                return "g";
            case l:
                return "l";
            case ml:
                return "ml";
            case Sonstiges:
                return "Sonstiges";
            default:
                return this.toString();
        }
    }

    /**
     * Name der Maßeinheit für ein Produkt ermitteln.
     * @return Maßeinheit
     */
    public String getPrism() {
        switch (this) {
            case Stück:
                return "Stück";
            case Packung:
                return "Packung";
            case kg:
                return "kg";
            case g:
                return "g";
            case l:
                return "l";
            case ml:
                return "ml";
            case Sonstiges:
                return "Sonstiges";
            default:
                return "";
        }
    }
}
