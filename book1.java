import java.util.ArrayList;
import java.util.Scanner;

public class book1 {
    private ArrayList<BookInfo> books = new ArrayList<BookInfo>();
    private int lastBookNumber = 0;
    private Scanner sc = new Scanner(System.in);

    private class BookInfo {
        int number;
        String title;
        String author;
        String genre;
        boolean available;

        BookInfo(int number, String title, String author, String genre) {
            this.number = number;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.available = true;
        }

        public String toString() {
            String status;
            if (available) {
                status = "대출가능";
            } else {
                status = "대출중";
            }
            return number + ". " + title + " - " + author + " (" + genre + ") " + status;
        }
    }

    public void showMain() {
        while (true) {
            System.out.println("\n1.도서등록 2.전체조회 3.개별조회 4.책정보수정 5.책삭제 0.종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                insertB();
            } else if (choice == 2) {
                searchAll();
            } else if (choice == 3) {
                selectOne();
            } else if (choice == 4) {
                updateB();
            } else if (choice == 5) {
                deleteB();
            } else if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private void insertB() {
        System.out.print("제목: ");
        String title = sc.nextLine();
        System.out.print("저자: ");
        String author = sc.nextLine();
        System.out.print("장르: ");
        String genre = sc.nextLine();

        lastBookNumber = lastBookNumber + 1;
        BookInfo newBook = new BookInfo(lastBookNumber, title, author, genre);
        books.add(newBook);
        System.out.println("책이 등록되었습니다. 도서 번호: " + lastBookNumber);
    }

    private void searchAll() {
        for (int i = 0; i < books.size(); i++) {
            BookInfo book = books.get(i);
            System.out.println(book);
        }
    }

    private BookInfo findBook(int number) {
        for (int i = 0; i < books.size(); i++) {
            BookInfo book = books.get(i);
            if (book.number == number) {
                return book;
            }
        }
        return null;
    }

    private void selectOne() {
        System.out.print("조회할 도서 번호: ");
        int number = sc.nextInt();
        BookInfo book = findBook(number);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        }
    }

    private void updateB() {
        System.out.print("수정할 도서 번호: ");
        int number = sc.nextInt();
        sc.nextLine();
        BookInfo book = findBook(number);
        if (book != null) {
            System.out.print("새 제목: ");
            book.title = sc.nextLine();
            System.out.print("새 저자: ");
            book.author = sc.nextLine();
            System.out.print("새 장르: ");
            book.genre = sc.nextLine();
            System.out.println("책 정보가 수정되었습니다.");
        } else {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        }
    }

    private void deleteB() {
        System.out.print("삭제할 도서 번호: ");
        int number = sc.nextInt();
        BookInfo book = findBook(number);
        if (book != null) {
            books.remove(book);
            System.out.println("책이 삭제되었습니다.");
        } else {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        }
    }

    public void checkB() {
        System.out.print("대여/반납할 도서 번호: ");
        int number = sc.nextInt();
        BookInfo book = findBook(number);
        if (book != null) {
            if (book.available) {
                book.available = false;
                System.out.println("도서가 대여되었습니다.");
            } else {
                book.available = true;
                System.out.println("도서가 반납되었습니다.");
            }
        } else {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        }
    }
}
