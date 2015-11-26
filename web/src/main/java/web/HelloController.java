package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by semihokan on 05/10/15.
 */
@Controller
public class HelloController {

    @RequestMapping(value = {"/","/index"})
    public String home(ModelMap modelMap) {
        Date d = new Date();
        modelMap.addAttribute("date", d);
        return "home";
    }

    @RequestMapping("/free")
    public String free(ModelMap modelMap) {
        String message = "This is free space";
        modelMap.addAttribute("free", message);
        return "free";
    }

    @RequestMapping("/free/api")
    public String freeApi(ModelMap modelMap) {
        modelMap.addAttribute("message", "for only admin user");
        return "freeapi";
    }

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap) {
        Student student = new Student();
        modelMap.addAttribute("student", student);
        return "login";
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String show(@ModelAttribute Student student) {
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getLastname());
        return "home";
    }

    @RequestMapping(value = "/json")
    @ResponseBody
    public String json(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getLastname());
        System.out.println(student.getName());
        return "home";
    }

    @RequestMapping("/con")
    public String con() {
        return "content :: content";
    }

    @RequestMapping("/session")
    public String sessionInfo(HttpSession session) {
        System.out.println("Session ID:" + session.getId());
        return "redirect:/index";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login2";
    }

    @RequestMapping("/form")
    public String formPage() {
        return "form";
    }

    @RequestMapping("display")
    public String display(ModelMap model, HttpServletRequest request) {
        String user = request.getParameter("user");
        model.addAttribute("user", user);
        return "display";
    }

}
