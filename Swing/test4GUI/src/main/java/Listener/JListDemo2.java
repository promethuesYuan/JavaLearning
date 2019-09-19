package main.java.Listener;

import main.java.List.ListDemo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class JListDemo2 extends JFrame {
    JList list;
    JLabel label;
    public JListDemo2(){
        setTitle("监听列表项选择事件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1000,300,500,500);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        label = new JLabel(" ");
        contentPane.add(label, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        list = new JList();
        scrollPane.setViewportView(list);
        String[] listData = new String[7];
        listData[0] = "java";
        listData[1] = "c++";
        listData[2] = "c";
        listData[3] = "python";
        listData[4] = "php";
        listData[5] = "javascript";
        listData[6] = "html";
        list.setListData(listData);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChange(e);
            }
        });
    }

    protected void do_list_valueChange(ListSelectionEvent e){
        label.setText("感谢您购买："+list.getSelectedValue());
    }

    public static void main(String[] args) {
        JListDemo2 frame = new JListDemo2();
        frame.setVisible(true);
    }
}
