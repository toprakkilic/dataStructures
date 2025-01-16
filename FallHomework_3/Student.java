public class Student implements Comparable<Student>{

    public String name;
    public String surname;
    public int id;
    public LinkedList<Course> courses = new LinkedList<>();
    public double average;

    public Student(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public void addCourse(String course, double grade) {
        if (grade <0 || grade > 100){
            throw new IllegalArgumentException("Öğrencinin adlığı not 0 ile 100 arasında olmalı");
        }else{
            Course newCourse = new Course(course, grade);
            this.courses.addToFront(newCourse);
            this.average = calculateAverage();
        }
    }
    public double calculateAverage() {
        if (courses.isEmpty()) {
            return 0;
        }
        double toplam = 0;
        Node<Course> iterator = courses.getHead();
        int counter = 0;
        while (iterator != null) {
            toplam += iterator.value.getGrade();
            counter++;
            iterator = iterator.next;
        }
        return toplam / counter;
    }



    @Override
    public int compareTo(Student obj) {
        return Integer.compare(this.id, obj.id);
    }

    @Override
    public String toString() {
        StringBuilder coursesInfo = new StringBuilder();
        Node<Course> iterator = courses.getHead();
        while (iterator != null) {
            coursesInfo.append("    ").append(iterator.value.getName())
                    .append(": ").append(iterator.value.getGrade())
                    .append("\n");
            iterator = iterator.next;
        }

        return "Öğrenci{" +
                "\n İsim ='" + name + '\'' +
                "\n Soyisim ='" + surname + '\'' +
                "\n Numara= " + id +
                "\n Genel Ortalama= " + String.format("%.2f", average) +
                "\n Dersler= \n" + coursesInfo +
                '}';
    }



}
