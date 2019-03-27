/*
 * Copyright © 2019 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.fridgeshare.common.ejb;

import dhbwka.wwi.fridgeshare.common.jpa.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author maxwi
 */
public class EmailServiceTest {
        private EmailService es;
        private User user;
    
    /**
     * Test of sendMail method, of class EmailService.
     */
    @Test
    public void testEmailSend(){
        System.out.println("emailSend");
        es = new EmailService();
        user = new User("Max", "1234" , "Test@mail.com", "#ffff" , "testGruppe");
        boolean result = es.sendMail(user.getEmail());
        assertTrue(result);
    }    

}
