import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Book extends JFrame {
    private JTextField txtTitle, txtAuthor;
    private DefaultTableModel tableModel;
    private JTable table;

    public Book() {
        setTitle("도서 관리 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inputPanel.add(new JLabel("책 제목:"));
        txtTitle = new JTextField();
        inputPanel.add(txtTitle);

        JButton btnAdd = new JButton("추가");
        inputPanel.add(btnAdd);

        inputPanel.add(new JLabel("저자:"));
        txtAuthor = new JTextField();
        inputPanel.add(txtAuthor);

        JButton btnClear = new JButton("초기화");
        inputPanel.add(btnClear);

        inputPanel.add(new JLabel());
        JButton btnDelete = new JButton("선택 삭제");
        inputPanel.add(btnDelete);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"책 제목", "저자"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        addInitialData();

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText().trim();
                String author = txtAuthor.getText().trim();

                if (title.isEmpty() || author.isEmpty()) {
                    JOptionPane.showMessageDialog(Book.this, "모든 필드를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                } else {
                    tableModel.addRow(new Object[]{title, author});
                    txtTitle.setText("");
                    txtAuthor.setText("");
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTitle.setText("");
                txtAuthor.setText("");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(Book.this, "삭제할 행을 선택하세요.", "오류", JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(Book.this, "선택된 책을 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        tableModel.removeRow(selectedRow);
                    }
                }
            }
        });

        add(mainPanel);
    }

    private void addInitialData() {
        tableModel.addRow(new Object[]{"자바 프로그래밍", "홍길동"});
        tableModel.addRow(new Object[]{"파이썬 기초", "이몽룡"});
        tableModel.addRow(new Object[]{"알고리즘", "성춘향"});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Book app = new Book();
            app.setVisible(true);
        });
    }
}
