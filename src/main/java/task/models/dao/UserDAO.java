package task.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import task.models.entity.User;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> getUser(String email, String password) {
        Optional<User> user = Optional.empty();

//        try {
//            Connection connection = ConnectionPool.getConnection();
//            PreparedStatement statement = connection.prepareStatement("select id, role, money, rating, name, surname " +
//                    "from USER where email = ? and password = ?");
//            statement.setString(1, email);
//            statement.setString(2, password);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                user = Optional.of(new User.UserBuilder().withId(resultSet.getInt("id"))
//                        .withRole(ROLE.valueOf(resultSet.getString("role")))
//                        .withMoney(resultSet.getLong("money"))
//                        .withName(resultSet.getString("name"))
//                        .withSurname(resultSet.getString("surname"))
//                        .withRating(resultSet.getInt("rating")).build());
//            }
//
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return user;
    }

    public Optional<User> getUser(int id) {
        Session session = sessionFactory.openSession();
        Optional<User> user = Optional.empty();
        session.close();
        return Optional.of(session.get(User.class, id));
    }

    public Optional<User> getUser(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(root.get("email").in(email));

        Query query = session.createQuery(criteriaQuery);
        User user = (User) query.getSingleResult();

        session.close();
        return Optional.of(user);
    }

    public ArrayList<User> getUsersByRole(String role) {
        Session session = sessionFactory.openSession();
        ArrayList<User> result = new ArrayList<>();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root).where(root.get("role").in(role));

        Query query = session.createQuery(criteriaQuery);
        List<User> userList = query.getResultList();
        result= (ArrayList<User>) userList;
        session.close();

        return result;
    }

    public static ArrayList<User> getMastersForService(int service_id) {
        ArrayList<User> result = new ArrayList<>();
//        try {
//            Connection connection = ConnectionPool.getConnection();
//            PreparedStatement statement = connection.prepareStatement("select master_id from master_service " +
//                    "where service_id = ?");
//            statement.setInt(1, service_id);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                result.add(UserDAO.getUser(resultSet.getInt("master_id")).get());
//            }
//
//            statement.close();
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return result;
    }

    public void registerUser(User user) throws ConstraintViolationException, IllegalStateException {

        Session session = sessionFactory.openSession();

        if (user.getName()==null||user.getSurname()==null||user.getEmail()==null||user.getPassword()==null
        ||user.getName().equals("")||user.getSurname().equals("")||user.getEmail().equals("")||user.getPassword().equals("")){
            throw new IllegalStateException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setMoney(0);
        user.setRating(0);
        user.setRole_id(2);
        session.save(user);
        //

        session.close();
    }

    public static void setMoney(int user_id, long money) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement("update user set money = ? where id = ?");
            statement.setLong(1, money);
            statement.setInt(2, user_id);
            statement.execute();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
