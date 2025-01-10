import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerclassListener extends JFrame {
    public InnerclassListener(){
        setTitle("내부 클래스 연습");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener() );

        c.add(btn);
        setSize(350,200);
        setVisible(true);

    }
    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton b =(JButton)e.getSource();
            if(b.getText().equals("Action")){
                b.setText("액션");
            }
            else{
                b.setText("Action");
            }
            InnerclassListener.this.setTitle(b.getText());
        }
    }
    public static void main(String[] args){
        new InnerclassListener();
    }
}