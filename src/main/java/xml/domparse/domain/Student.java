package xml.domparse.domain;

public class Student {
    String name;
    String idcard;
    String location;
    String examid;
    double grade;

    public Student() {

    }

    public Student(String name, String idcard, String location, String examid, int grade) {
        this.name = name;
        this.idcard = idcard;
        this.location = location;
        this.examid = examid;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", location='" + location + '\'' +
                ", examid='" + examid + '\'' +
                ", grade=" + grade +
                '}';
    }
}
