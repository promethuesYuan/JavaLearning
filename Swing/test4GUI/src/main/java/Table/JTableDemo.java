package main.java.Table;

import javax.swing.*;
import java.awt.*;

public class JTableDemo {
    public static void main(String[] agrs)
    {
        JFrame frame=new JFrame("学生成绩表");
        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane=frame.getContentPane();
        Object[][] tableDate=new Object[5][8];
        for(int i=0;i<5;i++)
        {
            tableDate[i][0]="1000"+i;
            for(int j=1;j<8;j++)
            {
                tableDate[i][j]=0;
            }
        }
        String[] name={"学号","软件工程","Java","网络","数据结构","数据库","总成绩","平均成绩"};
        JTable table=new JTable(tableDate,name);
        contentPane.add(new JScrollPane(table));
        frame.setVisible(true);
    }
}
