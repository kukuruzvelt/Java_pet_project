package task.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import task.models.entity.MasterService;
import task.models.entity.Service;
import task.models.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ServiceDAO {

    @Autowired
    private static SessionFactory sessionFactory;

//    public static ArrayList<Service> getServices(){
//        ArrayList<Service> result = new ArrayList<>();
//        try {
//            Connection connection = ConnectionPool.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select id, name, price from service");
//
//            while (resultSet.next()) {
//                result.add(new Service.ServiceBuilder().withId(resultSet.getInt("id"))
//                        .withName(resultSet.getString("name")).withPrice(resultSet.getInt("price"))
//                        .build());
//            }
//
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
    public static Optional<Service> getService(int id){
        Session session = sessionFactory.openSession();
        Optional<Service> service = Optional.of(session.get(Service.class, id));
        session.close();
        return service;
    }

    public static ArrayList<Service> getServicesForMaster(User user){
        int master_id = user.getId();
        ArrayList<Service> result = new ArrayList<>();
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<MasterService> criteriaQuery = criteriaBuilder.createQuery(MasterService.class);
        Root<MasterService> root = criteriaQuery.from(MasterService.class);
        //criteriaQuery.select(root).where(root.get("master_id").in(master_id));
        //todo джойнить сервисы по ид(@ManyToMany)

        //Join<MasterService, Service> join = root.join();

//        Query query = session.createQuery(criteriaQuery);
//        List<Service> userList = query.getResultList();
//        result= (ArrayList<User>) userList;
        session.close();

//        try {
//            Connection connection = ConnectionPool.getConnection();
//            PreparedStatement statement = connection.prepareStatement("select service_id from master_service " +
//                    "where master_id = ?");
//            statement.setInt(1, master_id);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                result.add(ServiceDAO.getService(resultSet.getInt("service_id")));
//            }
//
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return result;
    }


}
