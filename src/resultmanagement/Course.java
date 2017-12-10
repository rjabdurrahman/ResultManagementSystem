package resultmanagement;

public class Course{
    private int code;
    private String name;
    private int credit;
    private double gpa;

    public Course(int code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
}