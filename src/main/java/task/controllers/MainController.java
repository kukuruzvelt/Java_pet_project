package task.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import task.models.dao.UserDAO;
import task.models.entity.User;

@Component
@org.springframework.stereotype.Controller
public class MainController {

//    private Map<String, Command> commands = new HashMap<>();
//
//    public void init(ServletConfig servletConfig) {
//        servletConfig.getServletContext().setAttribute("loggedUsersID", new HashSet<Integer>());
//        commands.put("logout", new LogOutCommand());
//        commands.put("login", new LoginCommand());
//        commands.put("register", new RegisterCommand());
//        commands.put("catalog", new GetCatalogCommand());
//        commands.put("staff_list", new GetMasterListCommand());
//        commands.put("request", new CreateRequestCommand());
//        commands.put("user/payment", new PaymentCommand());
//        commands.put("user/request", new CreateRequestCommand());
//    }

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/test")
    public String listStudent(Model model) {
        //model.addAttribute("students", userDAO.getUsersByRole("USER"));
        return "list";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/register")
    public String createStudent(@ModelAttribute("user") User user) {
        return "register";
    }

    @PostMapping("/register")
    public String create(Model model, @ModelAttribute("user") User user) {
        try {
            userDAO.registerUser(user);
            model.addAttribute("message", "Success");
            return "main";
        } catch (ConstraintViolationException e) {
            model.addAttribute("error", "This email is already taken");
        }catch (IllegalStateException e){
            model.addAttribute("error", "Fill in all the fields");
        }
        return "register";
    }

//    private final StudentDAO studentDAO;
//
//    public Controller(StudentDAO studentDAO) {
//        this.studentDAO = studentDAO;
//    }
//
//    @GetMapping("/main")
//    public String main() {
//        return "main";
//    }
//
//    @GetMapping("/list")
//    public String listStudent(Model model) {
//        model.addAttribute("students", studentDAO.getAll());
//        return "list";
//    }
//
//    @GetMapping("/get")
//    public String getStudent(@ModelAttribute("student") Student student, Model model) {
//        return "getStudent";
//    }
//
//    @PostMapping("/get")
//    public String get(@ModelAttribute("student") Student student, Model model) {
//        model.addAttribute("students", studentDAO.getStudent(student));
//        return "list";
//    }
//
//
//
//    @GetMapping("/delete")
//    public String deleteStudent(@ModelAttribute("student") Student student) {
//        return "delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("student") Student student) {
//        studentDAO.deleteStudent(student);
//        return "main";
//    }
//
//    @GetMapping("/update")
//    public String updateStudent(@ModelAttribute("student") Student student) {
//        return "update";
//    }
//
//    @PostMapping("/update")
//    public String update(@ModelAttribute("student") Student student) {
//        studentDAO.updateStudent(student);
//        return "main";
//    }

}
