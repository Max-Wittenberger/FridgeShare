package dhbwka.wwi.fridgeshare.web;

import dhbwka.wwi.fridgeshare.jpa.ProduktKategorie;
import java.util.ArrayList;
import java.util.List;

/**
 * Formularinhalte, exakt so, wie sie eingegeben wurden. Diese Klasse
 * spiegelt im Prinzip die Entity-Klasse Waste, kann aber auch ungültige
 * Werte speichern.
 */
public class ProduktForm {

    // Fehlermeldungen
    public List<String> errors = new ArrayList<>();
    
    // Eingabefelder
    private String name = "";
    private String menge = "";
    private String type = "";

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public List<String> getErrors() {
        return errors;
    }
    
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
        this.menge = menge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //</editor-fold>

    /**
     * Eingegebene Werte prüfen
     */
    public void checkValues() {
        if (name == null || name.trim().isEmpty()) {
            name = "";
            this.errors.add("Gib erst einen Namen ein.");
        }
        if (menge == null || menge.trim().isEmpty()) {
            menge = "";
            this.errors.add("Gib erst einen Inhalt ein.");
        }
        if (type == null || type.trim().isEmpty()) {
            type = "NONE";
        }
    }

    /**
     * Richtige Konstante für das Feld "type" ermitteln
     * @return Konstante
     */
    public ProduktKategorie getWasteType() {
        try {
            return ProduktKategorie.valueOf(type);
        } catch (IllegalArgumentException ex) {
            return ProduktKategorie.Sonstiges;
        }
    }
    
}
