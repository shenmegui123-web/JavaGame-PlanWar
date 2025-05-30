package com.lfq.utils;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class FrameListener extends JFrame implements ActionListener {
    //输出入框的对象
    JTextField input;
    public void actionPerformed(ActionEvent e){
        //获取内容
        String name = input.getText();
        String password = input.getText();
        //自己设置账号密码
        if(name.equals("1022") |password.equals("1234")){
            dispose();
            GameWin gameWin=new GameWin();
            gameWin.setSize(600,800);
            gameWin.setTitle("lfq");
            gameWin.setVisible(true);
        }
        else{
            System.out.println("登录错误");
        }
    }
}
