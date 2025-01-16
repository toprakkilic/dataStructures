public class Course implements Comparable<Course> {
    private double grade;
    private String name;

    public Course(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return this.grade;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Course o) {
        return Double.compare(this.grade, o.getGrade());
    }
    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

}
