package Heros_Myth_v1_0_0_01;

import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ActionThread_5 extends Rectangle implements Runnable{
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

    int my_x = 0;
    int my_y = 0;
    JLabel label;
 
    ActionThread_5(int x, int y, int width, int height){
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
                picturePath = "./resources/skill/protect.gif";       // �]�m�Ϥ��s�񪺦�m���|
                
               
                
                
              
                // �]�m��ܤ��Ϥ�
                ImageIcon i = new ImageIcon(picturePath);
               
                
                
                if(Menu.player2_select == 6) {
            		my_x = Matrix.player_1_x;
                	my_y = Matrix.player_1_y;
                	if(ActionThread_Blood.p1Blood <3) {
                		ActionThread_Blood.p1Blood = ActionThread_Blood.p1Blood +1;
                		if ( ActionThread_Blood.p1Blood == 3) {

							ActionThread_Blood.jLabel_heart1_1.setVisible(true);
							ActionThread_Blood.jLabel_heart1_2.setVisible(true);
							ActionThread_Blood.jLabel_heart1_3.setVisible(true);
						}
                	}
            	}
            	else if(Menu.player1_select == 6) {
            		my_x = Matrix.player_2_x;
                	my_y = Matrix.player_2_y;
                	if(ActionThread_Blood.p2Blood <3) {
                		ActionThread_Blood.p2Blood = ActionThread_Blood.p2Blood +1;
                		if ( ActionThread_Blood.p2Blood == 3) {

							ActionThread_Blood.jLabel_heart2_1.setVisible(true);
							ActionThread_Blood.jLabel_heart2_2.setVisible(true);
							ActionThread_Blood.jLabel_heart2_3.setVisible(true);
						}
                	}
            	}
                
            	
            	
        		label = new JLabel(i);
        		label.setBounds(my_x-60, my_y-60, i.getIconWidth(), i.getIconHeight());
        		FrameSetting.jLayeredPane_main.add(label,JLayeredPane.POPUP_LAYER);
                
                
        		try {
                    Thread.sleep(500);      // ���u�{��v180�@��A�A�]�m�U�@�i�Ϥ�
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        		FrameSetting.jLayeredPane_main.remove(label);
                
                
                
 
                
                try {
                    Thread.sleep(500);      // ���u�{��v180�@��A�A�]�m�U�@�i�Ϥ�
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//  
                
            
                index++;
                
                System.out.println("!!!");
                if(index == 10) {
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
