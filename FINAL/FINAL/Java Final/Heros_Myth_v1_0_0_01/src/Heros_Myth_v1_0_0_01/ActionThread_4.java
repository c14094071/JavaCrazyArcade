package Heros_Myth_v1_0_0_01;

import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ActionThread_4 extends Rectangle implements Runnable {
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
 
    ActionThread_4(int x, int y, int width, int height){
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
                picturePath = "./resources/skill/teleport.gif";       // �]�m�Ϥ��s�񪺦�m���|
                
               index++;
                
                
              
                // �]�m��ܤ��Ϥ�
                ImageIcon i = new ImageIcon(picturePath);
                JLabel label = new JLabel(i);
                if(Menu.player2_select == 5) {
                	label.setBounds(Matrix.player_2_x-60, Matrix.player_2_y-80, i.getIconWidth(), i.getIconHeight());
                }
                else if(Menu.player1_select == 5) {
                	label.setBounds(Matrix.player_2_x-60, Matrix.player_2_y-80, i.getIconWidth(), i.getIconHeight());
                }
                FrameSetting.jLayeredPane_main.add(label,JLayeredPane.POPUP_LAYER);
                
                
                if(done ==1) {
                	if(Menu.game_mode == 0) {
                    	if(Menu.player1_select == 5) {
                    		Matrix.player_1_x = Matrix.player_2_x;
                        	Matrix.player_1_y = Matrix.player_2_y;
                        	done = 0; //�ǰe��i�ۥѲ���
                    	}
                    	else if(Menu.player2_select == 5) {
                    		Matrix.player_2_x = Matrix.player_1_x;
                        	Matrix.player_2_y = Matrix.player_1_y;
                        	done = 0; //�ǰe��i�ۥѲ���
                    	}
                    }
                    else if (Menu.game_mode == 1) {
                    	if(Menu.player2_select == 5) {
                    		Matrix.player_2_x = Matrix.player_1_x;
                        	Matrix.player_2_y = Matrix.player_1_y;
                        	
                    	}
                    	else if(Menu.player1_select == 5) {
                    		Matrix.player_1_x = Matrix.player_2_x;
                        	Matrix.player_1_y = Matrix.player_2_y;
                        	
                    	}
                    }
                	

                }
                
                
                
                
  
                
                
                try {
                    Thread.sleep(10);      // ���u�{��v180�@��A�A�]�m�U�@�i�Ϥ�
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
               
                FrameSetting.jLayeredPane_main.remove(label);
                
                System.out.println("!!!");
                if(index == 100) {
                	
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
