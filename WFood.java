package Project_Kiosk;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WFood extends JFrame {
   public WFood() {
      setTitle("WFood");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(200, 200);
      setSize(500, 700);
      setLocation(500, 150);

      // 컨테이너
      Container contentPane = getContentPane();
      contentPane.setLayout(null);
      
      //장바구니 버튼
      JButton PBtn = new JButton("장바구니");
      PBtn.setBounds(370, 600, 100, 50);
      contentPane.add(PBtn);
               
      PBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      new Pay("", 0); 
      dispose(); 
          }
       });
      
         //검색버튼
         JButton SBtn = new JButton("검색");
         SBtn.setBounds(100, 50, 300, 30);
         contentPane.add(SBtn);
         
         //이미지1
        JButton K1  = new JButton();
        K1.setBounds(50, 120, 100, 100);
        contentPane.add(K1);

        ImageIcon buttonIconK1 = new ImageIcon("imgs/KakaoTalk_20250116_133858550_07.jpg");
        Image scaledButtonImageK1 = buttonIconK1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K1.setIcon(new ImageIcon(scaledButtonImageK1));

        K1.setBorderPainted(false);
        K1.setFocusPainted(false);
        K1.setContentAreaFilled(false);

        K1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
     // 레이블1
        JLabel lblNewLabel = new JLabel("치킨덮밥");
        lblNewLabel.setBounds(50, 130, 200, 30);
        contentPane.add(lblNewLabel);
        
        //이미지2 +(140)
        JButton K2  = new JButton();
        K2.setBounds(190, 120, 100, 100);
        contentPane.add(K2);

        ImageIcon buttonIconK2 = new ImageIcon("imgs/KakaoTalk_20250116_133858550_06.jpg");
        Image scaledButtonImageK2 = buttonIconK2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K2.setIcon(new ImageIcon(scaledButtonImageK2));

        K2.setBorderPainted(false);
        K2.setFocusPainted(false);
        K2.setContentAreaFilled(false);

        K2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
        //이미지3
        JButton K3  = new JButton();
        K3.setBounds(330, 120, 100, 100);
        contentPane.add(K3);

        ImageIcon buttonIconK3 = new ImageIcon("imgs/KakaoTalk_20250116_133858550_05.jpg");
        Image scaledButtonImageK3 = buttonIconK3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K3.setIcon(new ImageIcon(scaledButtonImageK3));

        K3.setBorderPainted(false);
        K3.setFocusPainted(false);
        K3.setContentAreaFilled(false);

        K3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
        
      //이미지4+(,140)
        JButton K4  = new JButton();
        K4.setBounds(50, 270, 100, 100);
        contentPane.add(K4);

        ImageIcon buttonIconK4 = new ImageIcon("imgs/KakaoTalk_20250116_133858550_04.jpg");
        Image scaledButtonImageK4 = buttonIconK4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K4.setIcon(new ImageIcon(scaledButtonImageK4));

        K4.setBorderPainted(false);
        K4.setFocusPainted(false);
        K4.setContentAreaFilled(false);

        K4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
        //이미지5 +(,140)
        JButton K5  = new JButton();
        K5.setBounds(190, 270, 100, 100);
        contentPane.add(K5);

        ImageIcon buttonIconK5 = new ImageIcon("imgs/KakaoTalk_20250116_133858550_03.jpg");
        Image scaledButtonImageK5 = buttonIconK5.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K5.setIcon(new ImageIcon(scaledButtonImageK5));

        K5.setBorderPainted(false);
        K5.setFocusPainted(false);
        K5.setContentAreaFilled(false);

        K5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
        //이미지6
        JButton K6  = new JButton();
        K6.setBounds(330, 270, 100, 100);
        contentPane.add(K6);

        ImageIcon buttonIconK6 = new ImageIcon("imgs/KakaoTalk_20250116_133858550_02.jpg");
        Image scaledButtonImageK6 = buttonIconK6.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K6.setIcon(new ImageIcon(scaledButtonImageK6));

        K6.setBorderPainted(false);
        K6.setFocusPainted(false);
        K6.setContentAreaFilled(false);

        K6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
      //이미지7+(,140)
        JButton K7  = new JButton();
        K7.setBounds(50, 410, 100, 100);
        contentPane.add(K7);

        ImageIcon buttonIconK7 = new ImageIcon("imgs/KakaoTalk_20250116_133858550_01.jpg");
        Image scaledButtonImageK7 = buttonIconK7.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K7.setIcon(new ImageIcon(scaledButtonImageK7));

        K7.setBorderPainted(false);
        K7.setFocusPainted(false);
        K7.setContentAreaFilled(false);

        K7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
        //이미지8 +(,140)
        JButton K8  = new JButton();
        K8.setBounds(190, 410, 100, 100);
        contentPane.add(K8);

        ImageIcon buttonIconK8 = new ImageIcon("imgs/KakaoTalk_20250116_133858550.jpg");
        Image scaledButtonImageK8 = buttonIconK8.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K8.setIcon(new ImageIcon(scaledButtonImageK8));

        K8.setBorderPainted(false);
        K8.setFocusPainted(false);
        K8.setContentAreaFilled(false);

        K8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
        //이미지9
        JButton K9  = new JButton();
        K9.setBounds(330, 410, 100, 100);
        contentPane.add(K9);

        ImageIcon buttonIconK9 = new ImageIcon("imgs/KakaoTalk_20250116_133858550_07.jpg");
        Image scaledButtonImageK9 = buttonIconK9.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        K9.setIcon(new ImageIcon(scaledButtonImageK9));

        K9.setBorderPainted(false);
        K9.setFocusPainted(false);
        K9.setContentAreaFilled(false);

        K9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrdingFood();
                dispose();
            }
        });
        
   
        
      setVisible(true);
   }

   public static void main(String[] args) {
      WFood wf = new WFood();
   }
}

