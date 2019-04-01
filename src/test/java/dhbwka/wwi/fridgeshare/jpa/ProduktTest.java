package dhbwka.wwi.fridgeshare.jpa;


import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author maxwi
 */
public class ProduktTest {
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        Produkt produkt = new Produkt("Apfel", "3" , dhbwka.wwi.fridgeshare.jpa.ProduktKategorie.Obst, ProduktMaßeinheit.ml, "K", "max");
        String expResult = "max";
        String result = produkt.getOwner() ;
        assertEquals(expResult, result);
    }
    
}
