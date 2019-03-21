/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.wastebin.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.TableGenerator;

/**
 * Ein Müll bzw. ein Textschnippsel, den ein Anwender angelegt hat.
 */
@Entity
public class Produkt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "produkt_ids")
    @TableGenerator(name = "produkt_ids", initialValue = 0, allocationSize = 50)
    private Long id;

    private String name = "";
    private ProduktKategorie type = ProduktKategorie.Sonstiges;

    //@Lob
    private String menge = "";

    //<editor-fold defaultstate="collapsed" desc="Konstrukturen">
    public Produkt() {
    }
    
    public Produkt(String name, String menge, ProduktKategorie type) {
        this.name = name;
        this.menge = menge;
        this.type = type;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProduktKategorie getType() {
        return type;
    }

    public void setType(ProduktKategorie type) {
        this.type = type;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Von Objekt geerbter Kram">
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produkt)) {
            return false;
        }
        Produkt other = (Produkt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dhbwka.wwi.vertsys.javee.wastebin.WasteEntity[ id=" + id + " ]";
    }
    //</editor-fold>

}
