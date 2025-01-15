import java.util.*;

class Person {
    String name;
    String gender;
    int age;
    String phone;
    String address;
    String note;
    String grade;

    public Person(String name, String gender, int age, String phone, String address, String note, String grade) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.note = note;
        this.grade = grade;
    }

    public void updatePerson(String gender, int age, String phone, String address, String note, String grade) {
        if (gender != null && !gender.trim().isEmpty()) {
            this.gender = gender;
        }
        if (age > 0) {
            this.age = age;
        }
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone;
        }
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        }
        if (note != null && !note.trim().isEmpty()) {
            this.note = note;
        }
        if (grade != null && !grade.trim().isEmpty()) {
            this.grade = grade;
        }
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 성별: " + gender + ", 나이: " + age + "세, 등급: " + grade +
                ", 전화번호: " + phone + ", 주소: " + address + ", 비고: " + note;
    }

    public String getName() {
        return name;
    }
}

class MemberManage {
    Map<String, Person> people;

    public MemberManage() {
        people = new HashMap<>();
    }

    public void addMember(String name, String gender, int age, String phone, String address, String note, String grade) {
        name = name.trim().toLowerCase();
        if (!people.containsKey(name)) {
            if (isValidGrade(grade)) {
                people.put(name, new Person(name, gender, age, phone, address, note, grade));
                System.out.println(name + "님이 가입되었습니다.");
            } else {
                System.out.println("유효하지 않은 등급입니다. 기본 등급(일반)으로 설정됩니다.");
                people.put(name, new Person(name, gender, age, phone, address, note, "일반"));
            }
        } else {
            System.out.println(name + "님은 이미 있습니다.");
        }
    }

    public void changeMember(String name, String gender, int age, String phone, String address, String note, String grade, String userGrade) {
        name = name.trim().toLowerCase();
        Person person = people.get(name);
        if (person != null) {
            person.updatePerson(gender, age, phone, address, note, grade);
            System.out.println(name + "님의 정보가 수정되었습니다.");
        } else {
            System.out.println(name + "님은 없습니다.");
        }

        if (userGrade.equals("관리자")) {
            if (isValidGrade(grade)) {
                person.grade = grade;
            } else {
                System.out.println("유효하지 않은 등급입니다. 등급 변경이 취소되었습니다.");
            }
        }
    }

    public void removeMember(String name, String userGrade) {
        name = name.trim().toLowerCase();
        if (userGrade.equals("관리자")) {
            if (people.remove(name) != null) {
                System.out.println(name + "님이 삭제되었습니다.");
            } else {
                System.out.println(name + "님을 찾을 수 없습니다.");
            }
        } else {
            System.out.println("관리자만 회원을 삭제할 수 있습니다.");
        }
    }

    public void findMember(String name) {
        name = name.trim().toLowerCase();
        Person person = people.get(name);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println(name + "님을 찾을 수 없습니다.");
        }
    }

    public void showMembers() {
        if (people.isEmpty()) {
            System.out.println("회원 목록이 비어있어요.");
        } else {
            System.out.println("회원 목록:");
            for (Person person : people.values()) {
                System.out.println(person);
            }
        }
    }

    private boolean isValidGrade(String grade) {
        return grade.equals("일반") || grade.equals("VIP") || grade.equals("관리자");
    }
}

public class MemberManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberManage manage = new MemberManage();

        while (true) {
            try {
                System.out.println("\n1. 회원 등록");
                System.out.println("2. 회원 수정");
                System.out.println("3. 회원 삭제");
                System.out.println("4. 회원 검색");
                System.out.println("5. 회원 목록");
                System.out.println("6. 종료");
                System.out.print("번호를 입력하세요: ");
                int choice = sc.nextInt();
                sc.nextLine();

                System.out.print("관리자 이름: ");
                String adminName = sc.nextLine();

                Person admin = manage.people.get(adminName.trim().toLowerCase());
                if (admin == null || !admin.grade.equals("관리자")) {
                    System.out.println("관리자 권한이 없습니다.");
                    continue;
                }

                if (choice == 1) {
                    System.out.print("이름: ");
                    String name = sc.nextLine();
                    System.out.print("성별: ");
                    String gender = sc.nextLine();
                    System.out.print("나이: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("전화번호: ");
                    String phone = sc.nextLine();
                    System.out.print("주소: ");
                    String address = sc.nextLine();
                    System.out.print("비고: ");
                    String note = sc.nextLine();
                    System.out.print("등급(일반/VIP/관리자): ");
                    String grade = sc.nextLine();
                    manage.addMember(name, gender, age, phone, address, note, grade);
                } 
                else if (choice == 2) {
                    System.out.print("수정할 회원 이름: ");
                    String name = sc.nextLine();
                    System.out.print("새 성별: ");
                    String gender = sc.nextLine();
                    System.out.print("새 나이: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("새 전화번호: ");
                    String phone = sc.nextLine();
                    System.out.print("새 주소: ");
                    String address = sc.nextLine();
                    System.out.print("새 비고: ");
                    String note = sc.nextLine();
                    System.out.print("새 등급(일반/VIP/관리자): ");
                    String grade = sc.nextLine();
                    manage.changeMember(name, gender, age, phone, address, note, grade, admin.grade);
                } 
                else if (choice == 3) {
                    System.out.print("삭제할 회원 이름: ");
                    String name = sc.nextLine();
                    manage.removeMember(name, admin.grade);
                } 
                else if (choice == 4) {
                    System.out.print("검색할 회원 이름: ");
                    String name = sc.nextLine();
                    manage.findMember(name);
                } 
                else if (choice == 5) {
                    manage.showMembers();
                } 
                else if (choice == 6) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } 
                else {
                    System.out.println("잘못된 입력입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
