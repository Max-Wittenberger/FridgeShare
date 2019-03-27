package dhbwka.wwi.fridgeshare.common.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author maxwi
 */
@Entity
@Table(name="GRUPPEN")
public class Gruppe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gruppeId;
    
    private String name;
    
    
    @ManyToMany
    @JoinTable(name = "FRIDGESHARE_USER", joinColumns = @JoinColumn(name = "USERNAME"), 
            inverseJoinColumns = @JoinColumn(name = "GRUPPEID") )
    private Collection<User> user = new ArrayList<User>();

    
    
    public Gruppe(String name) {
        this.name = name;
    }
    
    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGruppeId() {
        return gruppeId;
    }

    public void setGruppeId(Long gruppeId) {
        this.gruppeId = gruppeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gruppeId != null ? gruppeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the gruppeId fields are not set
        if (!(object instanceof Gruppe)) {
            return false;
        }
        Gruppe other = (Gruppe) object;
        if ((this.gruppeId == null && other.gruppeId != null) || (this.gruppeId != null && !this.gruppeId.equals(other.gruppeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dhbwka.wwi.fridgeshare.common.jpa.Gruppe[ id=" + gruppeId + " ]";
    }
    
}
