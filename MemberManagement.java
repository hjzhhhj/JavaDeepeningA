import java.util.*;

class Person {
    String name;
    String gender;
    int age;
    String phone;
    String address;
    String note;

    public Person(String name, String gender, int age, String phone, String address, String note) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.note = note;
    }
    
    public void updatePerson(String name, String gender, int age, String phone, String address, String note) {
        if (name != null) this.name = name;
        if (gender != null) this.gender = gender;
        if (age > 0) this.age = age;
        if (phone != null) this.phone = phone;
        if (address != null) this.address = address;
        if (note != null) this.note = note;
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 성별: " + gender + ", 나이: " + age + "세, 전화번호: " + phone + ", 주소: " + address + ", 비고: " + note;
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

    public void addMember(String name, String gender, int age, String phone, String address, String note) {
        if (!people.containsKey(name)) {
            people.put(name, new Person(name, gender, age, phone, address, note));
            System.out.println(name + "님이 가입되었습니다.");
        }
        
        else {
            System.out.println(name + "님은 이미 있습니다.");
        }
    }

    public void changeMember(String name, String gender, int age, String phone, String address, String note) {
        Person person = people.get(name);
        if (person != null) {
            person.updatePerson(name, gender, age, phone, address, note);
            System.out.println(name + "님의 정보가 수정되었습니다.");
        } 
        
        else {
            System.out.println(name + "님은 없습니다.");
        }
    }

    public void removeMember(String name) {
        if (people.remove(name) != null) {
            System.out.println(name + "님이 삭제되었습니다.");
        } 
        
        else {
            System.out.println(name + "님을 찾을 수 없습니다.");
        }
    }

    public void findMember(String name) {
        Person person = people.get(name);
        if (person != null) {
            System.out.println(person);
        } 
        
        else {
            System.out.println(name + "님을 찾을 수 없습니다.");
        }
    }

    public void showMembers() {
        if (people.isEmpty()) {
            System.out.println("회원 목록이 비어있어요.");
        } 
        
        else {
            System.out.println("회원 목록:");
            for (Person person : people.values()) {
                System.out.println(person);
            }
        }
    }
}

public class MemberManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberManage manage = new MemberManage();

        while (true) {
            System.out.println("\n1. 회원 등록");
            System.out.println("2. 회원 수정");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 회원 검색");
            System.out.println("5. 회원 목록");
            System.out.println("6. 종료");
            System.out.print("번호를 입력하세요: ");
            int choice = sc.nextInt();
            sc.nextLine();

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
                manage.addMember(name, gender, age, phone, address, note);
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
                manage.changeMember(name, gender, age, phone, address, note);
            } 
            
            else if (choice == 3) {
                System.out.print("삭제할 회원 이름: ");
                String name = sc.nextLine();
                manage.removeMember(name);
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
        }
    }
}
