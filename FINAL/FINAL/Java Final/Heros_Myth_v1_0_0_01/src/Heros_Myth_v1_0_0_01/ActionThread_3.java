package Heros_Myth_v1_0_0_01;

import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ActionThread_3 extends Rectangle implements Runnable{
	private int index = 0;  // �Ω󱱨�Ϥ����s��
    Main_App main = new Main_App();
    KeyListen kyls = new KeyListen();
    
    String picturePath;
    int count = 0;
    boolean flag = true;                    // �Ω�Хܰʵe�O�_���}�l����(/�Ȱ�/�~��)�����A
    boolean stop = false; 
    int break_actr_thread = 0;
    public static int explo_1 = 0;
    int done = 1;
    int kill = 0;
    int enemy_x_4 = 0;
    int enemy_y_4 = 0;
    ActionThread_3(int x, int y, int width, int height){
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    }
    
    public void run() {
    	ActionThread img1 = null;

    	
            // �pstop��true�A�h����ʵe������
//            if (stop) {
//                break_actr_thread = 1;   // �P���u�{
//                break;      // ���X�`���A�����u�{������
//            }
            // �p�����񪬺A��(�Yflag=true)�A�h�}�l�]�w�Ϥ�
    	
    	while(true) {
    		
    		
            if (explo_1==1) {
                picturePath = "./resources/skill/bling2.gif";       // �]�m�Ϥ��s�񪺦�m���|
                
               index++;
                
                
              
                // �]�m��ܤ��Ϥ�
                ImageIcon i = new ImageIcon(picturePath);
                JLabel label = new JLabel(i);
                if(Menu.game_mode == 0) {
                	if(Menu.player2_select == 4) {
                		
                		enemy_x_4 = ActionThread_Blood.Npc1py*30;
                		enemy_y_4 = ActionThread_Blood.Npc1px*30;
                	}
                	else if(Menu.player1_select == 4) {
                		
                		enemy_x_4 = ActionThread_Blood.Npc2px*30;
                		enemy_y_4 = ActionThread_Blood.Npc2px*30;
                	}
                }
                else if (Menu.game_mode == 1) {
                	if(Menu.player2_select == 4) {
                		System.out.print("�ڬOplayer1");
                		
                		enemy_x_4 = Matrix.player_2_x;
                		enemy_y_4 = Matrix.player_2_y;
                	}
                	else if(Menu.player1_select == 4) {
                		
                		enemy_x_4 = Matrix.player_1_x;
                		enemy_y_4 = Matrix.player_1_y;
                	}
                }
                
                label.setBounds(enemy_x_4-170, enemy_y_4-132, i.getIconWidth(), i.getIconHeight());
                
                ///////////����m�Ϥ��Asleep��A��������m�A�P�_�O�_�����|�A�M�ᦩ��
                FrameSetting.jLayeredPane_main.add(label,JLayeredPane.POPUP_LAYER);
                if(done ==1) {
                	img1 = new ActionThread(enemy_x_4-170, enemy_y_4-132, i.getIconWidth(), i.getIconHeight());
                	
                	done = 0;
                }
                
                
                
  
                
                ActionThread img2 = new ActionThread(enemy_x_4, enemy_y_4, 32, 32);
                if(img2.intersects(img1) && kill==0) { 
                	if(Menu.game_mode == 0) {
                    	if(Menu.player2_select == 4) {
                    		ActionThread_Blood.npc1Blood = ActionThread_Blood.npc1Blood-1;
                    		
                    	}
                    	else if(Menu.player1_select == 4) {
                    		
                    		ActionThread_Blood.npc2Blood = ActionThread_Blood.npc2Blood-1;
                    	}
                    }
                    else if (Menu.game_mode == 1) {
                    	if(Menu.player2_select == 4) {
                    		
                    		ActionThread_Blood.p2Blood = ActionThread_Blood.p2Blood-1;
                    	}
                    	else if(Menu.player1_select == 4) {
                    		
                    		ActionThread_Blood.p1Blood = ActionThread_Blood.p1Blood-1;
                    	}
                    }

                	kill = 1;
                }
                
                try {
                    Thread.sleep(500);      // ���u�{��v180�@��A�A�]�m�U�@�i�Ϥ�
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                FrameSetting.jLayeredPane_main.remove(label);
                System.out.println("!!!");
                if(index == 6) {
                	
	                break;
                }
                
                
                
                
                
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
