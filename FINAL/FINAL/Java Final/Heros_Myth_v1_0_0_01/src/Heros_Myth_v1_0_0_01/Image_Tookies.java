package Heros_Myth_v1_0_0_01;

import Extension.Parameter;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import java.lang.Math;

public class Image_Tookies extends Parameter{

	public void add_item_withBufferedImage(BufferedImage item_buffered, int x, int y,int player) throws IOException {
	    // Crop player RGB animations
	    ImageIcon item_icon = new ImageIcon(item_buffered);
		JLabel item = new JLabel(item_icon);
		// Set Image Locations
		Dimension item_size = item.getPreferredSize();
		int positionX,positionY;
		positionX=position(x);
		positionY=position(y);

		item.setBounds(positionX,positionY , item_size.width, item_size.height);
		LinkedList.setLink("bomb",positionX,positionY,item,player);
		if (player==1||player==2)
			matrix[positionY/radius][positionX/radius] = -31;
		else if (player==6721||player==6722)
			matrix[positionY/radius][positionX/radius]=-32;
		// Stack JLabel onto JPanels
		jLayeredPane_main.add(item, JLayeredPane.POPUP_LAYER);
	}
	
	public void attack(int player_number, BufferedImage weapon_image) throws IOException {
		int x = -1, y = -1, direct = -1;
		if( player_number == 1) {
			x = player_1_x;
			y = player_1_y;
			direct = player_1_faceON;
		}
		else if( player_number == 2 ) {
			x = player_2_x;
			y = player_2_y;
			direct = player_2_faceON;
		}
		else return;
		
		int dx = 0, dy = 0;
		switch(direct) {
			case 0:
				dx = 0;
				dy = 4;
				break;
			case 1:
				dx = -4;
				dy = 0;
				break;
			case 2:
				dx = 4;
				dy = 0;
				break;
			case 3:
				dx = 0;
				dy = -4;
				break;
			default:
				return;
		}
		
		// create item
		ImageIcon weapon_icon = new ImageIcon(weapon_image);
		JLabel weapon = new JLabel(weapon_icon);
		// Set Image Locations
		Dimension weapon_size = weapon.getPreferredSize();
		weapon.setBounds(x += dx, y += dx, weapon_size.width, weapon_size.height);
		// Stack JLabel onto JPanels
		jLayeredPane_main.add(weapon, JLayeredPane.POPUP_LAYER);
		

		// animation
		/*
		for( int i = 0; i < 10; i++ ) {
			weapon.setBounds( 
					x += dx, 
					y += dy, 
					weapon_size.width, 
					weapon_size.height);
		}
		*/
		
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
            	weapon.setLocation( 
    					x += dx, 
    					y += dy);
            	if( Math.abs(tmp_x - x) > 250 || Math.abs(tmp_y - y) > 250 ) {
            		if( player_number == 1) {
			        	AnimeNumNow_p1 -= 1;
					}
					else if( player_number == 2 ) {
						AnimeNumNow_p2 -= 1;
					}
            		timer.stop();
					jLayeredPane_main.remove(weapon);
            	}
            }
            
        });
        timer.start();
        
        
			
			// sleep for a while

            /*
	            Timer timer = new Timer(1, null);
		        timer.setInitialDelay(200);
		        timer.start();
		    */
 
	        /*
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		
		// remove weapon
		// jLayeredPane_main.remove(weapon);
		
	}
}
