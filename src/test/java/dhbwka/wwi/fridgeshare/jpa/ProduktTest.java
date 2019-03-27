/*
 * Copyright © 2019 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.fridgeshare.jpa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
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
