//package task.Command;
//
//import org.itstep.model.dao.ServiceDAO;
//import org.itstep.model.dao.UserDAO;
//import org.itstep.model.entity.Service;
//import org.itstep.model.entity.SortByEntity;
//import org.itstep.model.entity.User;
//import org.itstep.model.entity.enums.ROLE;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class GetMasterListCommand implements Command {
//    @Override
//    public String execute(HttpServletRequest request) {
//        ArrayList<Service> services = ServiceDAO.getServices();
//        ArrayList<User> masters;
//        ArrayList<SortByEntity> sortBy = new ArrayList<>(Arrays.asList(
//                new SortByEntity("rating", "Рейтинг"), new SortByEntity("surname", "Фамилия")));
//        services.add(0, new Service.ServiceBuilder().withName("Выберете услугу").build());
//        try {
//            int service_id = Integer.parseInt(request.getParameter("service_id"));
//
//            if(service_id == 0){
//                throw new NumberFormatException();
//            }
//
//            Service chosenService = ServiceDAO.getService(service_id);
//            services.remove(chosenService);
//            services.add(0, chosenService);
//
//            masters = UserDAO.getMastersForService(service_id);
//        } catch (NumberFormatException e) {
//            masters = UserDAO.getUsersByRole(ROLE.MASTER);
//        }
//
//        String sort_by = request.getParameter("sort_by");
//        if (sort_by!=null && !sort_by.equals("")) {
//
//            SortByEntity chosenVariant = sortBy.stream().filter(i->i.getCallback().equals(sort_by)).findFirst().get();
//            sortBy.remove(chosenVariant);
//            sortBy.add(0, chosenVariant);
//
//            if(sort_by.equals("surname")){
//                masters.sort(new Comparator<User>() {
//                    @Override
//                    public int compare(User o1, User o2) {
//                        return o1.getSurname().compareTo(o2.getSurname());
//                    }
//                });
//            }
//            else if(sort_by.equals("rating")){
//                masters.sort(new Comparator<User>() {
//                    @Override
//                    public int compare(User o1, User o2) {
//                        return Integer.compare(o2.getRating(), o1.getRating());
//                    }
//                });
//            }
//
//        }
//
//        request.setAttribute("sortBy", sortBy);
//        request.setAttribute("masters", masters);
//        request.setAttribute("services", services);
//
//        return "staff_list.jsp";
//    }
//
//}
