import java.awt.*;
import javax.swing.*;

public class FlowLayoutEx extends JFrame{
	public FlowLayoutEx() {
		setTitle("FlowLayout sampleFlowLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫음과 동시에 프로그램 종료
		
		 Container c = getContentPane();
		 c.setLayout(new FlowLayout(FlowLayout.LEFT,30,40));
		 
		 c.add(new JButton("add"));
		 c.add(new JButton("sub"));
		 c.add(new JButton("mul"));
		 c.add(new JButton("div"));
		 c.add(new JButton("Calculate"));
		 
		 setSize(300,200);
		 setVisible(true);

		 
	}
	public static void main(String[] args) {
		new FlowLayoutEx();
	}

}