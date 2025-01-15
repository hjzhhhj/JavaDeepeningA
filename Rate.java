import java.util.Scanner;

public class Rate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double usd = 1470.52; 
        double eur = 1584.75;
        double jpy = 11.21;  

        System.out.println("환전 프로그램입니다.");
        System.out.println("1: 원 -> 달러");
        System.out.println("2: 원 -> 유로");
        System.out.println("3: 원 -> 엔");
        System.out.println("4: 달러 -> 원");
        System.out.println("5: 유로 -> 원");
        System.out.println("6: 엔 -> 원");

        System.out.print("번호를 선택하세요 (1-6): ");
        int menu = sc.nextInt();

        double money = 0; 
        double result = 0; 
  
        if (menu == 1) { 
            System.out.print("원 입력: ");
            money = sc.nextDouble();
            result = money / usd;
            System.out.printf("%.2f 원은 %.2f 달러입니다.\n", money, result);
        } else if (menu == 2) {
            System.out.print("원 입력: ");
            money = sc.nextDouble();
            result = money / eur;
            System.out.printf("%.2f 원은 %.2f 유로입니다.\n", money, result);
        } else if (menu == 3) { 
            System.out.print("원 입력: ");
            money = sc.nextDouble();
            result = money / jpy;
            System.out.printf("%.2f 원은 %.2f 엔입니다.\n", money, result);
        } else if (menu == 4) { 
            System.out.print("달러 입력: ");
            money = sc.nextDouble();
            result = money * usd;
            System.out.printf("%.2f 달러는 %.2f 원입니다.\n", money, result);
        } else if (menu == 5) { 
            System.out.print("유로 입력: ");
            money = sc.nextDouble();
            result = money * eur;
            System.out.printf("%.2f 유로는 %.2f 원입니다.\n", money, result);
        } else if (menu == 6) {
            System.out.print("엔 입력: ");
            money = sc.nextDouble();
            result = money * jpy;
            System.out.printf("%.2f 엔은 %.2f 원입니다.\n", money, result);
        } else {
            System.out.println("잘못된 선택입니다.");
        }
        sc.close();
    }
}
