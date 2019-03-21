/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.wastebin.ejb;

import dhbwka.wwi.vertsys.javaee.wastebin.jpa.ProduktKategorie;
import dhbwka.wwi.vertsys.javaee.wastebin.jpa.Produkt;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Enterprise Java Bean zur Verwaltung der angelegten Textschnippsel.
 */
@Stateless
public class ProduktBean {
    
    @PersistenceContext
    EntityManager em;
    
    /**
     * Anlegen eines neuen Textschnippsels.
     * @param name Bezeichnung
     * @param content Inhalt
     * @param type Syntaxhervorhebung
     * @return Der angelegte Textschnippsel
     */
    public Produkt createNewProduct(String name, String content, ProduktKategorie type) {
        Produkt produkt = new Produkt(name, content, type);
        em.persist(produkt);
        return em.merge(produkt);
    }
    
    /**
     * @return Liste mit allen Textschnippsel in umgedrehter Anlagereihenfolge
     */
    public List<Produkt> findAllProducts() {
        return em.createQuery("SELECT w FROM Produkt w ").getResultList();
    }
    
    /**
     * Einzelnen Textschnippsel ermitteln
     * @param id ID des Textschnippsels
     * @return Gefundenes Objekt oder null
     */
    public Produkt findProduct(long id) {
        return em.find(Produkt.class, id);
    }
    
    /**
     * Löschen eines Textschnippsels. (Müll leeren :-))
     * 
     * @param id ID des zu löschenden Schnippsels
     * @return Der gelöschte Schnippsel oder null
     */
    public Produkt deleteProdukt(long id) {
        Produkt produkt = em.find(Produkt.class, id);
        
        if (produkt != null) {
            em.remove(produkt);
        }
        
        return produkt;
    }
    
    /**
     * Änderungen an einem Textschnippsel speichern.
     * @param produkt Der zu ändernde Textschnippsel
     * @return Neue, gespeicherte Version des Textschnippsels
     */
    public Produkt updateProdukt(Produkt produkt) {
        return em.merge(produkt);
    }
    
}
