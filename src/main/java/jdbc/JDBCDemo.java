package jdbc;


import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
    }

    @Test
    public void testJDBCUpdate() {
        //省略===
    }

    @Test
    public void testJDBCQuery() {
        //获取连接资源
        Connection connection = JDBCUtils.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        if (connection != null) {
            //创建SQL语句
            String sql = "select * from student";
            try {
                //创建执行SQL的对象
                statement = connection.createStatement();
                //执行查询的SQL
                rs = statement.executeQuery(sql);
                //让游标向下一行并且返回值通知是否为最后一行，自己的理解：寻址后往下一行，寻址(0)为表头
               /* if (rs.next()) {
                    //获取第一行的值。两种方式：1传入索引(=索引按照顺序)，2或者字段名称
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int chinese = rs.getInt(3);
                    int english = rs.getInt(4);
                    int math = rs.getInt(5);
                    System.out.println(id + "---" + name + "---" + chinese + "---" + english + "---" + math);
                }*/

                //循环遍历所有,获取方式2
                /**
                 * 标记一下：这个地方有个误区，用while循环的时候，里面的参数re.next()
                 * 为什么不在外面用个参数boolean b = re.next()接收后
                 * while(b){} 这样处理，是因为while循环每次回来要执行的时候，你在外面执行的结果变量接收后值已经固定了
                 * 我们需要把执行返回布尔类型的语句放在while条件里面，这样每次
                 */

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int chinese = rs.getInt("chinese");
                    int english = rs.getInt("english");
                    int math = rs.getInt("math");
                    System.out.println(id + "---" + name + "---" + chinese + "---" + english + "---" + math);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

                //释放资源，按照先后顺序
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
