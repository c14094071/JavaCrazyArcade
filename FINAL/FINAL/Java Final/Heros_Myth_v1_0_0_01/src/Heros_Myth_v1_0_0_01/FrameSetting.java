package Heros_Myth_v1_0_0_01;

import Extension.Parameter;

import javax.swing.*;
import java.awt.*;

public class FrameSetting extends Parameter {

    public FrameSetting(int width,int height){
        // JFrame
        // JFrame jFrame_main = new JFrame();
    	Menu m = new Menu();
        jFrame_main.setSize(width, height+80);
        System.out.println("width"+width);
        System.out.println("height"+height);
        jFrame_main.setResizable(false);
        jFrame_main.setLocationRelativeTo(null);
        jFrame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // JLayeredPane
        // JLayeredPane jLayeredPane_main = new JLayeredPane();
    }
}
