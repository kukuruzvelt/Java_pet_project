//package task.Command;
//
//import org.itstep.model.dao.UserDAO;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class RegisterCommand implements Command{
//    @Override
//    public String execute(HttpServletRequest request) {
//        String email = request.getParameter("email");
//        String pass = request.getParameter("pass");
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        if (email == null || email.equals("") || pass == null || pass.equals("") ||
//        name == null || name.equals("") || surname == null || surname.equals("")) {
//            return "/register.jsp";
//        }
//
//        System.out.println(email);
//        System.out.println(pass);
//        System.out.println(name);
//        System.out.println(surname);
//        UserDAO.registerUser(name,surname,email,pass);
//
//        request.setAttribute("message", "Регистрация прошла успешно");
//        return "index.jsp";
//    }
//}
