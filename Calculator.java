import java.util.Scanner;

public class Calculator {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("첫 번째 숫자를 입력하세요:");
            double a = sc.nextDouble();

            System.out.println("연산자를 입력하세요 (+, -, *, /):");
            String ab = sc.next();

            System.out.println("두 번째 숫자를 입력하세요:");
            double b = sc.nextDouble();

            switch (ab) {
                case "+":
                    System.out.println(a + " + " + b + " = " + (a + b));
                    break;
                case "-":
                    System.out.println(a + " - " + b + " = " + (a - b));
                    break;
                case "*":
                    System.out.println(a + " * " + b + " = " + (a * b));
                    break;
                case "/":
                    if (b != 0) {
                        System.out.println(a + " / " + b + " = " + (a / b));
                    } else {
                        System.out.println("0으로 나누는 것은 옳지 않은 방법입니다.");
                    }
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("입력 형식이 올바르지 않습니다. 숫자와 연산자를 정확히 입력하세요.");
        }
    }
}
