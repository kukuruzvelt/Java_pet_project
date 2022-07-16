//package task.Command;
//
//import org.itstep.model.dao.UserDAO;
//import org.itstep.model.entity.User;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class PaymentCommand implements Command {
//    @Override
//    public String execute(HttpServletRequest request) {
//        try {
//            long money = Long.parseLong(request.getParameter("money"));
//            if (money <= 0) {
//                request.setAttribute("error_message", "Сумма должна быть больше 0");
//                return "/user/pay";
//            }
//
//            User user = UserDAO.getUser((Integer) request.getSession().getAttribute("id")).get();
//            long currentMoney = user.getMoney();
//
//            if(currentMoney+money<0){
//                request.setAttribute("error_message", "Сумма на вашем счету не может превышать " + Long.MAX_VALUE);
//                return "/user/pay";
//            }
//
//            UserDAO.setMoney(user.getId(), currentMoney+money);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            request.setAttribute("error_message", "Сумма должна быть меньше " + Long.MAX_VALUE);
//            return "/user/pay";
//        }
//
//        request.setAttribute("message", "Оплата прошла успешно");
//        return "/user/userbasis";
//    }
//
//
//}
