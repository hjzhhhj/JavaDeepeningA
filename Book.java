import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Book extends JFrame{
    public Book(){
        setTitle("도서 관리 프로그램");
        setSize(900,1200);
        setVisible(true);
    }
    public static void main(String[] args){
        Book book = new Book();

    }
}