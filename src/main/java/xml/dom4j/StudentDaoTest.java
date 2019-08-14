package xml.dom4j;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import xml.domparse.dao.StudentDao;
import xml.domparse.utils.GlobalVar;

import java.io.*;

public class StudentDaoTest {
    private static String filename = GlobalVar.FILENAME;

    @Test
    public void testAdd() {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(filename));
            Element student = document.getRootElement().element("student");
            student.addElement("hobys").setText("ssdf");
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(filename)));
            writer.write(document);
            writer.close();
        } catch (Exception e) {
          throw  new RuntimeException(e);
        }
    }


    @Test
    public void testDelete() throws StudentDao.StudentNotFoundException {
    }

    @Test
    public void testFind() {
    }
}
