package Heros_Myth_v1_0_0_01;

import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ActionThread_5 extends Rectangle implements Runnable{
	private int index = 0;  // 用於控制圖片的編號
    Main_App main = new Main_App();
    KeyListen kyls = new KeyListen();
    
    String picturePath;
    int count = 0;
    boolean flag = true;                    // 用於標示動畫是否為開始播放(/暫停/繼續)之狀態
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
   

    	
            // 如stop為true，則停止動畫之播放
//            if (stop) {
//                break_actr_thread = 1;   // 銷毀線程
//                break;      // 跳出循環，結束線程的執行
//            }
            // 如為播放狀態者(即flag=true)，則開始設定圖片
    	
    	while(true) {
    		
    		
            if (explo_1==1) {
                picturePath = "./resources/skill/protect.gif";       // 設置圖片存放的位置路徑
                
               
                
                
              
                // 設置顯示之圖片
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
                    Thread.sleep(500);      // 讓線程休眠180毫秒，再設置下一張圖片
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        		FrameSetting.jLayeredPane_main.remove(label);
                
                
                
 
                
                try {
                    Thread.sleep(500);      // 讓線程休眠180毫秒，再設置下一張圖片
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
