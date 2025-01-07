import java.util.Random;
import java.util.Scanner;

class NumberQA {
    int randomNumber; 
    int numberOfTries; 

    public NumberQA() {
        randomNumber = new Random().nextInt(100) + 1; 
        numberOfTries = 0; 
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        boolean hasGuessedCorrectly = false;

        System.out.println("====== 숫자 맞추기 게임 =======");
        System.out.println("1부터 100 사이의 숫자를 맞춰 보세요.");
        System.out.println("=============================");
        
        while (!hasGuessedCorrectly) {
            System.out.print("숫자를 입력하세요: ");
            int playerGuess = scan.nextInt();
            numberOfTries++;

            if (playerGuess < randomNumber) {
                System.out.println("더 큰 숫자를 시도해보세요.");
            } else if (playerGuess > randomNumber) {
                System.out.println("더 작은 숫자를 시도해보세요.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("축하합니다! 정답입니다: " + randomNumber);
                System.out.println("시도 횟수: " + numberOfTries);
            }
        }
    }
}

public class GuessingGame {
    public static void main(String[] args) {
        NumberQA game = new NumberQA();
        game.startGame();
    }
}

