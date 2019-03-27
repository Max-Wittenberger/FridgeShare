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
        String action = request.getParameter("action");

  // Formulareingaben auslesen        
        String username  = request.getParameter("signup_username");
        String old_password = request.getParameter("old_password");
        String new_password1 = request.getParameter("new_password1");
        String new_password2 = request.getParameter("new_password2");
        String email        = request.getParameter("email");
        String color        = request.getParameter("color");
        String gruppe       = request.getParameter("gruppe");
        
        User user = this.userBean.getCurrentUser();
        user.setColor(color);
        user.setEmail(email);
        userBean.update(user);
        
        //Versuch von Passwort ändern
    //    List<String> errors = this.validationBean.validate(user);
     //   this.validationBean.validate(user.getPassword(), errors);
        
     //    if (new_password1 != null && new_password2 != null && !new_password1.equals(new_password2)) {
      //      errors.add("Die beiden Passwörter stimmen nicht überein.");
      //  }
         
           // Neuen Benutzer anlegen
    //    if (errors.isEmpty()) {
    //        try {
     //             userBean.changePassword(user, old_password, new_password2);
      //      } catch (UserBean.InvalidCredentialsException ex) {
      //         errors.add(ex.getMessage());
     //       }
     //   }
      
        
      //  if ("gruppe_hinzu".equals(action)) {
      //      this.userBean.addToGruppen(gruppe);
      //  }else if("speichern".equals(action)){
        // Benutzer anpassen
       //        this.userBean.update(currentUser);
        //    };
        
        // Weiter zur nächsten Seite
            // Keine Fehler: Startseite aufrufen
    //        response.sendRedirect(WebUtils.appUrl(request, "/app/kuehlschrank"));
            
            // Weiter zur nächsten Seite
  //      if (errors.isEmpty()) {
            // Keine Fehler: Startseite aufrufen
   //         request.login(username, new_password1);
   //         response.sendRedirect(WebUtils.appUrl(request, "/app/kuehlschrank"));
   //     } else {
   //         // Fehler: Formuler erneut anzeigen
   //         FormValues formValues = new FormValues();
   //         formValues.setValues(request.getParameterMap());
   //         formValues.setErrors(errors);
            
   //         HttpSession session = request.getSession();
    //        session.setAttribute("signup_form", formValues);
            
      //      response.sendRedirect(WebUtils.appUrl(request, "/app/user"));
     //   }
    }  
}
