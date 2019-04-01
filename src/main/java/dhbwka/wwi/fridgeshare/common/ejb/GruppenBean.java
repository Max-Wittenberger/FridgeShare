package dhbwka.wwi.fridgeshare.common.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maxwi
 */

@Stateless
public class GruppenBean {
   
     @PersistenceContext
    EntityManager em;
    
    public GruppenBean() {
    }
    


    
}
