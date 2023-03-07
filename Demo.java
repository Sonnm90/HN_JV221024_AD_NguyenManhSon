import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Student[] students = new Student[200];
        int size = 0, choice;
        Student student1 = new Student();
        boolean cont = true;

        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("****************HACKATHON-JAVA-BASIC-1-MENU***************");
            System.out.println();
            System.out.println("1. Nhập số sinh viên và nhập thông tin cho các sinh viên");
            System.out.println("2. In thông tin các sinh viên đang quản lý");
            System.out.println("3. Sắp xếp sinh viên theo thứ tự điểm tăng dần");
            System.out.println("4. Nhập và tìm kếm sinh viên theo tên");
            System.out.println("5. Thống kê số sinh viên nam, nữ đang quản lý");
            System.out.println("6. In ra thông tin các sinh viên xếp loại giỏi và trung bình");
            System.out.println("7. Thoát");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Nhập số sinh viên:");
                        size = sc.nextInt();
                        if (size > 200)
                            System.out.println("Độ dài yêu cầu nhỏ hơn 200!");
                    } while (size > 200);
                    for (int i = 0; i < size; i++) {
                        System.out.println("Nhap thong tin sinh vien thu " + (i + 1));
                        students[i] = new Student();
                        students[i].inputData();
                    }
                    break;
                case 2:
                    System.out.println("Thong tin các sinh viên:");
                    for (int i = 0; i < size; i++) {
                        students[i].display();
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = 0; i < size - 1; i++) {
                        for (int j = 1; j < size; j++) {
                            if (students[i].calAvgMark() > students[j].calAvgMark()) {
                                student1 = students[i];
                                students[i] = students[j];
                                students[j] = student1;
                            }
                        }
                    }
                    System.out.println("Thong tin các sinh viên:");
                    for (int i = 0; i < size; i++) {
                        students[i].display();
                    }
                    break;
                case 4:
                    System.out.println("Nhap vao tên SV ần tìm kiếm:");
                    String check = sc.nextLine();
                    for (int i = 0; i < size; i++) {
                        if (students[i].getStudentName().equals(check)) {
                            students[i].display();
                        }
                    }
                    break;
                case 5:
                    int countNam=0,countNu=0;
                    for (int i = 0; i < size; i++) {
                        if (students[i].getSex()=="Nam") {
                            countNam++;
                        } else {
                            countNu++;
                        }
                    }
                    System.out.println("So sinh vien Nam là: "+countNam);
                    System.out.println("So sinh vien Nữ là: "+countNu);
                    break;
                case 6:
                    System.out.println("Các sinh viên loại giỏi:");
                    for (int i = 0; i < size; i++) {
                        if (students[i].calAvgMark()>=8&& students[i].calAvgMark()<=9) {
                            students[i].display();
                        }
                    }
                    System.out.println("Các sinh viên loại khá:");

                    for (int i = 0; i < size; i++) {
                        if (students[i].calAvgMark()>=5&& students[i].calAvgMark()<=7) {
                            students[i].display();
                        }
                    }

                    break;
                case 7:

                    System.exit(0);


            }
        } while (cont);
    }
}
