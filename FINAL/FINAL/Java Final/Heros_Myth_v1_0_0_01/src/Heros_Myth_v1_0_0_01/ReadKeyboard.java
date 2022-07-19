package Heros_Myth_v1_0_0_01;

import Extension.Parameter;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class ReadKeyboard extends Parameter implements Runnable {
    public static void setToDefault(int player1, int player2, int npc1,int npc2) {
    	if (player1==1) 
    		judgement1 =-1;
    	if (player2==1)
    		judgement2 =-1;
    	if (npc1==1)
    		judgementNPC1 =-1;
        if (npc2==1)
            judgementNPC2 =-1;
    }
    
    public static void analysisResult(){
    	if (judgement1==11||judgement1==21||judgement1==67211||judgement1==67221){
            if(p1Blood>0)
                p1Blood--;
    	    setToDefault(1,0,0,0);
        }
        if (judgement2==12||judgement2==22||judgement2==67212||judgement2==67222){
            if(p2Blood>0)
                p2Blood--;
            setToDefault(0,1,0,0);
        }
        if (judgementNPC1==16721||judgementNPC1==26721||judgementNPC1==6721){
            if (judgementNPC1!=6721){
                if(npc1Blood>0){
                    npc1Blood--;
                }
            }else{
                System.out.println("Npc can't kill themselves");
            }
            setToDefault(0,0,1,0);
        }
        if (judgementNPC2==16722||judgementNPC2==26722||judgementNPC2==6722){
            if (judgementNPC2!=6722){
                if(npc2Blood>0)
                    npc2Blood--;
            }else{
                System.out.println("Npc can't kill themselves");
            }
            setToDefault(0,0,0,1);
        }
        Blood.change();
    }
    public void run() {
        while (stopAllThread==-1) {
            int p1 = player_cmd_1;
            int p2 = player_cmd_2;
            int w1=player1weapon;
            int w2=player2weapon;
            analysisResult();
            if (p1 >= 0 || p2 >= 0) {
                for (int i = 0; i < 3; i++) {
                    // p1
                    if (p1 >= 0) {
                        jLabel_player_1.setIcon(new ImageIcon(img_player_1_walk[p1][i]));
                    }
                    // 0: down
                    if ((p1 == 0 && player_1_y < frameSizeY + adjustBottomFrameSize)) {
                        for (int k = 0; k < player_1_step; k++) {
                            if (Matrix.verifyMove(1, 0, 1))
                                jLabel_player_1.setBounds(
                                        player_1_x,
                                        ++player_1_y,
                                        size_player_1.width,
                                        size_player_1.height);
                        }
                    }
                    // 1: left
                    else if ((p1 == 1 && player_1_x > 0)) {
                        for (int k = 0; k < player_1_step; k++) {
                            if (Matrix.verifyMove(1, -1, 0))
                                jLabel_player_1.setBounds(
                                        --player_1_x,
                                        player_1_y,
                                        size_player_1.width,
                                        size_player_1.height);
                        }
                    }
                    // 2: right
                    else if ((p1 == 2 && player_1_x < frameSizeX + adjustRightFrameSize)) {
                        for (int k = 0; k < player_1_step; k++) {
                            if (Matrix.verifyMove(1, 1, 0))
                                jLabel_player_1.setBounds(
                                        ++player_1_x,
                                        player_1_y,
                                        size_player_1.width,
                                        size_player_1.height);
                        }
                    }
                    // 3: up
                    else if ((p1 == 3 && player_1_y > 0)) {
                        for (int k = 0; k < player_1_step; k++) {
                            if (Matrix.verifyMove(1, 0, -1))
                                jLabel_player_1.setBounds(
                                        player_1_x,
                                        --player_1_y,
                                        size_player_1.width,
                                        size_player_1.height);
                        }
                    }

                    // p2
                    if (p2 >= 0) {
                        jLabel_player_2.setIcon(new ImageIcon(img_player_2_walk[p2][i]));
                    }
                    // 0: down
                    if (p2 == 0 && player_2_y < frameSizeY + adjustBottomFrameSize) {
                        for (int k = 0; k < player_2_step; k++) {
                            if (Matrix.verifyMove(2, 0, 1))
                                jLabel_player_2.setBounds(
                                        player_2_x,
                                        ++player_2_y,
                                        size_player_2.width,
                                        size_player_2.height);
                        }
                    }
                    // 1: left
                    else if (p2 == 1 && player_2_x > 0) {
                        for (int k = 0; k < player_2_step; k++) {
                            if (Matrix.verifyMove(2, -1, 0))
                                jLabel_player_2.setBounds(
                                        --player_2_x,
                                        player_2_y,
                                        size_player_2.width,
                                        size_player_2.height);
                        }
                    }
                    // 2: right
                    else if (p2 == 2 && player_2_x < frameSizeX + adjustRightFrameSize) {
                        for (int k = 0; k < player_2_step; k++) {
                            if (Matrix.verifyMove(2, 1, 0))
                                jLabel_player_2.setBounds(
                                        ++player_2_x,
                                        player_2_y,
                                        size_player_2.width,
                                        size_player_2.height);
                        }
                    }
                    // 3: up
                    else if (p2 == 3 && player_2_y > 0) {
                        for (int k = 0; k < player_2_step; k++) {
                            if (Matrix.verifyMove(2, 0, -1))
                                jLabel_player_2.setBounds(
                                        player_2_x,
                                        --player_2_y,
                                        size_player_2.width,
                                        size_player_2.height);
                        }
                    }
                    /*
                    if (w1==1){
                        if (verifyBombStack(player_1_x,player_1_y,radius))
                            try {
                                BufferedImage item_1 = ImageIO.read(new File("./resources/items/5.png"));
                                image_Tookies imt = new image_Tookies();
                                imt.add_item_withBufferedImage(item_1, player_1_x, player_1_y, 1);
                            } catch (IOException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                    }
                    if (w2==1){
                        if (verifyBombStack(player_2_x,player_2_y,radius)) {
                            try {
                                BufferedImage item_1 = ImageIO.read(new File("./resources/items/4.png"));
                                image_Tookies imt = new image_Tookies();
                                imt.add_item_withBufferedImage(item_1, player_2_x, player_2_y, 2);
                            } catch (IOException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }
                    }
                    */
					/*
					Timer timer = new Timer(10, );
			        timer.setInitialDelay(190);
			        timer.start();
			        */
                    // sleep for a while
                    try {
                        TimeUnit.MILLISECONDS.sleep(16);//60 fps as 16.66667ms
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    jFrame_main.repaint();
					/*
					timer.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                    final long now = System.currentTimeMillis();
		                    final long elapsed = now - start;
		                    progress = (float) elapsed / animationTime;
		                    repaint();
		                    if (elapsed >= animationTime) {
		                        timer.stop();
		                    }
		                }
		            });
		            timer.start();

					 */


                    // long startTime = System.currentTimeMillis();
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