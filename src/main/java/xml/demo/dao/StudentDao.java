package xml.demo.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import xml.demo.domain.Student;
import xml.demo.utils.XMLUtils;

import java.util.List;

public class StudentDao {
    private static String filename = "src/main/java/xml/exam.xml";

    //需要自己处理异常
    public void add(Student s) {
        try {
            Document document = XMLUtils.getDocument(filename);

            //创建出封装一级标签  学生信息
            Element student_tag = document.createElement("student");
            student_tag.setAttribute("idcard", s.getIdcard());
            student_tag.setAttribute("examid", s.getExamid());

            //创建用于封装子标签  学生姓名，所在地和成绩的标签
            Element name = document.createElement("name");
            Element location = document.createElement("location");
            Element grade = document.createElement("grade");
            name.setTextContent(s.getName());
            location.setTextContent(s.getLocation());
            grade.setTextContent(s.getGrade() + "");

            //需要建立标签和子标签的联系
            student_tag.appendChild(name);
            student_tag.appendChild(location);
            student_tag.appendChild(grade);

            //把封装的的信息学生标签，挂到文档上
            document.getElementsByTagName("exam").item(0).appendChild(student_tag);

            //更新到xml文档
            XMLUtils.write2XML(document, filename);

        } catch (Exception e) {
            throw new RuntimeException(e); //对异常进行转型，需要抛出运行时异常
        }
    }

    public Student find(String examid) {
        try {
            Document document = XMLUtils.getDocument(filename);
            NodeList nodeList = document.getElementsByTagName("student");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element student_tag = (Element) nodeList.item(i);
                if (student_tag.getAttribute("examid").equals(examid)) {
                    //说明找到了传入examid 匹配的学生
                    Student s = new Student();
                    s.setExamid(examid);
                    s.setIdcard(student_tag.getAttribute("idcard"));
                    s.setName(student_tag.getElementsByTagName("name").item(0).getTextContent());
                    s.setLocation(student_tag.getElementsByTagName("location").item(0).getTextContent());
                    s.setGrade(Double.parseDouble(student_tag.getElementsByTagName("grade").item(0).getTextContent()));
                    return s;
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void delete(String name) throws StudentNotFoundException { //delete
        try {
            Document document = XMLUtils.getDocument(filename);
            NodeList list = document.getElementsByTagName("name");
            for (int i = 0; i < list.getLength(); i++) {
                if (list.item(i).getTextContent().equals(name)) {
                    list.item(i).getParentNode().getParentNode().removeChild(list.item(i).getParentNode());
                    return;
                }
            }

            throw new StudentNotFoundException(name + "不存在！");

        } catch (StudentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class StudentNotFoundException extends Exception {
        public StudentNotFoundException(Object p0) {

        }
    }
}
