package cm.uma.iss.scolarite.beans;

import cm.uma.iss.scolarite.entities.RoleUtilisateur;
import cm.uma.iss.scolarite.services.IUtilisateurService;
import com.douwe.generic.dao.DataAccessException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ngnawen
 */
@ManagedBean
@SessionScoped
@Controller
public class LoginController implements Serializable {

    public static String username;//username
    private String userConnecter;//pour afficher le nom de celui qui est connecté
    ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
    private IUtilisateurService utilisateurService = (IUtilisateurService) ctx.getBean("IUtilisateurService");
    // ServiceUtilisateur serUser = (ServiceUtilisateur) ctx.getBean("IUtilisateurService");

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) throws DataAccessException {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // String name = user.getUsername();
        username = user.getUsername();
        model.addAttribute("Ngnawen", username);
        model.addAttribute("message", "Spring Security ");

        RoleUtilisateur connecteur;
        connecteur = utilisateurService.findUtilisateurByRole(username);
            System.out.println(""+connecteur.getRoleuser());
        if (connecteur.getRoleuser().equals("ROLE_ADMIN")) {
            System.out.println(""+connecteur.getRoleuser());
            return "pages/index";
        } else {
            return "pages/login";
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "pages/login";

    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {

        model.addAttribute("error", "true");
        return "pages/login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {

        return "pages/login";

    }

    public String getUserConnecter() {
        userConnecter = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return userConnecter;
    }

    public void setUserConnecter(String userConnecter) {
        this.userConnecter = userConnecter;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        LoginController.username = username;
    }


    public ApplicationContext getCtx() {
        return ctx;
    }

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public IUtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(IUtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

 
}
