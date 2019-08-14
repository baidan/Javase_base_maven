package jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0 Demo
 */
public class C3P0Demo {

    /**
     * 打印连接池对象
     */
    @Test
    public void getComboPooledPool() throws SQLException {
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 10; i++) {
            Connection cn = ds.getConnection();
            System.out.println(i+":"+cn);
        }

    }
}
