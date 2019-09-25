package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JFrame MainFrame = new JFrame("Fitness Management System");
    private Container container = MainFrame.getContentPane();

    public MainFrame(){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screen.width/2;
        int height = screen.height/2;
        MainFrame.setBounds(5,5,width,height);
        container.setLayout(new BorderLayout());
        MainFrame.setResizable(false);
        MainFrame.setLocationRelativeTo(null);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        MainFrame.setVisible(true);
    }

    public void init(){
        
    }
}
