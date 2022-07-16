//package task.Command;
//
//
//import task.models.entity.enums.ROLE;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.HashSet;
//
//class CommandUtility {
//    static void setUserRole(HttpServletRequest request,
//                            ROLE role, String name, int id) {
//        HttpSession session = request.getSession();
//        //ServletContext context = request.getServletContext();
//        session.setAttribute("id", id);
//        session.setAttribute("name", name);
//        session.setAttribute("role", role);
//    }
//
//    static boolean checkUserIsLogged(HttpServletRequest request, Integer id) {
//        HashSet<Integer> loggedUsers = (HashSet<Integer>) request.getSession().getServletContext()
//                .getAttribute("loggedUsersID");
//
//        if (loggedUsers.stream().anyMatch(id::equals)) {
//            return true;
//        }
//        loggedUsers.add(id);
//        request.getSession().getServletContext()
//                .setAttribute("loggedUsersID", loggedUsers);
//        return false;
//    }
//}
