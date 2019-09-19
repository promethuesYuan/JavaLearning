package main.java.Sample;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SampeDemo {
    private JPanel panel = new JPanel();
    private JComboBox cmb = new JComboBox();
    private JLabel label = new JLabel("添加新星座");
    private JLabel showinfo = new JLabel();
    private JTextField jtf = new JTextField(16);
    private JButton buttonAdd = new JButton("新增");
    private JButton buttonDel = new JButton("删除");

    public SampeDemo(){
        JFrame frame = new JFrame("选择你的星座");
        cmb.addItem("--请选择--");
        cmb.addItem("巨蟹座");
        cmb.addItem("狮子座");
        cmb.addItem("双鱼座");
        panel.add(cmb);
        panel.add(label);
        panel.add(jtf);
        panel.add(buttonAdd);
        panel.add(buttonDel);
        frame.add(panel);
        buttonAdd.addActionListener(new MyActionListener());
        buttonDel.addActionListener(new MyActionListener());
        cmb.addItemListener(new MyItemListener());
        frame.setBounds(300,200,600,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class MyItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            String string = e.getItem().toString();
            panel.add(showinfo);
            showinfo.setText("您选择的星座是"+string);
        }
    }

    class MyActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String command=e.getActionCommand();
            //添加按钮处理
            if(command.equals("新增"))
            {
                if(jtf.getText().length()!=0)
                {
                    cmb.addItem(jtf.getText());    //添加项
                    panel.add(showinfo);
                    showinfo.setText("添加成功，新增了："+jtf.getText());
                }
                else
                {
                    panel.add(showinfo);
                    showinfo.setText("请输入要添加星座");
                }
            }
            //删除按钮处理
            if(command.equals("删除"))
            {
                if(cmb.getSelectedIndex()!=-1)
                {
                    //先获得要删除的项的值
                    String strDel=cmb.getSelectedItem().toString();
                    cmb.removeItem(strDel);    //删除项
                    panel.add(showinfo);
                    showinfo.setText("删除成功，删除了："+strDel);
                }
                else
                {
                    panel.add(showinfo);
                    showinfo.setText("请选择要删除的星座");
                }
            }
        }
    }


    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.translucencyAppleLike;
            UIManager.put("RootPane.setupButtonVisible", false);
            BeautyEyeLNFHelper.launchBeautyEyeLNF();

        } catch (Exception e) {
            e.printStackTrace();
        }

        new SampeDemo();
    }
}

