import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Book {
    private ArrayList<BookInfo> books;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;
    private Random random;
    private int lastBookNumber = 0;
    private static final String[] GENRES = {"소설", "시", "에세이", "역사", "과학", "철학", "자기계발"};

    private static class BookInfo {
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
            String availabilityStatus;
            if (available) {
                availabilityStatus = "대출가능";
            } else {
                availabilityStatus = "대출중";
            }
            return number + ". " + title + " - " + author + " (" + genre + ") " + availabilityStatus;
        }
    }

    public Book() {
        books = new ArrayList<BookInfo>();
        random = new Random();
        showMain();
    }

    private void showMain() {
        JFrame frame = new JFrame("도서 관리 프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        bookListModel = new DefaultListModel<String>();
        bookList = new JList<String>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        JButton insertButton = new JButton("도서 등록");
        JButton searchAllButton = new JButton("전체 조회");
        JButton selectOneButton = new JButton("개별 조회");
        JButton updateButton = new JButton("책 정보 수정");
        JButton deleteButton = new JButton("책 삭제");
        JButton randomRecommendButton = new JButton("랜덤 추천");
        JButton checkButton = new JButton("대여/반납");
        JButton exitButton = new JButton("종료");

        buttonPanel.add(insertButton);
        buttonPanel.add(searchAllButton);
        buttonPanel.add(selectOneButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(randomRecommendButton);
        buttonPanel.add(checkButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        insertButton.addActionListener(e -> insertB());
        searchAllButton.addActionListener(e -> searchAll());
        selectOneButton.addActionListener(e -> selectOne());
        updateButton.addActionListener(e -> updateB());
        deleteButton.addActionListener(e -> deleteB());
        randomRecommendButton.addActionListener(e -> randomRecommend());
        checkButton.addActionListener(e -> checkB());
        exitButton.addActionListener(e -> System.exit(0));

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void insertB() {
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JComboBox<String> genreComboBox = new JComboBox<String>(GENRES);
        Object[] message = {
            "책 제목:", titleField,
            "저자:", authorField,
            "장르:", genreComboBox
        };

        int option = JOptionPane.showConfirmDialog(null, message, "도서 등록", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String genre = (String) genreComboBox.getSelectedItem();

            if (!title.isEmpty() && !author.isEmpty()) {
                lastBookNumber++;
                BookInfo newBook = new BookInfo(lastBookNumber, title, author, genre);
                books.add(newBook);
                bookListModel.addElement(newBook.toString());
                JOptionPane.showMessageDialog(null, "책이 등록되었습니다. 도서 번호: " + lastBookNumber);
            } else {
                JOptionPane.showMessageDialog(null, "모든 필드를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void searchAll() {
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(null, "등록된 책이 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder allBooks = new StringBuilder("전체 책 목록:\n");
            for (int i = 0; i < books.size(); i++) {
                allBooks.append(books.get(i).toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, allBooks.toString(), "전체 조회", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private BookInfo findBook(String searchType) {
        String[] options = {"도서 번호로 검색", "책 제목으로 검색", "저자로 검색"};
        int choice = JOptionPane.showOptionDialog(null, "어떤 방법으로 검색하시겠습니까?", searchType,
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        BookInfo foundBook = null;

        if (choice == 0) {
            String input = JOptionPane.showInputDialog("도서 번호를 입력하세요:");
            if (input != null && !input.trim().isEmpty()) {
                try {
                    int bookNumber = Integer.parseInt(input);
                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).number == bookNumber) {
                            foundBook = books.get(i);
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "유효한 도서 번호를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (choice == 1) {
            String title = JOptionPane.showInputDialog("책 제목을 입력하세요:");
            if (title != null && !title.trim().isEmpty()) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).title.equalsIgnoreCase(title.trim())) {
                        foundBook = books.get(i);
                        break;
                    }
                }
            }
        } else if (choice == 2) {
            String author = JOptionPane.showInputDialog("저자를 입력하세요:");
            if (author != null && !author.trim().isEmpty()) {
                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).author.equalsIgnoreCase(author.trim())) {
                        foundBook = books.get(i);
                        break;
                    }
                }
            }
        }

        if (foundBook == null) {
            JOptionPane.showMessageDialog(null, "해당 도서를 찾을 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }

        return foundBook;
    }

    private void selectOne() {
        BookInfo foundBook = findBook("개별 조회");
        if (foundBook != null) {
            JOptionPane.showMessageDialog(null, foundBook.toString(), "도서 정보", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateB() {
        BookInfo bookToUpdate = findBook("책 정보 수정");
        if (bookToUpdate != null) {
            JTextField titleField = new JTextField(bookToUpdate.title);
            JTextField authorField = new JTextField(bookToUpdate.author);
            JComboBox<String> genreComboBox = new JComboBox<String>(GENRES);
            genreComboBox.setSelectedItem(bookToUpdate.genre);
            Object[] message = {
                "새 책 제목:", titleField,
                "새 저자:", authorField,
                "새 장르:", genreComboBox
            };

            int option = JOptionPane.showConfirmDialog(null, message, "도서 정보 수정", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String newTitle = titleField.getText().trim();
                String newAuthor = authorField.getText().trim();
                String newGenre = (String) genreComboBox.getSelectedItem();

                if (!newTitle.isEmpty() && !newAuthor.isEmpty()) {
                    bookToUpdate.title = newTitle;
                    bookToUpdate.author = newAuthor;
                    bookToUpdate.genre = newGenre;
                    int index = books.indexOf(bookToUpdate);
                    bookListModel.setElementAt(bookToUpdate.toString(), index);
                    JOptionPane.showMessageDialog(null, "책 정보가 수정되었습니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "모든 필드를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void deleteB() {
        BookInfo bookToRemove = findBook("책 삭제");
        if (bookToRemove != null) {
            int confirm = JOptionPane.showConfirmDialog(null, "다음 책을 삭제하시겠습니까?\n" + bookToRemove, "확인", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                books.remove(bookToRemove);
                bookListModel.removeElement(bookToRemove.toString());
                JOptionPane.showMessageDialog(null, "책이 삭제되었습니다.");
            }
        }
    }

    private void randomRecommend() {
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(null, "추천할 책이 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int randomIndex = random.nextInt(books.size());
            BookInfo recommendedBook = books.get(randomIndex);
            JOptionPane.showMessageDialog(null, "추천 도서:\n" + recommendedBook, "랜덤 추천", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void checkB() {
        BookInfo bookToCheck = findBook("대여/반납");
        if (bookToCheck != null) {
            if (bookToCheck.available) {
                bookToCheck.available = false;
                JOptionPane.showMessageDialog(null, "도서가 대여되었습니다.");
            } else {
                bookToCheck.available = true;
                JOptionPane.showMessageDialog(null, "도서가 반납되었습니다.");
            }
            int index = books.indexOf(bookToCheck);
            bookListModel.setElementAt(bookToCheck.toString(), index);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Book();
            }
        });
    }
}
