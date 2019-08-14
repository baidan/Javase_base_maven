package jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class SpringJDBCTemp {

    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Test
    public void testSpringJBDCTemp() {
        //JDBCTemp 基本入门
        //需要传入数据源，不管通过哪种方式获取的数据源都可以。
        String sql = "UPDATE `mydb_test`.`student` SET  `math`='90' WHERE (`id`=?)";
        int count = template.update(sql, 7);
        System.out.println("count===" + count);
    }

    @Test
    public void testSpringJBDCTemp2() {
        //注意如果是map封装的，长度只能是1，所以封装1条记录
        String sql = "SELECT * from `mydb_test`.`student` WHERE (`id`=?)";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }

    @Test
    public void testSpringJBDCTemp3() {
        //如果是list集合，可以封装多条记录
        String sql = "SELECT * from `mydb_test`.`student`";
        List<Map<String, Object>> map = template.queryForList(sql);
        System.out.println(map);
    }

    @Test
    public void testSpringJBDCTemp4() {
        //转化成javaBean对象
        String sql = "SELECT * from `mydb_test`.`student`";
        List<Stuent> list = template.query(sql, new BeanPropertyRowMapper<Stuent>(Stuent.class));
        for(Stuent stuent : list){
            System.out.println(stuent);
        }
        System.out.println(list.toString());
    }


    @Test
    public void testSpringJBDCTemp5() {
        //
        String sql = "SELECT count(id) from `mydb_test`.`student`";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }


}
