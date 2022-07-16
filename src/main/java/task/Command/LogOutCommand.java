//package task.Command;
//
//import org.itstep.model.entity.enums.ROLE;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashSet;
//
//public class LogOutCommand implements Command {
//    @Override
//    public String execute(HttpServletRequest request) {
//
//        HashSet<Integer> loggedUsers = (HashSet<Integer>) request.getSession().getServletContext()
//                .getAttribute("loggedUsersID");
//
//        loggedUsers.remove(request.getSession().getAttribute("id"));
//        request.getSession().getServletContext()
//                .setAttribute("loggedUsersID", loggedUsers);
//
//        CommandUtility.setUserRole(request, ROLE.UNKNOWN, "Guest", 0);
//
//        return "redirect:/index.jsp";
//    }
//}
