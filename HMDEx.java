import java.util.*;

public class HMDEx {
	public static void main(String args[]) {
		HashMap<String, String> dic = new HashMap<String, String>();
		
		dic.put("박원빈", "RIIZE");
		dic.put("나재민", "NCT DREAM");
		dic.put("김석진", "방탄소년단");
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("찾고싶은 단어는? : ");
			String eng = sc.next();
			
			if(eng.equals("종료")) {
				System.out.println("종료합니다...");
				break;
			}
			String kor = dic.get(eng);
			if ( kor == null ) {
				System.out.println(eng+"는 없는 단어 입니다.");
			}
			else {
				System.out.println(kor);
			}
			sc.close();
		}
	}
}
