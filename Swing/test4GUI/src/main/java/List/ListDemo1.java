package main.java.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ListDemo1 extends JFrame{
    public ListDemo1(){
        setTitle("Java列表框组件示例");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置窗体退出时操作
        setBounds(300,300,500,500);    //设置窗体位置和大小
        JPanel contentPane=new JPanel();    //创建内容面板
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));    //设置面板的边框
        contentPane.setLayout(new BorderLayout(0, 0));    //设置内容面板为边界布局
        setContentPane(contentPane);    //应用内容面板
        JScrollPane scrollPane=new JScrollPane();    //创建滚动面板
        contentPane.add(scrollPane,BorderLayout.CENTER);    //将面板增加到边界布局中央
        JList list=new JList();
        //限制只能选择一个元素
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(list);    //在滚动面板中显示列表
        String[] listData=new String[12];    //创建一个含有12个元素的数组
        for (int i=0;i<listData.length;i++)
        {
            listData[i]="这是列表框的第"+(i+1)+"个元素~";    //为数组中各个元素赋值
        }
        list.setListData(listData);    //为列表填充数据
    }

    public static void main(String[] args) {
        ListDemo1 frame = new ListDemo1();
        frame.setVisible(true);
    }
}
