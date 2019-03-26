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

import java.io.Serializable;
import javax.persistence.Column;
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
    private ProduktMaßeinheit maß = ProduktMaßeinheit.Stück;
    private String owner = "";
    @Column(name = "ORT")
    private String ort = "";
    private String ower = "";


    //@Lob
    private String menge = "";

    //<editor-fold defaultstate="collapsed" desc="Konstrukturen">
    public Produkt() {
    }
    
    public Produkt(String name, String menge, ProduktKategorie type, ProduktMaßeinheit maß, String ort, String owner) {
        this.name = name;
        this.menge = menge;
        this.type = type;
        this.maß = maß;
        this.ort = ort;
        this.owner = owner;
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    
    public String getOwer() {
        return ower;
    }

    public void setOwer(String ower) {
        this.ower = ower;
    }
    
        public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    
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
    
    public ProduktMaßeinheit getMaß() {
        return maß;
    }

    public void setMaß(ProduktMaßeinheit maß) {
        this.maß = maß;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
