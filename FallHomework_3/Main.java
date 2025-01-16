import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        BinarySearchTree<Student> studentTree = new BinarySearchTree<>();
        //menü
        Scanner scanner = new Scanner(System.in);
        readStudentsFromFile("students.txt", studentTree);
        System.out.println("---Merhaba Öğrenci Ssistemine Hoş Geldiniz! ---");
        System.out.println("--- Programdan Çıkmanız İçin Menüde 0 Giriniz ---");
        while(true) {
            System.out.println("\n1) ---Öğrencileri Numaralarına Göre Sıralı Bir Şekilde Listeleme---");
            System.out.println("2) ---Öğrencileri Genel Ortalamalarına Göre Sıralanmış Şekilde Görüntüleme---");
            System.out.println("3) ---Numarası Verilen Öğrenciyi Silme---");
            System.out.println("4) ---Bilgileri Girilen Öğrenciyi Ekleme---");
            System.out.println("5) ---Öğrenci Sayısını Bulup Öğrencileri Görüntülemek---");
            System.out.println("6) ---Girdiğiniz Dersi Alan Öğrencilerin Çift Yönlü Grafı----");
            int secim = scanner.nextInt();
            switch (secim) {
                case 0:
                    System.out.println("---Çıkış Yapılıyor----");
                    break;
                    case 1:
                        studentTree.inorder();
                        break;
                    case 2:
                        studentTree.transferToTreeByAverage();
                        break;
                    case 3:
                        deleteStudent(studentTree);
                        break;
                    case 4:
                        addStudent(studentTree);
                        break;
                    case 5:
                        System.out.println("---Öğrenci Sayısı = "+studentTree.countStudents()+ "--- \n");
                        studentTree.inorder();
                        break;
                    case 6:
                        System.out.println("---Grafını Göstermek İstediğiniz Dersin Adını Giriniz---\n");
                        String dersadi = scanner.next();
                        createStudentGraph(dersadi, studentTree);
                        break;
                default:
                    System.out.println("---Geçersiz Bir Seçim Girdiniz---");
            }
        }
    }

    public static void addStudent(BinarySearchTree<Student> studentTree) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Ekleyeceğiniz Öğrencinin Numarasını Giriniz---\n");
        int studentNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("---Ekleyeceğiniz Öğrencinin İsmini Giriniz---\n");
        String name = scanner.nextLine();
        System.out.println("---Ekleyeceğiniz Öğrencinin Soyismini Giriniz---\n");
        String surname = scanner.nextLine();
        Student student = new Student(name,surname, studentNum);
        while(true){
            System.out.println("---Ders Adı Giriniz--- \n");
            String ders = scanner.nextLine();
            if (ders.compareToIgnoreCase("exit") == 0){
                break;
            }else{
                System.out.println("---Ders Notunu Giriniz---\n");
                double dersNotu = scanner.nextDouble();
                student.addCourse(ders,dersNotu);
                scanner.nextLine();
            }
        }
        studentTree.insert(student);
    }

    public static void deleteStudent(BinarySearchTree<Student> studentTree) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n ---Silmek İstediğiniz Öğrencinin Numarasını Giriniz---\n");
        int studentNum = scanner.nextInt();

        studentTree.delete(new Student("", "", studentNum));
        //zaten öğrenciler numaralarına göre karşılaştırıldığı için numarası aynı olan yeni bir öğrenci oluşturur
        //ve karşılaştırıp siler
    }

    private static void readStudentsFromFile(String filePath, BinarySearchTree<Student> tree) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String surname = parts[2];

                Student student = new Student(name, surname, id);


                for (int i = 3; i < parts.length; i += 2) {
                    String course = parts[i];
                    double grade = Double.parseDouble(parts[i + 1]);
                    student.addCourse(course, grade);
                }

                tree.insert(student);
            }
        } catch (IOException e) {
            System.out.println("---Dosya Okuma Sırasında Bir Hata Oluştu--- " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ağaç Ekleme Sırasında Bir Hata Oluştu--- " + e.getMessage());
        }
    }


    public static void createStudentGraph(String courseName, BinarySearchTree<Student> studentTree) throws Exception {
        ArrayList<Student> studentList;
        studentList = studentTree.toArrayList(); //studenttreedeki öğrencileri arraylist haline getirip bu fonksiyona çeker.
        ArrayList<Student> selected = new ArrayList<>();
        Graph<String> studentGraph = new Graph<>();

        for (Student student : studentList) {
            Node<Course> courseNode = student.courses.getHead();
            while (courseNode != null) {
                if (courseNode.value.getName().equalsIgnoreCase(courseName)) { //girilen ders adına sahip olan öğrencileri ayırır
                    selected.add(student);
                    break;
                }
                courseNode = courseNode.next;
            }
        }
        for (Student student : selected) {
            studentGraph.addVertex(student.name); //secilen ogrencileri vertex yapar
        }

        for (int i = 0; i < selected.size(); i++) {
            for (int j = i + 1; j < selected.size(); j++) {
                Student student1 = selected.get(i);
                Student student2 = selected.get(j);

                studentGraph.addEdge(student1.name, student2.name);
                studentGraph.addEdge(student2.name, student1.name);
            }
        } // dersi aynı olan ogrencileri edge e ekler

        studentGraph.displayGraph();


    }


    

}