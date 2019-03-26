package dhbwka.wwi.fridgeshare.jpa;

/**
 * Aufzählung der verfügbaren Kategorien für ein Produkt,
 */
public enum ProduktKategorie {

    Fleisch, Fisch , Obst, Gemüse, Milchprodukte, Süsswaren, Gefrierfach, Sonstiges ;

    /**
     * Bezeichnung ermitteln
     *
     * @return Bezeichnung
     */
    public String getLabel() {
        switch (this) {
            case Sonstiges:
                return "Sonstiges";
            case Fleisch:
                return "Fleisch";
            case Fisch:
                return "Fisch";
            case Obst:
                return "Obst";
            case Gemüse:
                return "Gemüse";
            case Milchprodukte:
                return "Milchprodukte";
            case Süsswaren:
                return "Süsswaren";
            case Gefrierfach:
                return "Gefrierfach";
            default:
                return this.toString();
        }
    }

    /**
     * Name der Kategorie für ein Produkt.
     * @return Kategorie
     */
    public String getPrism() {
        switch (this) {
            case Sonstiges:
                return "Sonstiges";
            case Fleisch:
                return "Fleisch";
            case Fisch:
                return "Fisch";
            case Obst:
                return "Obst";
            case Gemüse:
                return "Gemüse";
            case Milchprodukte:
                return "Milchprodukte";
            case Süsswaren:
                return "Süsswaren";
            case Gefrierfach:
                return "Gefrierfach";
            default:
                return "";
        }
    }
}
