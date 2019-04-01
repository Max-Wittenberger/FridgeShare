package dhbwka.wwi.fridgeshare.web;

import dhbwka.wwi.fridgeshare.common.ejb.ProduktBean;
import dhbwka.wwi.fridgeshare.jpa.Produkt;
import dhbwka.wwi.fridgeshare.jpa.ProduktKategorie;
import dhbwka.wwi.fridgeshare.jpa.ProduktMaßeinheit;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Anlegen eines neuen Produkts.
 */
@WebServlet(urlPatterns = {"/app/new/*"})
public class CreateServlet extends HttpServlet {
    
    @EJB
    ProduktBean produktBean;
   
    public static final String URL = "/app/new/*";
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Objekt mit leeren Eingabewerten im Request Context ablegen,
        // damit es beim Erstaufruf nicht zum Absturz kommt
        HttpSession session = request.getSession();
        
        
        
        Produkt form = this.getRequestedProdukt(request);
        
        if (form == null) {
            session.setAttribute("produkt_form", new ProduktForm());
        }
        
        // Anfrage an die JSP weiterleiten
        request.setAttribute("produktKategorie", ProduktKategorie.values());
        request.setAttribute("produktMaßeinheit", ProduktMaßeinheit.values());
        request.setAttribute("produkt", form);
        request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);

        // Fehlermeldungen und so weiter aus der Session löschen, damit sie
        // beim nächsten Aufruf verschwinden
        session.removeAttribute("produkt_form");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        // Eingegebene Werte prüfen
        
        ProduktForm form = new ProduktForm();
        
        form.setName(request.getParameter("name"));
        form.setMenge(request.getParameter("menge"));
        form.setType(request.getParameter("type"));
        form.setMaß(request.getParameter("mass"));
        form.setOrt(request.getParameter("ort"));
        
        String[] values = request.getParameterValues("meine");
            if(values == null){
                form.setOwner(request.getParameter("owner"));
            }

        form.checkValues();
        
        // Formular erneut anzeigen, wenn es Fehler gibt        
        if (!form.errors.isEmpty()) {
            // Formular erneut anzeigen, wenn es Fehler gibt
            HttpSession session = request.getSession();
            session.setAttribute("produkt_form", form);

            response.sendRedirect(request.getContextPath() + CreateServlet.URL);
            return;
        }
        //Produkt finden, falls es schon vorhanden ist löschen
        Produkt produkt = this.getRequestedProdukt(request);
        if(produkt != null){
            produktBean.deleteProdukt(produkt);
        }
        
        // Eintrag speichern und zurück zur Startseite
        this.produktBean.createNewProduct(form.getName(), form.getMenge(), form.getProduktKategorie(), form.getProduktMaßeinheit(), form.getOrt(), form.getOwner());
        response.sendRedirect(request.getContextPath() + KuehlschrankServlet.URL);
    }
    
    
    
    
private Produkt getRequestedProdukt(HttpServletRequest request) {
        // Zunächst davon ausgehen, dass ein neuer Satz angelegt werden soll
        Produkt produkt = new Produkt();

        // ID aus der URL herausschneiden
        String taskId = request.getPathInfo();

        if (taskId == null) {
            taskId = "";
        }

        taskId = taskId.substring(1);

        if (taskId.endsWith("/")) {
            taskId = taskId.substring(0, taskId.length() - 1);
        }

        // Versuchen, den Datensatz mit der übergebenen ID zu finden
        try {
            produkt = this.produktBean.findById(Long.parseLong(taskId));
        } catch (NumberFormatException ex) {
            // Ungültige oder keine ID in der URL enthalten
        }

        return produkt;
    }
    
}
