//package task.Command;
//
//import task.models.dao.UserDAO;
//import task.models.entity.enums.ROLE;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Optional;
//
//public class LoginCommand implements Command {
//
//    @Override
//    public String execute(HttpServletRequest request) {
//        String email = request.getParameter("email");
//        String pass = request.getParameter("pass");
//
//        Optional<User> user = UserDAO.getUser(email, pass);
//
//        if (email == null || email.equals("") || pass == null || pass.equals("")) {
//            return "/login.jsp";
//        }
//
//        if(user.equals(Optional.empty())){
//            request.setAttribute("error_message", "Такого пользователя нет");
//            return "/login.jsp";
//        }
//
//        //todo: check login with DB
//
//        if (CommandUtility.checkUserIsLogged(request, user.get().getId())) {
//            return "/WEB-INF/error.jsp";
//        }
//
//        ROLE role = user.get().getRole();
//
//        CommandUtility.setUserRole(request, role, user.get().getName(), user.get().getId());
//
//        if (role.equals(ROLE.ADMIN)) {
//            return "redirect:/admin/adminbasis";
//        } else if (role.equals(ROLE.USER)) {
//            return "redirect:/user/userbasis";
//        } else if (role.equals(ROLE.MASTER)) {
//            return "redirect:/master/masterbasis";
//        } else {
//            return "/login.jsp";
//        }
//    }
//
//
//
//}
