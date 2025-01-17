package Project_Kiosk;

import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdingFood extends JFrame {
    public OrdingFood() {
        setTitle("Main1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        setLocation(500, 150);

        // 컨테이너
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        // 레이블
        JLabel lblNewLabel = new JLabel("음식의 종류를 선택하세요!");
        lblNewLabel.setBounds(170, 133, 200, 30);
        contentPane.add(lblNewLabel);

        // 한식 버튼
        JButton kBtn = new JButton("한식");
        kBtn.setBounds(40, 250, 90, 90);
        contentPane.add(kBtn);
        kBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KFood();  // KFood 클래스를 호출
                dispose();  // 현재 프레임 닫기
            }
        });

        // 일식 버튼
        JButton JBtn = new JButton("일식");
        JBtn.setBounds(140, 250, 90, 90);
        contentPane.add(JBtn);
        JBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JFood();  // JFood 클래스를 호출
                dispose();  // 현재 프레임 닫기
            }
        });

        // 중식 버튼
        JButton CBtn = new JButton("중식");
        CBtn.setBounds(240, 250, 90, 90);
        contentPane.add(CBtn);
        CBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CFood();  // CFood 클래스를 호출
                dispose();  // 현재 프레임 닫기
            }
        });

        // 양식 버튼
        JButton WBtn = new JButton("양식");
        WBtn.setBounds(340, 250, 90, 90);
        contentPane.add(WBtn);
        WBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WFood();  
                dispose();  
            }
        });

        setVisible(true);
    }
}
