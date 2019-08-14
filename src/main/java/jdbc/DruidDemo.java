package jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidDemo {

    @Test
    public void getDruidComboPool() {
        System.out.println(DruidDemo.class.getClassLoader().getResource("druid.properties"));

        Properties properties = new Properties();

        try {
            properties.load(DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //利用工具类测试Druid数据库连接池

    @Test
    public void setDruidSql() {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "INSERT INTO `mydb_test`.`student` (`id`, `name`, `chinese`, `english`, `math`) VALUES (null, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "阿萨德");
            ps.setInt(2, 89);
            ps.setInt(3, 90);
            ps.setInt(4, 78);
            int count = ps.executeUpdate();
            System.out.println("count ===" + count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(ps, connection);
        }
    }
}
