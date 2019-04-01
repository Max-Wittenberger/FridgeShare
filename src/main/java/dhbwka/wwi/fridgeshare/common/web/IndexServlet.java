package dhbwka.wwi.fridgeshare.common.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet für die Startseite /index.html. Hier wird der Anwender einfach auf
 * den Kühlschrank weitergeleitet. Falls er noch nicht eingeloggt ist,
 * sorgt der Applikationsserver von alleine dafür, zunächst die Loginseite
 * anzuzeigen.
 */
@WebServlet(urlPatterns = {"/index.html"})
public class IndexServlet extends HttpServlet {
    
    /**
     * GET-Anfrage: Seite anzeigen
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        response.sendRedirect(WebUtils.appUrl(request, "/app/kuehlschrank"));
    }

}