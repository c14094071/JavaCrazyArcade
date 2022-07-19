package Heros_Myth_v1_0_0_01;

import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ActionThread_1 extends Rectangle implements Runnable{
	private int index = 0;  // 用於控制圖片的編號
    Main_App main = new Main_App();
    KeyListen kyls = new KeyListen();
    
    String picturePath;
    int count = 0;
    boolean flag = true;                    // 用於標示動畫是否為開始播放(/暫停/繼續)之狀態
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
    	

    	
            // 如stop為true，則停止動畫之播放
//            if (stop) {
//                break_actr_thread = 1;   // 銷毀線程
//                break;      // 跳出循環，結束線程的執行
//            }
            // 如為播放狀態者(即flag=true)，則開始設定圖片
    	
    	while(true) {
    		
    		
            if (explo_1==1) {
                String picture = "./resources/skill/vampire/vampire_";       // 設置圖片存放的位置路徑
                
                index++;
                if (index <= 8) {       // 動畫圖示共為8張，以讓其一直循環這8張圖
                    picturePath = picture + index + ".png";
                    System.out.println(picturePath);
                }
                else if (index == 9) {
                	break;
                }
                
                
              
                // 設置顯示之圖片
                ImageIcon i = new ImageIcon(picturePath);
                JLabel label = new JLabel(i);
        		
                ///////////先放置圖片，sleep後再抓取角色位置，判斷是否有重疊，然後扣血
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
                    Thread.sleep(100);      // 讓線程休眠180毫秒，再設置下一張圖片
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
