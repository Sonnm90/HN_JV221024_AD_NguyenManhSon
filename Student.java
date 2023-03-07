import java.time.Year;
import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String sex;
    private String phone;
    private String address;
    private float markHTML;
    private float markCSS;
    private float markJAVASCRIPT;
    private float avgMark;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, String sex, String phone, String address, float markHTML, float markCSS, float markJAVASCRIPT, float avgMark) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
        this.markHTML = markHTML;
        this.markCSS = markCSS;
        this.markJAVASCRIPT = markJAVASCRIPT;
        this.avgMark = avgMark;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentID(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMarkHTML() {
        return markHTML;
    }

    public void setMarkHTML(float markHTML) {
        this.markHTML = markHTML;
    }

    public float getMarkCSS() {
        return markCSS;
    }

    public void setMarkCSS(float markCSS) {
        this.markCSS = markCSS;
    }

    public float getMarkJAVASCRIPT() {
        return markJAVASCRIPT;
    }

    public void setMarkJAVASCRIPT(float markJAVASCRIPT) {
        this.markJAVASCRIPT = markJAVASCRIPT;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);

        //Nhap ID sinh vien
        boolean checkId = true;
        do {
            System.out.print("Nhap ma SV(bat dau bang RA): ");
            this.studentId = sc.nextLine();
            if (this.studentId.startsWith("RA")) {
                checkId = false;
            } else {
                System.out.println("Vui long nhap ma bat dau bang RA");
            }
        } while (checkId);

        //Nhap Name
        do {
            System.out.print("Nhap ten SV: ");
            this.studentName = sc.nextLine();
        } while (this.studentName.length() < 5 || this.studentName.length() > 50);

        //Nhap age
        do {
            System.out.print("Nhap tuoi (>=18, <100): ");
            while (!sc.hasNextInt()) {
                System.out.print("Vui long nhap thong tin hop le: ");
                sc.next();
            }
            this.age = sc.nextInt();
        } while (this.age < 18 || this.age > 100);

        //Nhap sex:
        do {
            System.out.print("Nhap gioi tinh (Nam/Nu): ");
            this.sex = sc.next();
        } while (!this.sex.equals("Nam") && !this.sex.equals("Nu"));

        //Nhap phone:
        do {
            System.out.print("Nhap sdt: ");
            while (!sc.hasNext("[0-9]+")) {
                System.out.print("Vui long chi nhap so: ");
            }
            this.phone = sc.next();
        } while (this.phone.length() != 10);

        //Nhap address
        sc.nextLine(); // consume newline character
        System.out.print("Nhap dia chi: ");
        while (!sc.hasNextLine()) {
            System.out.println("Vui long nhap day du thong tin.");
            System.out.print("Nhap dia chi: ");
            sc.nextLine();
        }
        this.address = sc.nextLine();

        //Nhap diem HTML
        do {
            System.out.print("Nhap diem HTML (>0, <10): ");
            while (!sc.hasNextFloat()) {
                System.out.print("Vui long nhap thong tin hop le: ");
                sc.next();
            }
            this.markHTML = sc.nextFloat();
        } while (this.markHTML <= 0 || this.markHTML > 10);

        //Nhap diem CSS
        do {
            System.out.print("Nhap diem CSS(>0, <10): ");
            while (!sc.hasNextFloat()) {
                System.out.print("Vui long nhap thong tin hop le: ");
                sc.next();
            }
            this.markCSS = sc.nextFloat();
        } while (this.markCSS <= 0 || this.markCSS > 10);

        //Nhap diem JAVASCRIPT
        do {
            System.out.print("Nhap diem JAVASCRIPT(>0, <10): ");
            while (!sc.hasNextFloat()) {
                System.out.print("Vui long nhap thong tin hop le: ");
                sc.next();
            }
            this.markJAVASCRIPT = sc.nextFloat();
        } while (this.markJAVASCRIPT <= 0 || this.markJAVASCRIPT > 10);
    }

    public void display() {
        int today = Year.now().getValue();

        System.out.printf("%s%-20s%s%s", "Mã sinh viên: ", studentId, "Tên sinh viên: ", studentName);
        System.out.printf("%s%-24d%s%-20s%s%s", "\nNăm sinh: ", (today - age), "Giới tính: ", sex, "Điện thoại: ", phone);
        System.out.printf("%s%-56s%s%f", "\nĐịa chỉ: ", address, "Điểm TB: ", calAvgMark());

    }

    public float calAvgMark() {
        float avgMark=(markHTML+markCSS+markJAVASCRIPT*2)/4;
       return avgMark;

    }
}
