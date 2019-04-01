package dhbwka.wwi.fridgeshare.web;

import dhbwka.wwi.fridgeshare.common.ejb.ProduktBean;
import dhbwka.wwi.fridgeshare.common.ejb.UserBean;
import dhbwka.wwi.fridgeshare.common.jpa.User;
import dhbwka.wwi.fridgeshare.common.web.WebUtils;
import dhbwka.wwi.fridgeshare.email.EmailService;
import dhbwka.wwi.fridgeshare.jpa.Produkt;
import dhbwka.wwi.fridgeshare.jpa.ProduktKategorie;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Startseite: Zeigt eine Übersicht der vorhandenen Produkte in der Einkaufsliste
 */
@WebServlet(urlPatterns="/app/einkaufsliste")
public class EinkaufslisteServlet extends HttpServlet {
    
    public static final String URL = "/app/einkaufsliste";
    
    @EJB
    UserBean userBean;
    
    @EJB
    ProduktBean produktBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        request.setAttribute("ProduktKategorie", ProduktKategorie.values());
        
       // Vorhandene Produkte einlesen und im Request Context ablegen
       List<Produkt> alleProdukte = this.produktBean.findAllProducts("E");
       request.setAttribute("alleProdukte", alleProdukte);
       
       User user = this.userBean.getCurrentUser();
       request.setAttribute("user", user);
       String emailButtonVisibility = "hidden";
       request.setAttribute("Email", emailButtonVisibility);
       
        
        // Anfrage an die kuehlschrank.jsp weiterleiten
        request.getRequestDispatcher("/WEB-INF/kuehlschrank.jsp").forward(request, response);
    }
    
        @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        User user = this.userBean.getCurrentUser();

       String action = request.getParameter("action");
       Long id = Long.parseLong(request.getParameter("idOfProduct"));
       Produkt produkt = this.produktBean.findById(id);
       if ("delete".equals(action)) {
            this.produktBean.deleteProdukt(produkt);
     } else if ("change".equals(action)) {
         this.produktBean.changeKategorie(produkt);
    } else if ("email".equals(action)){
            try {
                
                EmailService.sendEmailTo(user.getEmail());
            } catch (MessagingException ex) {
                Logger.getLogger(EinkaufslisteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
      response.sendRedirect(WebUtils.appUrl(request, EinkaufslisteServlet.URL));     

        
    }
}
