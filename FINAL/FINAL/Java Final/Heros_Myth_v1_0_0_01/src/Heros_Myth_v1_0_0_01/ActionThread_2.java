package Heros_Myth_v1_0_0_01;

import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ActionThread_2 extends Rectangle implements Runnable {
	
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
    int enemy_x_2 = 0;
    int enemy_y_2 = 0;
    int enemy_blood = 0;

    ActionThread_2(int x, int y, int width, int height){
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    }
    
    public void run() {
    	ActionThread img1 = null;
    	JLabel label;
    	
            // �pstop��true�A�h����ʵe������
//            if (stop) {
//                break_actr_thread = 1;   // �P���u�{
//                break;      // ���X�`���A�����u�{������
//            }
            // �p�����񪬺A��(�Yflag=true)�A�h�}�l�]�w�Ϥ�
    	
    	while(true) {
    		
    		
            if (explo_1==1) {
                picturePath = "./resources/skill/firezone1.png";       // �]�m�Ϥ��s�񪺦�m���|
                
              
                
                
              
                // �]�m��ܤ��Ϥ�
                ImageIcon i = new ImageIcon(picturePath);
                label = new JLabel(i);
                if(Menu.player2_select == 3) {
                	label.setBounds(Matrix.player_1_x, Matrix.player_1_y, i.getIconWidth(), i.getIconHeight());
                }
                else if(Menu.player1_select == 3) {
                	label.setBounds(Matrix.player_2_x, Matrix.player_2_y, i.getIconWidth(), i.getIconHeight());
                }
                ///////////����m�Ϥ��Asleep��A��������m�A�P�_�O�_�����|�A�M�ᦩ��
                if(done ==1) {
                	if(Menu.player2_select == 3) {
                		img1 = new ActionThread(Matrix.player_1_x, Matrix.player_1_y-30, i.getIconWidth(), i.getIconHeight());
                	}
                	else if(Menu.player1_select == 3) {
                		img1 = new ActionThread(Matrix.player_2_x, Matrix.player_2_y-30, i.getIconWidth(), i.getIconHeight());
                	}
                	FrameSetting.jLayeredPane_main.add(label,JLayeredPane.POPUP_LAYER);
                	done = 0;
                }
                
                try {
                    Thread.sleep(100);      // ���u�{��v180�@���A�A�]�m�U�@�i�Ϥ�
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if(Menu.game_mode == 0) {
                	if(Menu.player2_select == 3) {
                		
                		enemy_x_2 = ActionThread_Blood.Npc1py*30;
                		enemy_y_2 = ActionThread_Blood.Npc1px*30;
                	}
                	else if(Menu.player1_select == 3) {
                		
                		enemy_x_2 = ActionThread_Blood.Npc2px*30;
                		enemy_y_2 = ActionThread_Blood.Npc2px*30;
                	}
                }
                else if (Menu.game_mode == 1) {
                	if(Menu.player2_select == 3) {
                		
                		enemy_x_2 = Matrix.player_2_x;
                		enemy_y_2 = Matrix.player_2_y;
                	}
                	else if(Menu.player1_select == 3) {
                		
                		enemy_x_2 = Matrix.player_1_x;
                		enemy_y_2 = Matrix.player_1_y;
                	}
                }
                
                
                
                ActionThread img2 = new ActionThread(enemy_x_2, enemy_y_2, 32, 32);
                if(img2.intersects(img1)) { 
                	System.out.println("y1"+Matrix.player_1_y);
                	System.out.println("y2"+enemy_y_2);
                	
                	if(Menu.game_mode == 0) {
                    	if(Menu.player2_select == 3) {
                    		ActionThread_Blood.npc1Blood = 1;
                    		
                    	}
                    	else if(Menu.player1_select == 3) {
                    		
                    		ActionThread_Blood.npc2Blood = 1;
                    	}
                    }
                    else if (Menu.game_mode == 1) {
                    	if(Menu.player2_select == 3) {
                    		
                    		ActionThread_Blood.p2Blood = 1;
                    	}
                    	else if(Menu.player1_select == 3) {
                    		
                    		ActionThread_Blood.p1Blood = 1;
                    	}
                    }
                }
                
                
                if(count==200) {
                	FrameSetting.jLayeredPane_main.remove(label);
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