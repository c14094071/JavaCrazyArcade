package Heros_Myth_v1_0_0_01;

import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ActionThread_1 extends Rectangle implements Runnable{
	private int index = 0;  // �Ω󱱨�Ϥ����s��
    Main_App main = new Main_App();
    KeyListen kyls = new KeyListen();
    
    String picturePath;
    int count = 0;
    boolean flag = true;                    // �Ω�Хܰʵe�O�_���}�l����(/�Ȱ�/�~��)�����A
    boolean stop = false; 
    int break_actr_thread = 0;
    public static int explo_1 = 0;
    ActionThread_1(int x, int y, int width, int height){
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    }
    
    public void run() {
    	

    	
            // �pstop��true�A�h����ʵe������
//            if (stop) {
//                break_actr_thread = 1;   // �P���u�{
//                break;      // ���X�`���A�����u�{������
//            }
            // �p�����񪬺A��(�Yflag=true)�A�h�}�l�]�w�Ϥ�
    	
    	while(true) {
    		
    		
            if (explo_1==1) {
                String picture = "./resources/skill/vampire/vampire_";       // �]�m�Ϥ��s�񪺦�m���|
                
                index++;
                if (index <= 8) {       // �ʵe�ϥܦ@��8�i�A�H����@���`���o8�i��
                    picturePath = picture + index + ".png";
                    System.out.println(picturePath);
                }
                else if (index == 9) {
                	break;
                }
                
                
              
                // �]�m��ܤ��Ϥ�
                ImageIcon i = new ImageIcon(picturePath);
                JLabel label = new JLabel(i);
        		
                ///////////����m�Ϥ��Asleep��A��������m�A�P�_�O�_�����|�A�M�ᦩ��
                if(Menu.player2_select == 2) {
                	label.setBounds(Matrix.player_1_x-24, Matrix.player_1_y-24, i.getIconWidth(), i.getIconHeight());
                }
                else if(Menu.player1_select == 2) {
                	label.setBounds(Matrix.player_2_x-24, Matrix.player_2_y-24, i.getIconWidth(), i.getIconHeight());
                }
                
                
                
                FrameSetting.jLayeredPane_main.add(label,JLayeredPane.POPUP_LAYER);
                count = count + 1;
                
           
                if (count == 1) { 
                	System.out.println("!!!");
                	if(Menu.game_mode == 0) {
                    	if(Menu.player2_select == 2) {
                    		ActionThread_Blood.npc1Blood = ActionThread_Blood.npc1Blood-1;
                    		
                    	}
                    	else if(Menu.player1_select == 2) {
                    		
                    		ActionThread_Blood.npc2Blood = ActionThread_Blood.npc2Blood-1;
                    	}
                    }
                    else if (Menu.game_mode == 1) {
                    	if(Menu.player2_select == 2) {
                    		
                    		ActionThread_Blood.p2Blood = ActionThread_Blood.p2Blood-1;
                    	}
                    	else if(Menu.player1_select == 2) {
                    		
                    		ActionThread_Blood.p1Blood = ActionThread_Blood.p1Blood-1;
                    	}
                    }
                	
                }
                try {
                    Thread.sleep(100);      // ���u�{��v180�@��A�A�]�m�U�@�i�Ϥ�
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
                
                FrameSetting.jLayeredPane_main.remove(label);
                
                
                
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
    	}
    	
    }

}
