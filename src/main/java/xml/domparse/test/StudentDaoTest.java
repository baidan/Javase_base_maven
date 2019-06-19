package xml.domparse.test;

import org.junit.Test;
import xml.domparse.dao.StudentDao;
import xml.domparse.domain.Student;
import xml.domparse.utils.GlobalVar;

public class StudentDaoTest {
    private StudentDao dao = new StudentDao();
    private static String filename = GlobalVar.FILENAME;
    @Test
    public void testAdd() {
        Student s = new Student();
        s.setExamid("121");
        s.setGrade(89);
        s.setName("sdaf");
        s.setIdcard("234234");
        s.setLocation("撒大声地");
        dao.add(s);
    }

    @Test
    public void testDelete() throws StudentDao.StudentNotFoundException {
        dao.delete("sdaf",filename);
    }

    @Test
    public void  testFind(){
        Student student = dao.find("1221");
        System.out.println(student.toString());
    }
}
