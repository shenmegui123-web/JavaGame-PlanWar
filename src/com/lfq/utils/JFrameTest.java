package com.lfq.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class JFrameTest {
    public static void main(String args []){
        //创建对象
        JFrameTest tf=new JFrameTest();
        //使用对象调用方法
        tf.showFrame();
    }

    public void showFrame() {
        //创建一个窗体
        JFrame frame=new JFrame();
        //设置窗体标题
        frame.setTitle("登录界面");
        //设置窗体大小
        frame.setSize(600,510);
        //创建一个布局方式
        FlowLayout layout = new FlowLayout();
        //设置窗体的布局方式
        frame.setLayout(layout);
        //创建图片对象
        ImageIcon icon = new ImageIcon("E:\\idea\\PlaneWar\\imgs\\qq.png");
        //创建一个图片标签对象
        JLabel iconLabel = new JLabel(icon);
        //添加图片标签对象到窗体上
        frame.add(iconLabel);
        //创建一个显示文字的标签
        JLabel iconaLabel = new JLabel("                      QQ");
        frame.add(iconaLabel);
        //创建一个输入框对象
        JTextField namelnput = new JTextField();
        //设置输入框的大小
        Dimension inputSize = new Dimension(400,30);
        namelnput.setPreferredSize(inputSize);
        //添加输入框到窗体上
        frame.add(namelnput);
        //创建一个复选框
        JCheckBox fuxuankuang = new JCheckBox("显示QQ");
        //添加复选框到窗体上
        frame.add(fuxuankuang);

        //创建密码标签
        JLabel iconbLabel = new JLabel("                      密码");
        //添加标签到窗体上
        frame.add(iconbLabel);
        //创建一个密码输入框
        JPasswordField jpf = new JPasswordField("密码");

        //设置输入框的大小
        Dimension inputeSize = new Dimension(400,30);
        jpf.setPreferredSize(inputeSize);

        //添加输入框到窗体上
        frame.add(jpf);

        //创建一个复选框
        JCheckBox fuxukuang = new JCheckBox("显示密码");
        frame.add(fuxukuang);
        //创建按钮
        JButton btn = new JButton("登录");
        JButton btnn = new JButton("注册");
        //添加按钮
        frame.add(btn);
        frame.add(btnn);
        //设置按钮颜色
        btn.setForeground(Color.GREEN);
        //设置背景颜色
        btn.setBackground(new Color(100,100,100));

        btnn.setForeground(Color.GREEN);
        //设置背景颜色
        btnn.setBackground(new Color(100,100,100));

        //创建监听器对象
        FrameListener jiantingqi = new FrameListener();
        //给按钮添加监听器
        btn.addActionListener(jiantingqi);
        //给监听器的属性赋值
        jiantingqi.input=namelnput;
        jiantingqi.input=jpf;

        //创建监听器对象
        FrameListener jianting = new FrameListener();
        //给按钮添加监听器
        btnn.addActionListener(jianting);
        //给监听器的属性赋值
        jianting.input=namelnput;
        jianting.input=jpf;

        //设置窗体可见
        frame.setVisible(true);
    }

}

