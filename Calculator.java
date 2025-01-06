import java.util.Scanner;

public class Calculator {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        String ab = sc.next();
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
        
    }
}