package Project_Kiosk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp {
    public static void main(String[] args) {
        // 메인 프레임 생성
        JFrame mainFrame = new JFrame("메인 화면");
        mainFrame.setSize(500, 700);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);

        // 로그인 버튼
        JButton loginButton = new JButton("로그인");
        loginButton.setBounds(150, 250, 200, 50);
        loginButton.setFont(new Font("돋움", Font.PLAIN, 20));
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                mainFrame.dispose(); // 현재 프레임 닫기
            }
        });

        // 회원가입 버튼
        JButton registerButton = new JButton("회원가입");
        registerButton.setBounds(150, 350, 200, 50);
        registerButton.setFont(new Font("돋움", Font.PLAIN, 20));
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame();
                mainFrame.dispose(); // 현재 프레임 닫기
            }
        });

        // 패널 설정
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 500, 700);
        panel.setLayout(null);

        // 컴포넌트 추가
        panel.add(loginButton);
        panel.add(registerButton);
        mainFrame.add(panel);

        // 프레임 표시
        mainFrame.setVisible(true);
    }
}

class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("로그인");
        setSize(500, 700);
        setLayout(null);

        JLabel idLabel = new JLabel("아이디:");
        idLabel.setBounds(100, 200, 80, 30);
        JTextField idField = new JTextField();
        idField.setBounds(200, 200, 200, 30);

        JLabel pwLabel = new JLabel("비밀번호:");
        pwLabel.setBounds(100, 250, 80, 30);
        JPasswordField pwField = new JPasswordField();
        pwField.setBounds(200, 250, 200, 30);

        JButton loginBtn = new JButton("로그인");
        loginBtn.setBounds(200, 300, 100, 30);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 로그인 로직 구현
                String id = idField.getText();
                String pw = new String(pwField.getPassword());
                // 데이터베이스에서 아이디와 비밀번호 확인 로직 추가
                // 로그인 성공 시 다음 화면으로 전환
            }
        });

        add(idLabel);
        add(idField);
        add(pwLabel);
        add(pwField);
        add(loginBtn);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

class RegisterFrame extends JFrame {
    public RegisterFrame() {
        setTitle("회원가입");
        setSize(500, 700);
        setLayout(null);

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
                String id = idField.getText();
                String pw = new String(pwField.getPassword());
                String name = nameField.getText();
                // 데이터베이스에 회원 정보 저장 로직 추가
                // 예: JDBC를 사용하여 데이터베이스에 연결하고 정보 저장
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
}
