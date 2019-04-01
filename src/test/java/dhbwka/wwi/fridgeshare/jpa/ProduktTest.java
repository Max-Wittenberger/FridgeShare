package dhbwka.wwi.fridgeshare.jpa;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author maxwi
 */
public class ProduktTest {
    Produkt produkt = new Produkt("Apfel", "3" , dhbwka.wwi.fridgeshare.jpa.ProduktKategorie.Obst, ProduktMaßeinheit.ml, "K", "max");
    
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        String expResult = "max";
        String result = produkt.getOwner() ;
        assertEquals(expResult, result);
    }
    
    @Test 
    public void testgetName(){
        System.out.println("getName");
        String expResult = "Apfel";
        String result = produkt.getName();
        assertEquals(expResult, result);
    }
    
     @Test 
    public void testgetOrt(){
        System.out.println("getOrt");
        String expResult = "K";
        String result = produkt.getOrt();
        assertEquals(expResult, result);
    }
}
