package dhbwka.wwi.fridgeshare.common.ejb;

import dhbwka.wwi.fridgeshare.common.jpa.Gruppe;
import dhbwka.wwi.fridgeshare.common.jpa.User;
import java.rmi.RemoteException;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
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
