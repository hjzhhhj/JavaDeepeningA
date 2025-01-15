import java.util.ArrayList;
import java.util.Scanner;

// 학생 클래스
class Student {
    private String name; 
    private boolean isPresent;

    public Student(String name) {
        this.name = name;
        this.isPresent = false;
    }

    public String getName() {
        return name; 
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void markPresent() {
        this.isPresent = true; 
    }

    public void markAbsent() {
        this.isPresent = false; 
    }
}

// 출석 관리 클래스
class AttendanceManager {
    private ArrayList<Student> students; 

    public AttendanceManager() {
        students = new ArrayList<>(); 
    }

    // 학생 추가
    public void addStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println("이미 등록된 학생입니다.");
                return;
            }
        }
        students.add(new Student(name)); 
        System.out.println(name + " 학생이 추가되었습니다.");
    }

    // 학생 목록 보기
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다."); 
            return;
        }
        System.out.println("학생 목록:");
        for (int i = 0; i < students.size(); i++) {
            Student slist = students.get(i);
            System.out.println((i + 1) + ". " + slist.getName());
        }
    }

    // 출석 체크
    public void checkAttendance(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                student.markPresent();
                System.out.println(name + " 출석 처리되었습니다.");
                return;
            }
        }
        System.out.println("등록되지 않은 학생입니다."); 
    }

    // 출석 현황 보기
    public void showAttendance() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다."); 
            return;
        }
        System.out.println("출석 현황:");
        for (int i = 0; i < students.size(); i++) {
            Student slist = students.get(i);
            String status = slist.isPresent() ? "출석" : "결석"; 
            System.out.println((i + 1) + ". " + slist.getName() + " : " + status); 
        }
    }
}

public class AttendanceSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();

        while (true) {
            System.out.println("======== 출석 관리 프로그램 ========");
            System.out.println("1.등록 2.목록 3.출석체크 4.출석현황 5.종료");
            System.out.print("선택: ");
            int choice = scan.nextInt(); 
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("등록 학생 이름: ");
                    String name = scan.nextLine();
                    manager.addStudent(name);
                    break;
                case 2:
                    manager.displayStudents(); 
                    break;
                case 3:
                    System.out.print("출석 학생 이름: ");
                    String attendanceName = scan.nextLine();
                    manager.checkAttendance(attendanceName); 
                    break;
                case 4:
                    manager.showAttendance(); 
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }
}
