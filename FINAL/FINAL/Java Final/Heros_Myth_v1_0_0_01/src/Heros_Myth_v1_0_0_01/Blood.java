package Heros_Myth_v1_0_0_01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Extension.End_Game;
import Npc1.Npc1;
import Npc2.Npc2;
import Extension.Parameter;

public class Blood extends Parameter{
	/*
	 * public void write(int blood1, int blood2) { // TODO Auto-generated method
	 * stub System.out.println("Player1 blood: " + blood1);
	 * System.out.println("Player2 blood: " + blood2); } /* public class BloodBar
	 * extends JPanel{ public BloodBar(){ this.setBackground( Color.RED);//New.
	 * this.setBounds(0, 450, 100, 20);//New. } }
	 */
	
	// initial blood function
	
	public static void init() {
		try {
			BufferedImage img_6 = ImageIO.read(new File("./resources/items/6.png"));
			ImageIcon icon_heart = new ImageIcon(img_6);
			// set player1 blood jlabel
			jLabel_heart1_1 = new JLabel(icon_heart);
			jLabel_heart1_2 = new JLabel(icon_heart);
			jLabel_heart1_3 = new JLabel(icon_heart);
			// set player2 blood jlabel
			jLabel_heart2_1 = new JLabel(icon_heart);
			jLabel_heart2_2 = new JLabel(icon_heart);
			jLabel_heart2_3 = new JLabel(icon_heart);
			// set npc1 blood jlabel
			jLabel_heart_npc1_1 = new JLabel(icon_heart);
			jLabel_heart_npc1_2 = new JLabel(icon_heart);
			jLabel_heart_npc1_3 = new JLabel(icon_heart);
			// set npc2 blood jlabel
			jLabel_heart_npc2_1 = new JLabel(icon_heart);
			jLabel_heart_npc2_2 = new JLabel(icon_heart);
			jLabel_heart_npc2_3 = new JLabel(icon_heart);

			// Container cp= jFrame_main.getContentPane();
			// JLabel label1=new JLabel("Player1 Blood: ");
			// label1.setBounds(20,450,100,40);
			// cp.add(label1);
			// JLabel label2=new JLabel("Player2 Blood: ");
			// label2.setBounds(370,450,100,40);
			// cp.add(label2);

			// text
			JLabel label1 = new JLabel("Player1 Blood: ");
			label1.setBounds(20, 450, 100, 40);
			jLayeredPane_main.add(label1);
			JLabel label2 = new JLabel("Player2 Blood: ");
			label2.setBounds(370, 450, 100, 40);
			jLayeredPane_main.add(label2);
			if(mode==0) {
				JLabel label3 = new JLabel("NPC1 Blood: ");
				label3.setBounds(20, 490, 100, 40);
				jLayeredPane_main.add(label3);
				JLabel label4 = new JLabel("NPC2 Blood: ");
				label4.setBounds(370, 490, 100, 40);
				jLayeredPane_main.add(label4);
			}
			

			// Set Image Locations
			// player1 blood
			jLabel_heart1_1.setBounds(100, 455, width, width);
			jLabel_heart1_2.setBounds(150, 455, width, width);
			jLabel_heart1_3.setBounds(200, 455, width, width);
			// player2 blood
			jLabel_heart2_1.setBounds(450, 455, width, width);
			jLabel_heart2_2.setBounds(500, 455, width, width);
			jLabel_heart2_3.setBounds(550, 455, width, width);
			if(mode==0) {
				// npc1 blood
				jLabel_heart_npc1_1.setBounds(100, 495, width, width);
				jLabel_heart_npc1_2.setBounds(150, 495, width, width);
				jLabel_heart_npc1_3.setBounds(200, 495, width, width);
				// npc2 blood
				jLabel_heart_npc2_1.setBounds(450, 495, width, width);
				jLabel_heart_npc2_2.setBounds(500, 495, width, width);
				jLabel_heart_npc2_3.setBounds(550, 495, width, width);
			}
			

			jLayeredPane_main.add(jLabel_heart1_1, JLayeredPane.POPUP_LAYER);
			jLayeredPane_main.add(jLabel_heart1_2, JLayeredPane.POPUP_LAYER);
			jLayeredPane_main.add(jLabel_heart1_3, JLayeredPane.POPUP_LAYER);
			jLayeredPane_main.add(jLabel_heart2_1, JLayeredPane.POPUP_LAYER);
			jLayeredPane_main.add(jLabel_heart2_2, JLayeredPane.POPUP_LAYER);
			jLayeredPane_main.add(jLabel_heart2_3, JLayeredPane.POPUP_LAYER);
			if(mode==0) {
				jLayeredPane_main.add(jLabel_heart_npc1_1, JLayeredPane.POPUP_LAYER);
				jLayeredPane_main.add(jLabel_heart_npc1_2, JLayeredPane.POPUP_LAYER);
				jLayeredPane_main.add(jLabel_heart_npc1_3, JLayeredPane.POPUP_LAYER);
				jLayeredPane_main.add(jLabel_heart_npc2_1, JLayeredPane.POPUP_LAYER);
				jLayeredPane_main.add(jLabel_heart_npc2_2, JLayeredPane.POPUP_LAYER);
				jLayeredPane_main.add(jLabel_heart_npc2_3, JLayeredPane.POPUP_LAYER);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void change() {
		// System.out.println("Player1 blood: " + p1Blood);
		// System.out.println("Player2 blood: " + p2Blood);

		// Stack JLabel onto JPanels
		if (mode == 1) {
			if (p1Blood==0 || p2Blood==0) {
				System.out.println("p1 or p2 die.");
				stopAllThread=1;
				if (p1Blood==0)
					judgement1=404;
				else if (p2Blood==0)
					judgement2=404;
				new End_Game(player1_path,player2_path);
			}
			// judge on player1blood
			if (p1Blood == 2) {
				// jLayeredPane_main.add(jLabel_heart1_1,
				// JLayeredPane.POPUP_LAYER);
				// jLayeredPane_main.add(jLabel_heart1_2,
				// JLayeredPane.POPUP_LAYER);
				// jLayeredPane_main.remove(jLabel_heart1_3);
				jLabel_heart1_1.setVisible(true);
				jLabel_heart1_2.setVisible(true);
				jLabel_heart1_3.setVisible(false);
			} else if (p1Blood == 1) {
				// jLayeredPane_main.add(jLabel_heart1_1,
				// JLayeredPane.POPUP_LAYER);
				// jLayeredPane_main.remove(jLabel_heart1_2);
				// jLayeredPane_main.remove(jLabel_heart1_3);
				jLabel_heart1_1.setVisible(true);
				jLabel_heart1_2.setVisible(false);
				jLabel_heart1_3.setVisible(false);
			} else if (p1Blood == 0) {
				jLabel_heart1_1.setVisible(false);
				jLabel_heart1_2.setVisible(false);
				jLabel_heart1_3.setVisible(false);
				//System.exit(0);
			}

			// judge on player2blood
			if (p2Blood == 2) {

				// jLayeredPane_main.add(jLabel_heart2_1,
				// JLayeredPane.POPUP_LAYER);
				// jLayeredPane_main.add(jLabel_heart2_2,
				// JLayeredPane.POPUP_LAYER);
				// jLayeredPane_main.remove(jLabel_heart2_3);
				jLabel_heart2_1.setVisible(true);
				jLabel_heart2_2.setVisible(true);
				jLabel_heart2_3.setVisible(false);
			} else if (p2Blood == 1) {
				// jLayeredPane_main.add(jLabel_heart2_1,
				// JLayeredPane.POPUP_LAYER);
				// jLayeredPane_main.remove(jLabel_heart2_2);
				// jLayeredPane_main.remove(jLabel_heart2_3);
				jLabel_heart2_1.setVisible(true);
				jLabel_heart2_2.setVisible(false);
				jLabel_heart2_3.setVisible(false);
			} else if (p2Blood == 0) {
				jLabel_heart2_1.setVisible(false);
				jLabel_heart2_2.setVisible(false);
				jLabel_heart2_3.setVisible(false);
				//System.exit(0);
			}
			
			// judge on npc1blood
			if (npc1Blood == 2) {
				jLabel_heart_npc1_1.setVisible(true);
				jLabel_heart_npc1_2.setVisible(true);
				jLabel_heart_npc1_3.setVisible(false);
			} else if (npc1Blood == 1) {
				jLabel_heart_npc1_1.setVisible(true);
				jLabel_heart_npc1_2.setVisible(false);
				jLabel_heart_npc1_3.setVisible(false);
			} else if (npc1Blood == 0) {
				jLabel_heart_npc1_1.setVisible(false);
				jLabel_heart_npc1_2.setVisible(false);
				jLabel_heart_npc1_3.setVisible(false);
				Npc1.label.setVisible(false);
			}
			// judge on npc2blood
			if (npc2Blood == 2) {
				jLabel_heart_npc2_1.setVisible(true);
				jLabel_heart_npc2_2.setVisible(true);
				jLabel_heart_npc2_3.setVisible(false);
			} else if (npc2Blood == 1) {
				jLabel_heart_npc2_1.setVisible(true);
				jLabel_heart_npc2_2.setVisible(false);
				jLabel_heart_npc2_3.setVisible(false);
			} else if (npc2Blood == 0) {
				jLabel_heart_npc2_1.setVisible(false);
				jLabel_heart_npc2_2.setVisible(false);
				jLabel_heart_npc2_3.setVisible(false);
				Npc2.label.setVisible(false);
			}
		}
		
		// mode 2: player1+2 try to kill npc
		if (mode==0) {
			if((npc1Blood==0 && npc2Blood==0)||(p1Blood==0 && p2Blood==0)){
				System.out.println("npc1 and npc2 die or p1 and p2 die.");
				stopAllThread=1;
				if (p1Blood==0)
					judgement1=404;
				if (p2Blood==0)
					judgement2=404;
				if (npc1Blood==0)
					judgementNPC1=404;
				if (npc2Blood==0)
					judgementNPC2=404;
				new End_Game(player1_path,player2_path);
			}
			// judge on player1blood
			if (p1Blood == 2) {
				jLabel_heart1_1.setVisible(true);
				jLabel_heart1_2.setVisible(true);
				jLabel_heart1_3.setVisible(false);
			} else if (p1Blood == 1) {
				jLabel_heart1_1.setVisible(true);
				jLabel_heart1_2.setVisible(false);
				jLabel_heart1_3.setVisible(false);
			} else if (p1Blood == 0) {
				jLabel_heart1_1.setVisible(false);
				jLabel_heart1_2.setVisible(false);
				jLabel_heart1_3.setVisible(false);
				BuildPlayer.jLabel_player_1.setVisible(false);
			}

			// judge on player2blood
			if (p2Blood == 2) {
				jLabel_heart2_1.setVisible(true);
				jLabel_heart2_2.setVisible(true);
				jLabel_heart2_3.setVisible(false);
			} else if (p2Blood == 1) {
				jLabel_heart2_1.setVisible(true);
				jLabel_heart2_2.setVisible(false);
				jLabel_heart2_3.setVisible(false);
			} else if (p2Blood == 0) {
				jLabel_heart2_1.setVisible(false);
				jLabel_heart2_2.setVisible(false);
				jLabel_heart2_3.setVisible(false);
				BuildPlayer.jLabel_player_2.setVisible(false);
			}
			
			// judge on npc1blood
			if (npc1Blood == 2) {
				jLabel_heart_npc1_1.setVisible(true);
				jLabel_heart_npc1_2.setVisible(true);
				jLabel_heart_npc1_3.setVisible(false);
			} else if (npc1Blood == 1) {
				jLabel_heart_npc1_1.setVisible(true);
				jLabel_heart_npc1_2.setVisible(false);
				jLabel_heart_npc1_3.setVisible(false);
			} else if (npc1Blood == 0) {
				jLabel_heart_npc1_1.setVisible(false);
				jLabel_heart_npc1_2.setVisible(false);
				jLabel_heart_npc1_3.setVisible(false);
				Npc1.label.setVisible(false);
				
			}
			// judge on npc2blood
			if (npc2Blood == 2) {
				jLabel_heart_npc2_1.setVisible(true);
				jLabel_heart_npc2_2.setVisible(true);
				jLabel_heart_npc2_3.setVisible(false);
			} else if (npc2Blood == 1) {
				jLabel_heart_npc2_1.setVisible(true);
				jLabel_heart_npc2_2.setVisible(false);
				jLabel_heart_npc2_3.setVisible(false);
			} else if (npc2Blood == 0) {
				jLabel_heart_npc2_1.setVisible(false);
				jLabel_heart_npc2_2.setVisible(false);
				jLabel_heart_npc2_3.setVisible(false);
				Npc2.label.setVisible(false);
			}
			
		}
		
	}

	// int x = 30;
	// int y = 486;

	/*
	 * public void draw(Graphics g) {
	 * 
	 * 
	 * Graphics2D g2=(Graphics2D) g; // int life = 100; //blood1;
	 * 
	 * Rectangle2D r2=new Rectangle2D.Double(x, y-height, width, height);
	 * g2.setColor(Color.YELLOW); g2.draw(r2); // Rectangle2D r=new
	 * Rectangle2D.Double(x+1, y-height+1, width*((double)life/100)-1, height-1);
	 * g2.setColor(Color.RED); g2.fill(r);
	 * 
	 * }
	 */
}
