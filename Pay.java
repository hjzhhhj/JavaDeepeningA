package Project_Kiosk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Pay {
    private DefaultListModel<String> cartListModel;

    public Pay(String menuName, int price) {
        // 메인 프레임 생성
        JFrame frame = new JFrame("장바구니");  // 창 제목 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창을 닫으면 프로그램 종료
        frame.setSize(500, 700);  // 창 크기 설정
        frame.setLayout(new BorderLayout());
        frame.setLocation(200, 200);// 레이아웃 설정
        frame.setLocation(500, 150);

        // 입력 필드와 버튼을 위한 패널 생성
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 3, 10, 10));  // 3x3 그리드 레이아웃 설정, 간격 10px

        // 메뉴명과 가격을 위한 라벨 및 텍스트 필드
        JLabel menuLabel = new JLabel("메뉴명:");  // 메뉴명 라벨
        JTextField menuField = new JTextField(menuName);  // 메뉴명 입력 필드
        menuField.setEditable(true);  // 메뉴명 필드는 편집 가능
        JLabel priceLabel = new JLabel("가격:");  // 가격 라벨
        JTextField priceField = new JTextField(String.valueOf(price));  // 가격 입력 필드
        priceField.setEditable(true);  // 가격 필드는 편집 가능

        // 수량 조정 버튼
        JLabel quantityLabel = new JLabel("수량:");  // 수량 라벨
        JButton minusButton = new JButton("-");  // 감소 버튼
        JButton plusButton = new JButton("+");  // 증가 버튼
        JTextField quantityField = new JTextField("1");  // 기본 수량은 1
        quantityField.setEditable(false);  // 수량 필드는 편집 불가

        // 컴포넌트를 입력 패널에 추가
        inputPanel.add(menuLabel);  // 메뉴명 라벨 추가
        inputPanel.add(menuField);  // 메뉴명 입력 필드 추가
        inputPanel.add(priceLabel);  // 가격 라벨 추가
        inputPanel.add(priceField);  // 가격 입력 필드 추가
        inputPanel.add(quantityLabel);  // 수량 라벨 추가
        inputPanel.add(minusButton);  // 감소 버튼 추가
        inputPanel.add(quantityField);  // 수량 텍스트 필드 추가
        inputPanel.add(plusButton);  // 증가 버튼 추가

        // 아이템을 장바구니에 추가하는 버튼
        JButton addButton = new JButton("담기");  // '담기' 버튼 생성
        inputPanel.add(new JLabel());  // 간격을 위한 빈 셀 추가
        inputPanel.add(addButton);  // 버튼을 입력 패널에 추가

        // 삭제 버튼
        JButton deleteButton = new JButton("삭제");  // '삭제' 버튼 생성
        inputPanel.add(deleteButton);  // 삭제 버튼을 추가

        // 주문하기 버튼
        JButton orderButton = new JButton("주문하기");  // '주문하기' 버튼 생성
        inputPanel.add(orderButton);  // 주문하기 버튼을 추가

        // 장바구니를 표시하기 위한 텍스트 영역
        cartListModel = new DefaultListModel<>();
        JList<String> cartList = new JList<>(cartListModel);
        JScrollPane scrollPane = new JScrollPane(cartList);  // 스크롤이 가능하도록 JScrollPane에 장바구니 리스트 추가

        // 입력 패널과 스크롤 패인을 프레임에 추가
        frame.add(inputPanel, BorderLayout.NORTH);  // 상단에 입력 패널 추가
        frame.add(scrollPane, BorderLayout.CENTER);  // 중앙에 장바구니 리스트 추가

        // 수량 조정 기능
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(quantityField.getText().trim());
                if (quantity > 1) {  // 수량이 1보다 크면 감소
                    quantity--;
                    quantityField.setText(String.valueOf(quantity));
                }
            }
        });

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(quantityField.getText().trim());
                quantity++;  // 수량 증가
                quantityField.setText(String.valueOf(quantity));
            }
        });

        // '담기' 버튼에 액션 리스너 추가
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String menuName = menuField.getText().trim();  // 메뉴명 입력 필드에서 텍스트 가져오기
                String priceText = priceField.getText().trim();  // 가격 입력 필드에서 텍스트 가져오기
                String quantityText = quantityField.getText().trim();  // 수량 텍스트 필드에서 텍스트 가져오기

                // 입력 값이 비어있는 경우 오류 메시지 출력
                if (menuName.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "메뉴명, 가격, 수량을 모두 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // 가격을 숫자로 변환
                    double price = Double.parseDouble(priceText);
                    int quantity = Integer.parseInt(quantityText);  // 수량을 숫자로 변환
                    DecimalFormat df = new DecimalFormat("#");  // 가격을 소수점 없이 정수로 포맷
                    String formattedPrice = df.format(price);  // 가격 포맷팅
                    double totalPrice = price * quantity;  // 총 가격 계산
                    // 장바구니에 메뉴명, 가격, 수량 추가
                    cartListModel.addElement(menuName + " - " + formattedPrice + "원 x " + quantity + " = " + df.format(totalPrice) + "원");
                    menuField.setText("");  // 메뉴명 입력 필드 초기화
                    priceField.setText("");  // 가격 입력 필드 초기화
                    quantityField.setText("1");  // 수량 필드 초기화
                } catch (NumberFormatException ex) {
                    // 가격이나 수량이 숫자가 아닌 경우 오류 메시지 출력
                    JOptionPane.showMessageDialog(frame, "가격과 수량은 숫자로 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // '삭제' 버튼에 액션 리스너 추가
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JList에서 선택된 항목을 삭제
                int selectedIndex = cartList.getSelectedIndex();
                if (selectedIndex != -1) {
                    cartListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "삭제할 항목을 선택해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // '주문하기' 버튼에 액션 리스너 추가
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 주문 내용과 총액 계산
                if (cartListModel.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "장바구니에 아이템이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double total = 0;
                StringBuilder orderDetails = new StringBuilder("주문 내역:\n");

                for (int i = 0; i < cartListModel.size(); i++) {
                    String item = cartListModel.get(i);
                    orderDetails.append(item).append("\n");
                    String priceText = item.split(" = ")[1].replace("원", "").trim();
                    total += Double.parseDouble(priceText);
                }

                // 주문 내역과 총액 표시
                DecimalFormat df = new DecimalFormat("#,###");
                orderDetails.append("총액: ").append(df.format(total)).append("원");
                JOptionPane.showMessageDialog(frame, orderDetails.toString(), "주문 완료", JOptionPane.INFORMATION_MESSAGE);

                // 장바구니 초기화
                cartListModel.clear();
            }
        });

        // 프레임 표시
        frame.setVisible(true);  // 프레임을 화면에 표시
    }
}
