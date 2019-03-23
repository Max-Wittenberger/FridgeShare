/*
 * Copyright © 2018 Dennis Schulmeister-Zimolong
 * 
 * E-Mail: dhbw@windows3.de
 * Webseite: https://www.wpvs.de/
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.fridgeshare.web;

import dhbwka.wwi.fridgeshare.common.ejb.ProduktBean;
import dhbwka.wwi.fridgeshare.jpa.ProduktKategorie;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Anlegen eines neuen Textschnippsels.
 */
@WebServlet(urlPatterns = {"/app/new"})
public class CreateServlet extends HttpServlet {
    
    @EJB
    ProduktBean wasteBean;
   
    public static final String URL = "/new";
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Objekt mit leeren Eingabewerten im Request Context ablegen,
        // damit es beim Erstaufruf nicht zum Absturz kommt
        HttpSession session = request.getSession();
        ProduktForm form = (ProduktForm) session.getAttribute("produkt_form");
        
        if (form == null) {
            session.setAttribute("produkt_form", new ProduktForm());
        }
        
        // Anfrage an die JSP weiterleiten
        request.setAttribute("produktKategorie", ProduktKategorie.values());
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

        form.checkValues();
        
        // Formular erneut anzeigen, wenn es Fehler gibt        
        if (!form.errors.isEmpty()) {
            // Formular erneut anzeigen, wenn es Fehler gibt
            HttpSession session = request.getSession();
            session.setAttribute("produkt_form", form);

            response.sendRedirect(request.getContextPath() + CreateServlet.URL);
            return;
        }

        // Eintrag speichern und zurück zur Startseite
        this.wasteBean.createNewProduct(form.getName(), form.getMenge(), form.getWasteType());
        response.sendRedirect(request.getContextPath() + Kuehlschrank.URL);
    }
    
}
