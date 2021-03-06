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
 * Startseite: Zeigt eine Übersicht der vorhandenen Produkte im Kühlschrank
 */
@WebServlet(urlPatterns="/app/kuehlschrank")
public class KuehlschrankServlet extends HttpServlet {
    
    public static final String URL = "/app/kuehlschrank";
    
    @EJB
    UserBean userBean;
    
    @EJB
    ProduktBean produktBean;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        request.setAttribute("ProduktKategorie", ProduktKategorie.values());
        
        // Vorhandene Produkte einlesen und im Request Context ablegen
       List<Produkt> alleProdukte = this.produktBean.findAllProducts("K");
       request.setAttribute("alleProdukte", alleProdukte);
       
       String emailButtonVisibility = "";
       request.setAttribute("Email", emailButtonVisibility);

       
       User user = this.userBean.getCurrentUser();
       request.setAttribute("user", user);
       
        
        // Anfrage an die kuehlschrank.jsp weiterleiten
        request.getRequestDispatcher("/WEB-INF/kuehlschrank.jsp").forward(request, response);
    }
    
        @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

       String action = request.getParameter("action");
       
    if("email".equals(action)){
            try {
                EmailService.sendEmailTo(userBean.getCurrentUser().getEmail());
            } catch (MessagingException ex) {
                Logger.getLogger(KuehlschrankServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }else{
       Long id = Long.parseLong(request.getParameter("idOfProduct"));
       
       Produkt produkt = this.produktBean.findById(id);
       if ("delete".equals(action)) {
            this.produktBean.deleteProdukt(produkt);
     } else if ("change".equals(action)) {
         this.produktBean.changeKategorie(produkt);
     } 
    }
      response.sendRedirect(WebUtils.appUrl(request, KuehlschrankServlet.URL));     

        
    }
}
