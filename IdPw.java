import java.util.HashMap;
import java.util.Scanner;

public class IdPw {
    // HashMap을 이용하여 아이디와 비밀번호를 저장
    private HashMap<String, String> userCredentials;

    public IdPw() {
        userCredentials = new HashMap<>();
        userCredentials.put("hge", "1111");
        userCredentials.put("KGM", "2354");
        userCredentials.put("PJW", "6479");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("로그인 하시겠습니까?(y or n) : ");
            String choice = scanner.nextLine();
            
            if (choice.equals("n")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            System.out.print("id : ");
            String id = scanner.nextLine();
            System.out.print("pw : ");
            String pw = scanner.nextLine();
            
            // 아이디 확인
            if (!userCredentials.containsKey(id)) {
                System.out.println("아이디가 존재하지 않습니다.");
            }
            // 비밀번호 확인
            else if (!userCredentials.get(id).equals(pw)) {
                System.out.println("비밀번호 불일치");
            }
            
            else {
                System.out.println("로그인 성공!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        IdPw idPw = new IdPw();
        idPw.login();
    }
}
