import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Memo extends JFrame {
    private JTextArea textArea;

    public Memo () {
        setTitle("메모장");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 텍스트 영역 초기화
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // 메뉴바 및 메뉴 생성
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        // 메뉴 항목 생성
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem openItem = new JMenuItem("Open");

        // 메뉴 항목에 리스너 추가
        saveItem.addActionListener(new SaveAction());
        openItem.addActionListener(new OpenAction());

        // 메뉴에 항목 추가
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);

        // 프레임에 메뉴바 설정
        setJMenuBar(menuBar);
    }

    private class SaveAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            //저장 버튼을 눌렀는지
            if (fileChooser.showSaveDialog(Memo.this) == JFileChooser.APPROVE_OPTION) {
            	
            	//선택한 파일을 오픈!
                File file = fileChooser.getSelectedFile();
                try (PrintWriter writer = new PrintWriter(file)) {
                	
                	//파일 이름 쓰기
                    writer.write(textArea.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private class OpenAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	//파일 선택
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(Memo.this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.setText(""); // 기존 텍스트 지우기
                    String line;
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
    	// 익명 함수 
    	// 충돌을 막기위해서 사용함
        // 차근차근 할 수 있게 도와줌
        SwingUtilities.invokeLater(() -> {
            Memo notepad = new Memo();
            notepad.setVisible(true);
        });
    }
}