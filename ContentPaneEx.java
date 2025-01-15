import java.awt.*;
import javax.swing.*;

public class ContentPaneEx extends JFrame{
	public ContentPaneEx() {
		setTitle("ContenetPane과 JFRame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫음과 동시에 프로그램 종료
		
		 Container contentPane = getContentPane();
		 contentPane.setBackground(Color.orange);
		 contentPane.setLayout(new FlowLayout());
		 
		 contentPane.add(new JButton("OK"));
		 contentPane.add(new JButton("Cancel"));
		 contentPane.add(new JButton("Ignore"));
		 
		 setSize(300,150);
		 setVisible(true);

		 
	}
	public static void main(String[] args) {
		new ContentPaneEx();
	}

}