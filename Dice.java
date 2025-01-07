import java.util.Random;
import java.util.Scanner;

public class Dice {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("주사위 게임을 시작합니다. 닉네임을 입력해주세요: ");
        String name = sc.nextLine();
        int score = 0;
        int life = 10;

        while (life > 0 && score < 100) { 
            System.out.print(name + "님의 주사위 수를 입력해주세요 (1~6): ");
            int mynum;

            try {
                mynum = sc.nextInt();
            } 
            catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.next();
                continue;
            }

            if (mynum < 1 || mynum > 6) {
                System.out.println("잘못된 범위의 수를 입력하셨습니다. 1~6 사이의 숫자를 입력해주세요.");
                continue;
            }

            int comnum = new Random().nextInt(6) + 1;
            System.out.println("Computer님의 번호: " + comnum);

            if (mynum > comnum) {
                score += 10;
                System.out.println(name + "님이 승리하셨습니다! 점수: " + score);
            } 
            else if (comnum > mynum) {
                System.out.println("Computer님이 승리하셨습니다.");
                life--;
                System.out.println("남은 목숨: " + life);
            } else {
                System.out.println("비겼습니다.");
            }

            if (life == 0) {
                System.out.println("목숨이 모두 소진되었습니다. 게임 종료. 최종 점수: " + score);
                break;
            } else if (score >= 100) {
                System.out.println("축하합니다! 점수가 100점에 도달했습니다. 게임 종료.");
                break;
            }

            System.out.print("게임을 계속 하시겠습니까? (예: y, 아니요: n): ");
            String answer = sc.next();

            if (answer.equals("n")) {
                System.out.println("게임을 종료합니다. 점수 : " + score + ", 목숨 : " + life);
                break;
            } 
            
            // y와 n 이외의 다른 값을 입력했을 때
            else if (!answer.equals("y")) {
                System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                break;
            }
            
        }
    }
}
