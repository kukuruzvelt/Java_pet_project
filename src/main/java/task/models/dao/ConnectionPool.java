package task.models.dao;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static BasicDataSource ds = new BasicDataSource();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        InputStream is = null;
        try {
            is = ConnectionPool.class.getClassLoader().getResourceAsStream("database_info.properties");
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.setUrl(prop.getProperty("connection_url"));
        ds.setUsername(prop.getProperty("username"));
        ds.setPassword(prop.getProperty("password"));
        ds.setMinIdle(9);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private ConnectionPool() {
    }
}
