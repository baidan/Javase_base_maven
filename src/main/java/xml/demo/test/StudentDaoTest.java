package xml.demo.test;

import org.junit.Test;
import xml.demo.dao.StudentDao;
import xml.demo.domain.Student;

public class StudentDaoTest {

    @Test
    public void testAdd(){
        StudentDao dao = new StudentDao();
        Student s = new Student();
        s.setExamid("121");
        s.setGrade(89);
        s.setName("sdaf");
        s.setIdcard("234234");
        s.setLocation("撒大声地");
        dao.add(s);
    }
}
