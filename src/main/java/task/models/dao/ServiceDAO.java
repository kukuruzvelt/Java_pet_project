//package task.models.dao;
//
//import org.itstep.model.entity.Service;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//public class ServiceDAO {
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
//    public static Service getService(int id){
//        Service service = null;
//        try {
//            Connection connection = ConnectionPool.getConnection();
//            PreparedStatement statement = connection.prepareStatement("select id, name, price from service where id = ?");
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                service = new Service.ServiceBuilder().withId(resultSet.getInt("id"))
//                        .withName(resultSet.getString("name")).withPrice(resultSet.getInt("price"))
//                        .build();
//            }
//
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return service;
//    }
//
//    public static ArrayList<Service> getServicesForMaster(int master_id){
//        ArrayList<Service> result = new ArrayList<>();
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
//
//        return result;
//    }
//
//
//}
