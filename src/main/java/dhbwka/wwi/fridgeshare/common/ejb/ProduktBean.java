package dhbwka.wwi.fridgeshare.common.ejb;


import dhbwka.wwi.fridgeshare.jpa.Produkt;
import dhbwka.wwi.fridgeshare.jpa.ProduktKategorie;
import dhbwka.wwi.fridgeshare.jpa.ProduktMaßeinheit;
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
     * @param maß Maßeinheit
     * @return Der angelegte Textschnippsel
     */
    public Produkt createNewProduct(String name, String content, ProduktKategorie type, ProduktMaßeinheit maß) {
        Produkt produkt = new Produkt(name, content, type, maß);
        return em.merge(produkt);
         
    }
    
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
