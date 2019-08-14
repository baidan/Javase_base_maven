package jdbc;

public class Stuent {
    Integer id;
    String name;
    Integer chinses;
    Integer english;
    Integer math;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChinses() {
        return chinses;
    }

    public void setChinses(Integer chinses) {
        this.chinses = chinses;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    @Override
    public String toString() {
        return "Stuent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chinses=" + chinses +
                ", english=" + english +
                ", math=" + math +
                '}';
    }
}
