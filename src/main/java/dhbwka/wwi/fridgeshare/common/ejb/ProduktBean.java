package dhbwka.wwi.fridgeshare.common.ejb;


import dhbwka.wwi.fridgeshare.jpa.Produkt;
import dhbwka.wwi.fridgeshare.jpa.ProduktKategorie;
import dhbwka.wwi.fridgeshare.jpa.ProduktMaßeinheit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
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
    public Produkt createNewProduct(String name, String content, ProduktKategorie type, ProduktMaßeinheit maß, String ort, String owner) {
        Produkt produkt = new Produkt(name, content, type, maß, ort, owner);
        return em.merge(produkt);
         
    }
    
    public List<Produkt> findAllProducts(String ort) {
        return em.createQuery("SELECT w FROM Produkt w WHERE w.ort LIKE :ort").setParameter("ort", ort).getResultList();
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
     * Löschen eines Produkts
     * 
     * @param id ID des zu löschenden Produkts
     * @return Das gelöschte Produkt oder null
     */
    public Produkt deleteProdukt(Produkt produkt) {
        if (produkt != null) {
            em.remove(em.merge(produkt));
        }
        return produkt;
    }
   
    
    public Produkt findById(Long Id) {
        Produkt produkt = em.find(Produkt.class, Id);
        if (produkt == null) {
            throw new EntityNotFoundException("Can't find Produkt for ID "
                + Id);
        }
        return produkt;
    }
    
    public Produkt changeKategorie(Produkt produkt) {
        String ort = produkt.getOrt();
        if(ort.equals("K")){
                produkt.setOrt("E");
        }else{
            produkt.setOrt("K");
        }
        return em.merge(produkt);
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
