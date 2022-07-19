package Heros_Myth_v1_0_0_01;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class Skill extends Thread{
	public void character_1() {
		try {
			BufferedImage skill_1 = ImageIO.read(new File("./resources/skill/firezone1.png"));
			Skill sk = new Skill();
			sk.zoneskill(skill_1, Matrix.player_2_x, Matrix.player_2_y);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void character_2() {
		try {
			BufferedImage skill_2 = ImageIO.read(new File("./resources/skill/recovery.png"));
			Skill sk = new Skill();
			sk.buffskill(2, skill_2);
		}catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	public void character_3() {
		ActionThread.explo_1 = 1;
		
	}
	public void character_4() {
		ActionThread_1.explo_1 = 1;
		
	}
	public void character_5() {
		ActionThread_2.explo_1 = 1;
		
	}
	public void character_6() {
		ActionThread_3.explo_1 = 1;
		
	}
	public void character_7() {
		ActionThread_4.explo_1 = 1;
		
	}
	public void character_8() {
		ActionThread_5.explo_1 = 1;
		
	}
	
	
	
	public void buffskill(int player_number, BufferedImage skill_image) throws IOException {
		int x = -1, y = -1;
		if( player_number == 1) {
			x = Matrix.player_1_x;
			y = Matrix.player_1_y;
			
		}
		else if( player_number == 2 ) {
			x = Matrix.player_2_x;
			y = Matrix.player_2_y;
			
		}
		else return;
		
		int dx=0,dy = -2;

		if (KeyListen.player_cmd_1 == -1) {
			dx = 0;
		}
			
		ImageIcon skill_icon = new ImageIcon(skill_image);
		JLabel skill = new JLabel(skill_icon);
		// Set Image Locations
		Dimension skill_size = skill.getPreferredSize();
		x = x-50;
		y = y-50;
		skill.setBounds(x+=dx, y += dy, skill_size.width, skill_size.height);
		// Stack JLabel onto JPanels
		FrameSetting.jLayeredPane_main.add(skill, JLayeredPane.POPUP_LAYER);
		
		final int tmp_x = x;
		final int tmp_y = y;
		final int tmp_dx = dx;
		final int tmp_dy = dy;

		Timer timer = new Timer(10, null);
        timer.addActionListener(new ActionListener() {
        	int x = tmp_x;
        	int y = tmp_y;
        	int dx = tmp_dx;
        	int dy = tmp_dy;
            @Override
            public void actionPerformed(ActionEvent e) {
            	skill.setLocation( 
    					x += dx, 
    					y += dy);
            	if(Math.abs(tmp_y - y) > 40 ) {
            		timer.stop();
            		FrameSetting.jLayeredPane_main.remove(skill);
            	}
            }
        });
        timer.start();
	}
	public void zoneskill(BufferedImage item_buffered, int x, int y) throws IOException {
		ImageIcon item_icon = new ImageIcon(item_buffered);
		JLabel item = new JLabel(item_icon);
		// Set Image Locations
		Dimension item_size = item.getPreferredSize();
		item.setBounds(x-112, y-112, item_size.width, item_size.height);
		
		
		// Stack JLabel onto JPanels
		FrameSetting.jLayeredPane_main.add(item, JLayeredPane.POPUP_LAYER);
	}
	public void fire_arrow(BufferedImage item_buffered, int x, int y) throws IOException {
		ImageIcon item_icon = new ImageIcon(item_buffered);
		JLabel item = new JLabel(item_icon);
		// Set Image Locations
		Dimension item_size = item.getPreferredSize();
		item.setBounds(x, y, item_size.width, item_size.height);
		
		
		// Stack JLabel onto JPanels
		FrameSetting.jLayeredPane_main.add(item, JLayeredPane.POPUP_LAYER);
		
	}

	
	
	

	
}