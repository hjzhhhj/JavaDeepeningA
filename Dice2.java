import java.util.Random;
import java.util.Scanner;

public class Dice2 {
	public static void main(String args[]) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("플레이어 1님의 이름을 입력해주세요 : ");
		String name1 = sc.nextLine();
		System.out.print("플레이어 2님의 이름을 입력해주세요 : ");
		String name2 = sc.nextLine();

		while (true) {
			int one = 0;
			int two = 0;

			boolean playGame = true;

			while (playGame) {
				System.out.print(name1 + "님이 주사위를 굴립니다..");
				int p1num1 = rd.nextInt(6) + 1;
				System.out.print(" " + p1num1);
				int p1num2 = rd.nextInt(6) + 1;
				System.out.print(" " + p1num2);
				one = p1num1 + p1num2;

				System.out.println("");

				System.out.print(name2 + "님이 주사위를 굴립니다..");
				int p2num1 = rd.nextInt(6) + 1;
				System.out.print(" " + p2num1);
				int p2num2 = rd.nextInt(6) + 1;
				System.out.print(" " + p2num2);
				two = p2num1 + p2num2;

				System.out.println("");

				if ((one > 10 && two > 10) || one == two) {
					System.out.println("두 플레이어 주사위 값의 합이 모두 10이 넘었음거으로 다시 게임을 진행합니다.");
					continue;
				} else if (one > 10) {
					System.out.println(name1 + "님의 주사위 값의 합이 10이 넘었음으로 " + name2 + "님의 승리입니다.");
					break;
				} else if (two > 10) {
					System.out.println(name2 + "님의 주사위 값의 합이 10이 넘었음으로 " + name1 + "님의 승리입니다.");
					break;
				} else if (one > two) {
					System.out.println(name1 + "님의 주사위 값이 " + name2 + "님보다 큼으로 승리입니다.");
					break;
				} else if (two > one) {
					System.out.println(name2 + "님의 주사위 값이 " + name1 + "님보다 큼으로 승리입니다.");
					break;
				}
			}

			System.out.print("다시하시겠습니까? (y/n) : ");
			String answer = sc.nextLine();

			if (answer.equals("n")) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (!answer.equals("y")) {
				System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
				break;
			}
		}
	}
}