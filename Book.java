import java.awt.*;
import javax.swing.*;

public class Book {
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;

    public Book() {
        JFrame frame = new JFrame("도서 관리 프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // 리스트 모델 및 리스트 초기화
        bookListModel = new DefaultListModel<>();
        bookList = new JList<>(bookListModel);
        JScrollPane scrollPane = new JScrollPane(bookList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 버튼 패널
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 5, 5));
        JButton insertButton = new JButton("추가");
        JButton searchAllButton = new JButton("전체 조회");
        JButton selectOneButton = new JButton("선택 조회");
        JButton updateButton = new JButton("수정");
        JButton deleteButton = new JButton("삭제");

        buttonPanel.add(insertButton);
        buttonPanel.add(searchAllButton);
        buttonPanel.add(selectOneButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 버튼 동작 추가
        insertButton.addActionListener(e -> insertB());
        searchAllButton.addActionListener(e -> searchAll());
        selectOneButton.addActionListener(e -> selectOne());
        updateButton.addActionListener(e -> updateB());
        deleteButton.addActionListener(e -> deleteB());

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void insertB() {
        String book = JOptionPane.showInputDialog("추가할 책 제목을 입력하세요:");
        if (book != null && !book.trim().isEmpty()) {
            bookListModel.addElement(book.trim());
            JOptionPane.showMessageDialog(null, "책이 추가되었습니다.");
        } else {
            JOptionPane.showMessageDialog(null, "책 제목을 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchAll() {
        if (bookListModel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "등록된 책이 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder books = new StringBuilder("전체 책 목록:\n");
            for (int i = 0; i < bookListModel.size(); i++) {
                books.append(i + 1).append(". ").append(bookListModel.getElementAt(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, books.toString(), "전체 조회", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void selectOne() {
        int selectedIndex = bookList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, "조회할 책을 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
        } else {
            String selectedBook = bookListModel.getElementAt(selectedIndex);
            JOptionPane.showMessageDialog(null, "선택된 책: " + selectedBook, "선택 조회", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateB() {
        int selectedIndex = bookList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, "수정할 책을 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
        } else {
            String updatedBook = JOptionPane.showInputDialog("새 책 제목을 입력하세요:", bookListModel.getElementAt(selectedIndex));
            if (updatedBook != null && !updatedBook.trim().isEmpty()) {
                bookListModel.setElementAt(updatedBook.trim(), selectedIndex);
                JOptionPane.showMessageDialog(null, "책 정보가 수정되었습니다.");
            } else {
                JOptionPane.showMessageDialog(null, "유효한 책 제목을 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteB() {
        int selectedIndex = bookList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(null, "삭제할 책을 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "선택된 책을 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                bookListModel.removeElementAt(selectedIndex);
                JOptionPane.showMessageDialog(null, "책이 삭제되었습니다.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Book::new);
    }
}
