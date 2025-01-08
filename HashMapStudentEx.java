import java.util.HashMap;
import java.util.Scanner;

public class HashMapStudentEx {

	public static void main(String[] args) {
		HashMap<String, Student1> map = new HashMap<>();
		map.put("황기태" , new Student1(1,"010-111-222"));
		map.put("이재문" , new Student1(2,"010-333-444"));
		map.put("김남윤" , new Student1(3,"010-555-666"));
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("검색할 이름 : ");
			String name = input.nextLine();
			if(name.equals("종료")) {
				System.out.println("종료");
				break;
			}
			Student1 student = map.get(name);
			if(student == null) {
				System.out.println(name + "은 없는 사람입니다.");
			}
			else {
				System.out.println("id : " + student.id + "\n전화 : " + student.tel);
			}
		}
	}

}
class Student1 {
	int id;
	String tel;
	public Student1(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
}