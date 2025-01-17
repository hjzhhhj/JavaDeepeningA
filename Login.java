package Project_Kiosk;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.sql.*; 

public class Login {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("메인 화면"); // 창 제목을 메인화면으로 설정
        mainFrame.setSize(500, 700); // 창 크기를 가로 500, 세로 700으로 설정
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 클릭 시 프로그램 종료
        mainFrame.setLocation(500, 150); // 창이 화면에서 뜨는 위치 설정 (왼쪽 500, 위쪽 150)

        JButton loginButton = new JButton("로그인"); // 버튼 이름을 로그인으로 설정
        loginButton.setBounds(150, 250, 200, 50); // 버튼 위치 (x=150, y=250)와 크기 (가로=200, 세로=50)
        loginButton.setFont(new Font("돋움", Font.PLAIN, 20)); // 버튼의 글꼴 설정 (돋움, 크기 20)
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame(); // 로그인 화면을 새로 염
                mainFrame.dispose(); // 현재 메인 화면 창을 닫음
            }
        });

        // 회원가입 버튼을 만듬
        JButton registerButton = new JButton("회원가입"); // 버튼 이름을 회원가입으로 설정
        registerButton.setBounds(150, 350, 200, 50); // 버튼 위치(x=150, y=350)와 크기(가로=200, 세로=50)
        registerButton.setFont(new Font("돋움", Font.PLAIN, 20)); // 버튼 글꼴 설정 (위와 동일)
        registerButton.setFocusPainted(false);  
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame(); // 회원가입 화면을 새로 염
                mainFrame.dispose(); // 현재 메인 화면 창을 닫음
            }
        });

        // 메인 화면 배경
        JPanel panel = new JPanel(); 
        panel.setBackground(Color.WHITE); // 패널의 배경색을 흰색으로
        panel.setBounds(0, 0, 500, 700); // 패널 크기
        panel.setLayout(null); // 절대 배치로 위치를 자유롭게 설정

        panel.add(loginButton);
        panel.add(registerButton);
        mainFrame.add(panel);

        mainFrame.setVisible(true);
    }
}

// 로그인 화면
class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("로그인"); // 창 제목은 로그인
        setSize(500, 700); // 창 크기는 가로 500, 세로 700
        setLayout(null); // 절대 배치 (위치 자유롭게)
        setLocation(500, 150); // 창이 화면에서 뜨는 위치

        JLabel idLabel = new JLabel("아이디:"); 
        idLabel.setBounds(100, 200, 80, 30);
        JTextField idField = new JTextField(); // 사용자 입력 필드
        idField.setBounds(200, 200, 200, 30);

        JLabel pwLabel = new JLabel("비밀번호:");
        pwLabel.setBounds(100, 250, 80, 30);
        JPasswordField pwField = new JPasswordField(); // 비밀번호 입력 필드
        pwField.setBounds(200, 250, 200, 30);

        JButton loginBtn = new JButton("로그인"); // 버튼 이름을 로그인으로 설정
        loginBtn.setBounds(200, 300, 100, 30); // 버튼 위치와 크기 설정
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "로그인에 성공하셨습니다.");
                new OrderingFood(); // 주문 화면으로 이동
                dispose(); // 현재 로그인 화면 닫기
            }
        });

        add(idLabel);
        add(idField);
        add(pwLabel);
        add(pwField);
        add(loginBtn);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 창 닫기
        setVisible(true);
    }
}

// 회원가입 클래스
class RegisterFrame extends JFrame {
    public RegisterFrame() {
        setTitle("회원가입"); // 창 제목을 회원가입으로 설정
        setSize(500, 700); // 창 크기는 가로 500, 세로 700
        setLayout(null); // 절대 배치 설정 
        setLocation(500, 150); // 창이 화면에서 뜨는 위치 설정

        JLabel idLabel = new JLabel("아이디:");
        idLabel.setBounds(100, 200, 80, 30);
        JTextField idField = new JTextField();
        idField.setBounds(200, 200, 200, 30);

        JLabel pwLabel = new JLabel("비밀번호:");
        pwLabel.setBounds(100, 250, 80, 30);
        JPasswordField pwField = new JPasswordField();
        pwField.setBounds(200, 250, 200, 30);

        JLabel nameLabel = new JLabel("이름:");
        nameLabel.setBounds(100, 300, 80, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(200, 300, 200, 30);

        JButton registerBtn = new JButton("회원가입");
        registerBtn.setBounds(200, 350, 100, 30);
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 사용자 입력 값 가져오기
                String id = idField.getText();
                String pw = new String(pwField.getPassword());
                String name = nameField.getText();
                if (registerUser(id, pw, name)) {
                    JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다.");
                    dispose();
                    new LoginFrame();
                } else {
                    JOptionPane.showMessageDialog(null, "회원가입에 실패하셨습니다.");
                }
            }
        });

        add(idLabel);
        add(idField);
        add(pwLabel);
        add(pwField);
        add(nameLabel);
        add(nameField);
        add(registerBtn);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // 데이터베이스에 회원 정보 저장 메소드? 메서드?
    private boolean registerUser(String id, String pw, String name) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "1234");
            String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id); // 아이디 저장
            stmt.setString(2, pw); // 비밀번호 저장
            stmt.setString(3, name); // 이름 저장
            int rowsAffected = stmt.executeUpdate(); // 데이터베이스

            return rowsAffected > 0; // 데이터 추가 성공 여부
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // 오류 발생 시 실패 처리
        }
    }
}
