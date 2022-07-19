package Extension;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class End_Game extends Parameter{
    private ImageIcon p1_icon;
    private ImageIcon p2_icon;
    public JFrame jframe = new JFrame();
    public JButton btn_t=new JButton(new ImageIcon("./resources/end_game/backhome.png"));
    public End_Game(String player1_path,String player2_path) {
        p1_icon=new ImageIcon(player2_path);
        p2_icon=new ImageIcon(player1_path);

        jframe.setSize(654, 486+80);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon alive=new ImageIcon("./resources/end_game/alive.png");
        ImageIcon dead=new ImageIcon("./resources/end_game/dead.png");
        ImageIcon background_icon=new ImageIcon("./resources/end_game/background.jpg");
        ImageIcon title_icon=new ImageIcon("./resources/end_game/title.png");
        ImageIcon npc2_icon=new ImageIcon("./resources/end_game/NPC_02.png");
        ImageIcon npc1_icon=new ImageIcon("./resources/end_game/NPC_01.png");

        JLabel background=new JLabel(background_icon);
        JLabel title=new JLabel(title_icon);
        JLabel npc2=new JLabel(npc2_icon);
        JLabel npc1=new JLabel(npc1_icon);
        JLabel p2=new JLabel(p2_icon);
        JLabel p1=new JLabel(p1_icon);

        JLabel tnpc1,tnpc2,tp1,tp2;
        tnpc1 =(judgementNPC1==-1)? new JLabel(alive):new JLabel(dead);
        tnpc2=(judgementNPC2==-1)? new JLabel(alive):new JLabel(dead);
        tp1=(judgement1==-1)? new JLabel(alive):new JLabel(dead);
        tp2=(judgement2==-1)? new JLabel(alive):new JLabel(dead);

        tnpc1.setBounds(100,200,100,30);
        tnpc2.setBounds(100,250,100,30);
        tp1.setBounds(100,300,100,30);
        tp2.setBounds(100,350,100,30);

        background.setBounds(0,0,640,540);
        title.setBounds(120,20,420,123);
        npc1.setBounds(50,200,30,30);
        npc2.setBounds(50,250,30,30);
        p1.setBounds(50,300,32,32);
        p2.setBounds(50,350,32,32);

        btn_t.setBounds(250,400,150,60);
        btn_t.setBackground(Color.BLACK);
        btn_t.setBorder(null);

        btn_t.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource());
                if (e.getSource()==btn_t){
                    System.exit(0);
                    stopAllThread=-1;
                }
            }
        });
        btn_t.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==10){
                    btn_t.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        jframe.add(tnpc1);
        jframe.add(tnpc2);
        jframe.add(tp1);
        jframe.add(tp2);

        jframe.add(title);
        jframe.add(npc2);
        jframe.add(npc1);
        jframe.add(p1);
        jframe.add(p2);
        jframe.add(btn_t);
        jframe.add(background);
        jframe.setVisible(true);
    }
}
