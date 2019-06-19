package xml.domparse.controller;

import xml.domparse.dao.StudentDao;
import xml.domparse.domain.Student;
import xml.domparse.utils.GlobalVar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PageController {
    private static StudentDao studentDao = new StudentDao();
    private static String filename =  GlobalVar.FILENAME;

    public static void main(String[] args) {
        System.out.println("添加学生(a)  删除学生(b)  查找学生(c)");
        System.out.println("请输入操作类型：");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String type = null;
        try {
            type = bufferedReader.readLine();

            if ("a".equals(type)) {
                System.out.println("请输入学生姓名：");
                String name = bufferedReader.readLine();

                System.out.println("请输入学生准考证号：");
                String examid = bufferedReader.readLine();

                System.out.println("请输入学生身份证号：");
                String idcard = bufferedReader.readLine();

                System.out.println("请输入学生所在地：");
                String location = bufferedReader.readLine();

                System.out.println("请输入学生成绩：");
                String grade = bufferedReader.readLine();

                Student student = new Student();
                student.setLocation(location);
                student.setIdcard(idcard);
                student.setName(name);
                student.setExamid(examid);
                student.setGrade(Double.parseDouble(grade));

                studentDao.add(student);
                System.out.println("添加成功!!!");

            } else if ("b".equals(type)) {
                System.out.println("请输入学生姓名：");
                String name = bufferedReader.readLine();
                try {
                    studentDao.delete(name, filename);
                    System.out.println("删除成功!!!");
                } catch (StudentDao.StudentNotFoundException e) {
                    System.out.println("要删除的学生不存在!!!");
                }
            } else if ("c".equals(type)) {
                System.out.println("请输入学生准考证号：");
                String examid = bufferedReader.readLine();
                Student ss = studentDao.find(examid);
                System.out.println("查询成功");
                System.out.println(ss.toString());
            } else {
                System.out.println("系统不支持你的操作");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
