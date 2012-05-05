package iwbcan.jobassist.web;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

import iwbcan.jobassist.dao.TestDAO;
import iwbcan.jobassist.domain.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by IntelliJ IDEA.
 * User: alp
 * Date: 2/17/12
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/")
public class HomepageController {
    private Logger logger = Logger.getLogger(HomepageController.class);

    @Autowired
    private TestDAO testDAO;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
        logger.info("Info message to be logged.");
        List<Test> testList = testDAO.getTestList();
        model.put("listTest", testList);

        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }


    /** #########################
     * Testing Security features.
     */


    @RequestMapping(value="/common", method = RequestMethod.GET)
    public String getCommonPage(HttpServletRequest request, Principal principal, ModelMap model) {
        logger.debug("Loading common page.");

        model.put("user", request.getUserPrincipal());

        return "auth_testing/commonpage";
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String getAdminPage() {
        logger.debug("Loading admin page.");

        return "auth_testing/adminpage";
    }

    @RequestMapping(value = "/annotated", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_SUPER')")
    public String getAnnotatedPage() {

        return "auth_testing/annotatedpage";
    }
}
