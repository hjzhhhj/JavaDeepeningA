package InT2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    /* Panel */
    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel centerPanel = new JPanel(new BorderLayout());
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel southPanel = new JPanel();

    /* Label */
    JLabel idL = new JLabel("아이디:");
    JLabel pwL = new JLabel("비밀번호:");

    /* TextField */
    JTextField id = new JTextField();
    JPasswordField pw = new JPasswordField();

    /* Button */
    JButton loginBtn = new JButton("로그인");
    JButton joinBtn = new JButton("회원가입");
    JButton exitBtn = new JButton("프로그램 종료");

    public MainFrame() {
        setTitle("로그인");

        /* Panel 크기 설정 */
        centerPanel.setPreferredSize(new Dimension(260, 80));
        westPanel.setPreferredSize(new Dimension(210, 75));
        eastPanel.setPreferredSize(new Dimension(90, 75));
        southPanel.setPreferredSize(new Dimension(290, 40));

        /* Label 크기 설정 */
        idL.setPreferredSize(new Dimension(50, 30));
        pwL.setPreferredSize(new Dimension(50, 30));

        /* TextField 크기 설정 */
        id.setPreferredSize(new Dimension(140, 30));
        pw.setPreferredSize(new Dimension(140, 30));

        /* Button 크기 설정 */
        loginBtn.setPreferredSize(new Dimension(75, 63));
        joinBtn.setPreferredSize(new Dimension(135, 25));
        exitBtn.setPreferredSize(new Dimension(135, 25));

        /* Panel 설정 */
        basePanel.add(centerPanel, BorderLayout.CENTER);
        basePanel.add(southPanel, BorderLayout.SOUTH);
        centerPanel.add(westPanel, BorderLayout.WEST);
        centerPanel.add(eastPanel, BorderLayout.EAST);

        /* westPanel 컴포넌트 추가 */
        westPanel.setLayout(new FlowLayout());
        westPanel.add(idL);
        westPanel.add(id);
        westPanel.add(pwL);
        westPanel.add(pw);

        /* eastPanel 컴포넌트 추가 */
        eastPanel.setLayout(new FlowLayout());
        eastPanel.add(loginBtn);

        /* southPanel 컴포넌트 추가 */
        southPanel.setLayout(new FlowLayout());
        southPanel.add(exitBtn);
        southPanel.add(joinBtn);

        /* Button 리스너 추가 */
        ButtonListener bl = new ButtonListener();
        loginBtn.addActionListener(bl);
        exitBtn.addActionListener(bl);
        joinBtn.addActionListener(bl);

        /* Frame 설정 */
        setContentPane(basePanel);
        setSize(310, 150);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* Button 이벤트 리스너 */
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            String uid = id.getText();
            String upass = new String(pw.getPassword());

            if (b.getText().equals("프로그램 종료")) {
                System.exit(0);
            } else if (b.getText().equals("회원가입")) {
                System.out.println("회원가입 클릭");
            } else if (b.getText().equals("로그인")) {
                if (uid.isEmpty() || upass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println("로그인 시도");
                    // 데이터베이스 확인 로직 추가 필요
                    // if (db.loginCheck(uid, upass)) {
                    //     JOptionPane.showMessageDialog(null, "로그인 성공");
                    // } else {
                    //     JOptionPane.showMessageDialog(null, "로그인 실패");
                    // }
                }
            }
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
