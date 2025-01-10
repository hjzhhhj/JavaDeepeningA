import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class IndepClassListener extends JFrame {
    public IndepClassListener(){
        setTitle("Action 이벤트 리스너 연습");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args){
        new IndepClassListener();
        }
        class MyActionListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action")){
                    b.setText("액션");
                }
                else{
                    b.setText("Action");
                }
            }
        }
}