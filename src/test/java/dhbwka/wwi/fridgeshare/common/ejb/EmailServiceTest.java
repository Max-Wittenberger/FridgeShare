package dhbwka.wwi.fridgeshare.common.ejb;

import dhbwka.wwi.fridgeshare.email.EmailService;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author maxwi
 */
public class EmailServiceTest {
    
    /**
     * Test of sendMail method, of class EmailService.
     */
    @Test
    public void testEmailSend() throws MessagingException, AddressException, IOException{
        System.out.println("E-Mail senden");
        
        boolean result = EmailService.sendEmailTo("maxwittenberger@gmail.com");
        
        assertTrue(result);
    }    

} 