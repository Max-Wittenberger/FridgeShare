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
import dhbwka.wwi.fridgeshare.common.ejb.UserBean;
import dhbwka.wwi.fridgeshare.common.ejb.ValidationBean;
import dhbwka.wwi.fridgeshare.common.jpa.User;
import dhbwka.wwi.fridgeshare.common.web.FormValues;
import dhbwka.wwi.fridgeshare.common.web.WebUtils;
import dhbwka.wwi.fridgeshare.jpa.ProduktKategorie;
import dhbwka.wwi.fridgeshare.jpa.ProduktMaßeinheit;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/app/user"})
public class UserServlet extends HttpServlet {
    
    @EJB
    ProduktBean produktBean;
    
    @EJB 
    UserBean userBean;
    
    @EJB
    ValidationBean validationBean;
    
    
   
    public static final String URL = "/app/user";
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Objekt mit leeren Eingabewerten im Request Context ablegen,
        // damit es beim Erstaufruf nicht zum Absturz kommt
        HttpSession session = request.getSession();
        
         User user = this.userBean.getCurrentUser();
        request.setAttribute("user", user);
        request.setAttribute("gruppen", user.getGruppen());
        
        
        // Anfrage an die JSP weiterleiten

        request.getRequestDispatcher("/WEB-INF/userEinstellungen.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
  // Formulareingaben auslesen        
        String username  = request.getParameter("signup_username");
        String old_password = request.getParameter("_password1");
        String password1 = request.getParameter("signup_password1");
        String password2 = request.getParameter("signup_password2");
        String email     = request.getParameter("email");
        String color     = request.getParameter("color");
        String gruppe    = request.getParameter("gruppe");
        
        // Eingaben prüfen
        User user = new User(username, password1, email, color, gruppe);
        List<String> errors = this.validationBean.validate(user);
        this.validationBean.validate(user.getPassword(), errors);
        
        if (password1 != null && password2 != null && !password1.equals(password2)) {
            errors.add("Die beiden Passwörter stimmen nicht überein.");
        }
        
        // Benutzer anpassen
        if (errors.isEmpty()) {
               this.userBean.update(user);
        }
        
        // Weiter zur nächsten Seite
        if (errors.isEmpty()) {
            // Keine Fehler: Startseite aufrufen
            response.sendRedirect(WebUtils.appUrl(request, "/app/kuehlschrank"));
        } else {
            // Fehler: Formuler erneut anzeigen
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);
            
            HttpSession session = request.getSession();
            session.setAttribute("signup_form", formValues);
            
            response.sendRedirect(request.getRequestURI());
                }
    }  
}
