//package task.Command;
//
//import org.itstep.model.dao.RequestDAO;
//import org.itstep.model.dao.ServiceDAO;
//import org.itstep.model.dao.UserDAO;
//import org.itstep.model.entity.User;
//import org.itstep.model.entity.enums.ROLE;
//
//import javax.servlet.http.HttpServletRequest;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class CreateRequestCommand implements Command {
//    @Override
//    public String execute(HttpServletRequest request) {
//        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//        //todo снятие денег со счета, и выдача ошибки если денег не хватает, показывать стоимость услуги при ее выборе
//        if (request.getParameter("master_id") != null) {
//            int master_id = Integer.parseInt(request.getParameter("master_id"));
//            int user_id = (Integer) request.getSession().getAttribute("id");
//            int service_id = Integer.parseInt(request.getParameter("service_id"));
//            Date date = null;
//            try {
//                date = formater.parse(request.getParameter("date"));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            String time = request.getParameter("time");
//
//            RequestDAO.createRequest(master_id, user_id, service_id, date, time);
//            request.setAttribute("message", "Запись прошла успешно");
//            return "/user/userbasis";
//        } else if (request.getParameter("service_id") != null || request.getParameter("date") != null ) {
//            ArrayList<User> masters = UserDAO.getUsersByRole(ROLE.MASTER);
//            HashMap<User, ArrayList<String>> mastersAndTimeslots = new HashMap<>();
//            long milllisInDay = 86400000;
//            Calendar calendar = new GregorianCalendar();
//            Date min = new Date(calendar.getTimeInMillis());
//            Date max = new Date(calendar.getTimeInMillis() + 30 * milllisInDay);
//            Date chosenDate = null;
//
//            if (request.getParameter("date") != null) {
//                try {
//                    chosenDate = formater.parse(request.getParameter("date"));
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                chosenDate = min;
//            }
//
//            for (User master : masters) {
//                mastersAndTimeslots.put(master, RequestDAO.getFreeTimeslots(master.getId(), chosenDate));
//            }
//
//            request.setAttribute("service_id", request.getParameter("service_id"));
//            request.setAttribute("masters", masters);
//            request.setAttribute("mastersAndTimeslots", mastersAndTimeslots);
//            request.setAttribute("min", formater.format(min));
//            request.setAttribute("max", formater.format(max));
//            request.setAttribute("chosenDate", formater.format(chosenDate));
//
//            return "/WEB-INF/user/choose_time.jsp";
//        } else {
//            request.setAttribute("services", ServiceDAO.getServices());
//            return "/WEB-INF/user/choose_service.jsp";
//        }
//    }
//}
