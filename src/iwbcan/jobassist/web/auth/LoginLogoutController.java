package iwbcan.jobassist.web.auth;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: alexpilipenko
 * Date: 2/20/12
 * Time: 1:37 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/auth")
public class LoginLogoutController {
    private Logger logger = Logger.getLogger(LoginLogoutController.class);

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value="error", required = false) boolean error, HttpServletRequest request, ModelMap model) {
        logger.debug("Inside Login method.");

        if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return "redirect:/common";
        }

        if(error==true) {
            model.put("error", "Username or password is invalid.");
        }
        else {
            model.put("error", "");
        }

        return "auth/loginpage";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String deniedPage() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetailsService) {
            UserDetailsService user = (UserDetailsService) principal;
        }

        logger.debug("Denied page is accessed.");

        return "auth/deniedpage";
    }

}