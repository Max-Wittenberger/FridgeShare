/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.fridgeshare.jpa;

/**
 * Aufzählung der verfügbaren Sprachen für das Syntax Highlighting,
 */
public enum ProduktKategorie {

    Sonstiges, Fleisch, Obst;

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
            case Obst:
                return "Obst";
            default:
                return this.toString();
        }
    }

    /**
     * Name der Programmiersprache für den Prism.js Syntaxhighlighter ermitteln.
     * @return Name der Sprache für prism.js
     */
    public String getPrism() {
        switch (this) {
            case Sonstiges:
                return "Sonstiges";
            case Fleisch:
                return "Fleisch";
            case Obst:
                return "Obst";
            default:
                return "";
        }
    }
}
