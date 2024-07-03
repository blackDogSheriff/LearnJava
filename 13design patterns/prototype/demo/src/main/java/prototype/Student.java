package prototype;

public class Student {
    private int id;
    private String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Object clone() {
        Student std = new Student();
        std.id = id;
        std.name = name;
        std.score = score;
        return std;
    }
}
