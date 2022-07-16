package task.models.dao;

import task.models.entity.enums.REQUEST_STATUS;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class RequestDAO {
    public static ArrayList<String> getTimeslots() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection connection = ConnectionPool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select time from timeslots");

            while (resultSet.next()) {
                result.add(resultSet.getString("time"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<String> getFreeTimeslots(int master_id, Date d) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String date = formater.format(d);
        ArrayList<String> takenTimeslots = new ArrayList<>();
        ArrayList<String> timeslots = RequestDAO.getTimeslots();
        ArrayList<String> result = null;


        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement("select time from request where master_id = ? " +
                    "and date = ?");
            statement.setInt(1, master_id);
            statement.setString(2, date);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                takenTimeslots.add(resultSet.getString("time"));
            }

            result = (ArrayList<String>) timeslots.clone();

            timeslots.stream().filter(takenTimeslots::contains).forEach(result::remove);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void createRequest(int master_id, int user_id, int service_id, Date date, String time){
        REQUEST_STATUS defaultStatus = REQUEST_STATUS.IN_PROGRESS;
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into request values (default, ?,?,?,?,?,?)");
            statement.setString(1, formater.format(date));
            statement.setString(2, time);
            statement.setInt(3, user_id);
            statement.setInt(4, master_id);
            statement.setInt(5, service_id);
            statement.setString(6, defaultStatus.toString());

            statement.execute();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        RequestDAO.createRequest(4, 2, 1, new Date(
                new GregorianCalendar(2022, 3, 18).getTimeInMillis()), "15:30:00");
    }
}
