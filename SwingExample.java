package InT2;

import javax.swing.*;

public class SwingExample {
    public static void main(String[] args) {
        // Event Dispatch Thread에서 실행
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JLabel label = new JLabel("Hello, Swing!", SwingConstants.CENTER);
            frame.add(label);

            frame.setVisible(true);
        });
    }
}
