package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCUtils {
    /**
     * 获取mysql连接对象
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            //mysql 5.0之前需要手动加载，之后不用写。
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///mydb_test", "root", "rootroot");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
