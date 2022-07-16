//package task.Command;
//
//import org.itstep.model.dao.ServiceDAO;
//import org.itstep.model.dao.UserDAO;
//import org.itstep.model.entity.Pagination;
//import org.itstep.model.entity.Service;
//import org.itstep.model.entity.User;
//import org.itstep.model.entity.enums.ROLE;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//
//public class GetCatalogCommand implements Command {
//    private final static int PAGE_SIZE = 1;
//
//    @Override
//    public String execute(HttpServletRequest request) {
//        ArrayList<User> masters = UserDAO.getUsersByRole(ROLE.MASTER);
//        masters.add(0, new User.UserBuilder().withName("Выберете мастера").withSurname("").build());
//        ArrayList<Service> services;
//        int currentPage;
//        int master_id;
//
//        try {
//
//            if (request.getAttribute("m_id") != null) {
//                master_id = (Integer) request.getAttribute("m_id");
//            } else master_id = Integer.parseInt(request.getParameter("master_id"));
//
//            if (master_id == 0) {
//                throw new NumberFormatException();
//            }
//
//            User chosenMaster = UserDAO.getUser(master_id).get();
//
//            masters.remove(chosenMaster);
//            masters.add(0, chosenMaster);
//
//            services = ServiceDAO.getServicesForMaster(master_id);
//        } catch (NumberFormatException e) {
//            services = ServiceDAO.getServices();
//        }
//
//        if (request.getAttribute("page") != null) {
//            currentPage = (Integer) request.getAttribute("page");
//        } else {
//            currentPage = 0;
//        }
//
//        int passed_elements = currentPage * PAGE_SIZE;
//        ArrayList<Service> final_services = new ArrayList<>();
//        for (int i = passed_elements; i < passed_elements + PAGE_SIZE; i++) {
//            final_services.add(services.get(i));
//        }
//
//        request.setAttribute("services", final_services);
//        request.setAttribute("masters", masters);
//
//        Pagination.setPagination(request, services.size(), PAGE_SIZE, currentPage, request.getContextPath()+"/catalog");
//
//        return "catalog.jsp";
//    }
//}
