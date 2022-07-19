package Heros_Myth_v1_0_0_01;

import Extension.Parameter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class KeyListen extends Parameter implements KeyListener {
	// control part
	
	// 1. Key Pressed
    @Override
    public void keyPressed(KeyEvent e) {
    	// control player part:
    	// timer delay

		// move player:
		// up
    	
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player_cmd_2 = 3;
			player_2_faceON = 3;
		}
		// down
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			player_cmd_2 = 0;
			player_2_faceON = 0;
		}
		// left
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player_cmd_2 = 1;
			player_2_faceON = 1;
		}
		// right
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player_cmd_2 = 2;
			player_2_faceON = 2;
		}
		
		if(e.getKeyChar() == 'w') {
			player_cmd_1 = 3;
			player_1_faceON = 3;
		}
		else if(e.getKeyChar() == 's') {
			player_cmd_1 = 0;
			player_1_faceON = 0;
		}
		else if(e.getKeyChar() == 'a') {
			player_cmd_1 = 1;
			player_1_faceON = 1;
		}
		else if(e.getKeyChar() == 'd') {
			player_cmd_1 = 2;
			player_1_faceON = 2;
		}

		if(e.getKeyChar() == ',') {
			player2weapon=1;
		}
		if(e.getKeyChar() == 'v') {
			player1weapon=1;
		}
    }
    
    // 2. Key Released
	@Override 
    public void keyReleased(KeyEvent e) {
		// player_cmd_1 = -1 : Do nothing
		//player_cmd_2 = -1;
		
		if( e.getKeyCode() == KeyEvent.VK_UP && player_cmd_2 == 3)
			player_cmd_2 = -1;
		else if( e.getKeyCode() == KeyEvent.VK_DOWN && player_cmd_2 == 0)
			player_cmd_2 = -1;
		else if( e.getKeyCode() == KeyEvent.VK_LEFT && player_cmd_2 == 1)
			player_cmd_2 = -1;
		else if( e.getKeyCode() == KeyEvent.VK_RIGHT && player_cmd_2 == 2)
			player_cmd_2 = -1;
		
		
		if( e.getKeyChar() == 'w' && player_cmd_1 == 3)
			player_cmd_1 = -1;
		else if( e.getKeyChar() == 's' && player_cmd_1 == 0)
			player_cmd_1 = -1;
		else if( e.getKeyChar() == 'a' && player_cmd_1 == 1)
			player_cmd_1 = -1;
		else if( e.getKeyChar() == 'd' && player_cmd_1 == 2)
			player_cmd_1 = -1;

		if (e.getKeyChar()=='v')
			player1weapon=-1;
		if(e.getKeyChar() == ',') {
			player2weapon=-1;
		}
		
	}
	// 3. Key Typed
    @Override // 输入的内容
    public void keyTyped(KeyEvent e) {
    	
		if(e.getKeyChar() == 'i') {
			try {
				BufferedImage item_1 = ImageIO.read(new File("./resources/items/1.png"));
				Image_Tookies imt = new Image_Tookies();
				imt.add_item_withBufferedImage(item_1, 450, 300,-1);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getKeyChar()=='v' && p1Blood!=0){
			if( BombNumNow_p1 <= BombNumMax_p1 ) {
				new Sound_Tookies("resources/sound/effects_placebomb.wav");
				if (Matrix.verifyBombStack(player_1_x,player_1_y,radius))
					try {
						BombNumNow_p1 += 1;
						BufferedImage item_1 = ImageIO.read(new File("./resources/items/bomb_01.png"));
						Image_Tookies imt = new Image_Tookies();
						imt.add_item_withBufferedImage(item_1, player_1_x, player_1_y, 1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		}
		if(e.getKeyChar() == ',' && p2Blood!=0) {
			if( BombNumNow_p2 <= BombNumMax_p2 ) {
				new Sound_Tookies("resources/sound/effects_placebomb.wav");
				if (Matrix.verifyBombStack(player_2_x,player_2_y,radius)) {
					BombNumNow_p2 += 1;
					try {
						BufferedImage item_1 = ImageIO.read(new File("./resources/items/bomb_02.png"));
						Image_Tookies imt = new Image_Tookies();
						imt.add_item_withBufferedImage(item_1, player_2_x, player_2_y, 2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		if(e.getKeyChar() == '.') {
			// add
			if( AnimeNumNow_p2 <= AnimeNumMax_p2 ) {
				AnimeNumNow_p2 += 1;
				try {
					new Sound_Tookies("resources/sound/Sound_Ame.wav");
					BufferedImage weapon_2 = ImageIO.read(new File("./resources/items/Ame.png"));
					Image_Tookies imt = new Image_Tookies();
					imt.attack(2, weapon_2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//
			
		}

		if(e.getKeyChar() == 'c') {
			if( AnimeNumNow_p1 <= AnimeNumMax_p1 ) {
				AnimeNumNow_p1 += 1;
				try {
					new Sound_Tookies("resources/sound/Sound_Gura.wav");
					BufferedImage weapon_1 = ImageIO.read(new File("./resources/items/Gura.png"));
					Image_Tookies imt = new Image_Tookies();
					imt.attack(1, weapon_1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getKeyChar() == '/') {
			Skill sk = new Skill();
			if(Menu.player1_select == 1) {
				sk.character_3();
			}
			if(Menu.player1_select == 2) {
				sk.character_4();
			}
			if(Menu.player1_select == 3) {
				sk.character_5();
			}
			if(Menu.player1_select == 4) {
				sk.character_6();
			}
			if(Menu.player1_select == 5) {
				sk.character_7();
			}
			if(Menu.player1_select == 6) {
				sk.character_8();
			}

			
			
		
		}
		if(e.getKeyChar() == 'q') {
			Skill sk = new Skill();
			if(Menu.player2_select == 1) {
				sk.character_3();
			}
			if(Menu.player2_select == 2) {
				sk.character_4();
			}
			if(Menu.player2_select == 3) {
				sk.character_5();
			}
			if(Menu.player2_select == 4) {
				sk.character_6();
			}
			if(Menu.player2_select == 5) {
				sk.character_7();
			}
			if(Menu.player2_select == 6) {
				sk.character_8();
			}
		
		}
    }
}