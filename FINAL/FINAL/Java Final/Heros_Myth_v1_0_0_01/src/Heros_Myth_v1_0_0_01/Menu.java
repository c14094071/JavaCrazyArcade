package Heros_Myth_v1_0_0_01;
import Extension.Parameter;

import java.io.File;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;


import java.awt.*;
import java.awt.image.BufferedImage;
/*import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;*/
import java.awt.event.*;
/*import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;*/
import javax.swing.*;





public class Menu extends JFrame implements KeyListener{

	
	
	String map_path = "", player1_path = "", player2_path = "";
	Image image, player1, player2;
	private String[] options = {"Game Start","Rules","Exits"};
	private String[] map_list = {"Map1", "Map2", "Map3", "Map4"};
	private String[] mode = {"Players & Computers", "Only Players"};
	private Font font =  new Font("Garamond",Font.PLAIN,20);
	private int currentChoice = 0, map_select = 0;
	public static int player1_select = 1, player2_select = 1, game_mode = 0;
	boolean enter_state = false, map_chosen = false, game_state = false, player1_state = false, player2_state = false, mode_state = false;
	
	
	public  Menu(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 480);
		this.addKeyListener(this);
		this.setLocationRelativeTo(null);		
		this.setVisible(true);
	}
	//update frame
	public void update() {
		repaint();
	}
	public void paint(Graphics g) {
		
		
		
		Graphics2D draw = (Graphics2D) g;
		if(game_state == false) {
		if(enter_state == false)
			image = new ImageIcon("./resources/menu/menu.jpg").getImage();
		else if(currentChoice == 0 && enter_state == true && map_chosen == false)
			image = new ImageIcon("./resources/menu/map_list.png").getImage();
		else if(currentChoice == 0 && enter_state == true && map_chosen == true) {
			if(map_select == 0) {
				image = new ImageIcon("./resources/menu/map1.jpg").getImage();

				if(player1_select == 1) {
					player1 = new ImageIcon("./resources/players/player_1_intro.png").getImage();
					player1_path = "./resources/players/player_1_walking.png";
					Parameter.player1_path="./resources/end_game/p1.png";
				}
				else if(player1_select == 2) {
					player1 = new ImageIcon("./resources/players/player_2_intro.png").getImage();
					player1_path = "./resources/players/player_2_walking.png";
					Parameter.player1_path="./resources/end_game/p2.png";
				}
				else if(player1_select == 3) {
					player1 = new ImageIcon("./resources/players/player_3_intro.png").getImage();
					player1_path = "./resources/players/player_3_walking.png";
					Parameter.player1_path="./resources/end_game/p3.png";
				}
				else if(player1_select == 4) {
					player1 = new ImageIcon("./resources/players/player_4_intro.png").getImage();
					player1_path = "./resources/players/player_4_walking.png";
					Parameter.player1_path="./resources/end_game/p4.png";
				}
				else if(player1_select == 5) {
					player1 = new ImageIcon("./resources/players/player_5_intro.png").getImage();
					player1_path = "./resources/players/player_5_walking.png";
					Parameter.player1_path="./resources/end_game/p5.png";
				}
				else if(player1_select == 6) {
					player1 = new ImageIcon("./resources/players/player_6_intro.png").getImage();
					player1_path = "./resources/players/player_6_walking.png";
					Parameter.player1_path="./resources/end_game/p6.png";
				}



				if(player2_select == 1) {
					player2 = new ImageIcon("./resources/players/player_1_intro.png").getImage();
					player2_path = "./resources/players/player_1_walking.png";
					Parameter.player2_path="./resources/end_game/p1.png";
				}
				else if(player2_select == 2) {
					player2 = new ImageIcon("./resources/players/player_2_intro.png").getImage();
					player2_path = "./resources/players/player_2_walking.png";
					Parameter.player2_path="./resources/end_game/p2.png";
				}
				else if(player2_select == 3) {
					player2 = new ImageIcon("./resources/players/player_3_intro.png").getImage();
					player2_path = "./resources/players/player_3_walking.png";
					Parameter.player2_path="./resources/end_game/p3.png";
				}
				else if(player2_select == 4) {
					player2 = new ImageIcon("./resources/players/player_4_intro.png").getImage();
					player2_path = "./resources/players/player_4_walking.png";
					Parameter.player2_path="./resources/end_game/p4.png";
				}
				else if(player2_select == 5) {
					player2 = new ImageIcon("./resources/players/player_5_intro.png").getImage();
					player2_path = "./resources/players/player_5_walking.png";
					Parameter.player2_path="./resources/end_game/p5.png";
				}
				else if(player2_select == 6) {
					player2 = new ImageIcon("./resources/players/player_6_intro.png").getImage();
					player2_path = "./resources/players/player_6_walking.png";
					Parameter.player2_path="./resources/end_game/p6.png";
				}


				map_path = "./resources/menu/map1.jpg";
			}
			else if(map_select == 1) {
				image = new ImageIcon("./resources/menu/map2.jpg").getImage();


				if(player1_select == 1) {
					player1 = new ImageIcon("./resources/players/player_1_intro.png").getImage();
					player1_path = "./resources/players/player_1_walking.png";
					Parameter.player1_path="./resources/end_game/p1.png";
				}
				else if(player1_select == 2) {
					player1 = new ImageIcon("./resources/players/player_2_intro.png").getImage();
					player1_path = "./resources/players/player_2_walking.png";
					Parameter.player1_path="./resources/end_game/p2.png";
				}
				else if(player1_select == 3) {
					player1 = new ImageIcon("./resources/players/player_3_intro.png").getImage();
					player1_path = "./resources/players/player_3_walking.png";
					Parameter.player1_path="./resources/end_game/p3.png";
				}
				else if(player1_select == 4) {
					player1 = new ImageIcon("./resources/players/player_4_intro.png").getImage();
					player1_path = "./resources/players/player_4_walking.png";
					Parameter.player1_path="./resources/end_game/p4.png";
				}
				else if(player1_select == 5) {
					player1 = new ImageIcon("./resources/players/player_5_intro.png").getImage();
					player1_path = "./resources/players/player_5_walking.png";
					Parameter.player1_path="./resources/end_game/p5.png";
				}
				else if(player1_select == 6) {
					player1 = new ImageIcon("./resources/players/player_6_intro.png").getImage();
					player1_path = "./resources/players/player_6_walking.png";
					Parameter.player1_path="./resources/end_game/p6.png";
				}



				if(player2_select == 1) {
					player2 = new ImageIcon("./resources/players/player_1_intro.png").getImage();
					player2_path = "./resources/players/player_1_walking.png";
					Parameter.player2_path="./resources/end_game/p1.png";
				}
				else if(player2_select == 2) {
					player2 = new ImageIcon("./resources/players/player_2_intro.png").getImage();
					player2_path = "./resources/players/player_2_walking.png";
					Parameter.player2_path="./resources/end_game/p2.png";
				}
				else if(player2_select == 3) {
					player2 = new ImageIcon("./resources/players/player_3_intro.png").getImage();
					player2_path = "./resources/players/player_3_walking.png";
					Parameter.player2_path="./resources/end_game/p3.png";
				}
				else if(player2_select == 4) {
					player2 = new ImageIcon("./resources/players/player_4_intro.png").getImage();
					player2_path = "./resources/players/player_4_walking.png";
					Parameter.player2_path="./resources/end_game/p4.png";
				}
				else if(player2_select == 5) {
					player2 = new ImageIcon("./resources/players/player_5_intro.png").getImage();
					player2_path = "./resources/players/player_5_walking.png";
					Parameter.player2_path="./resources/end_game/p5.png";
				}
				else if(player2_select == 6) {
					player2 = new ImageIcon("./resources/players/player_6_intro.png").getImage();
					player2_path = "./resources/players/player_6_walking.png";
					Parameter.player2_path="./resources/end_game/p6.png";
				}



				map_path = "./resources/menu/map2.jpg";
			}
			else if(map_select == 2) {
				image = new ImageIcon("./resources/menu/map3.png").getImage();

				if(player1_select == 1) {
					player1 = new ImageIcon("./resources/players/player_1_intro.png").getImage();
					player1_path = "./resources/players/player_1_walking.png";
					Parameter.player1_path="./resources/end_game/p1.png";
				}
				else if(player1_select == 2) {
					player1 = new ImageIcon("./resources/players/player_2_intro.png").getImage();
					player1_path = "./resources/players/player_2_walking.png";
					Parameter.player1_path="./resources/end_game/p2.png";
				}
				else if(player1_select == 3) {
					player1 = new ImageIcon("./resources/players/player_3_intro.png").getImage();
					player1_path = "./resources/players/player_3_walking.png";
					Parameter.player1_path="./resources/end_game/p3.png";
				}
				else if(player1_select == 4) {
					player1 = new ImageIcon("./resources/players/player_4_intro.png").getImage();
					player1_path = "./resources/players/player_4_walking.png";
					Parameter.player1_path="./resources/end_game/p4.png";
				}
				else if(player1_select == 5) {
					player1 = new ImageIcon("./resources/players/player_5_intro.png").getImage();
					player1_path = "./resources/players/player_5_walking.png";
					Parameter.player1_path="./resources/end_game/p5.png";
				}
				else if(player1_select == 6) {
					player1 = new ImageIcon("./resources/players/player_6_intro.png").getImage();
					player1_path = "./resources/players/player_6_walking.png";
					Parameter.player1_path="./resources/end_game/p6.png";
				}



				if(player2_select == 1) {
					player2 = new ImageIcon("./resources/players/player_1_intro.png").getImage();
					player2_path = "./resources/players/player_1_walking.png";
					Parameter.player2_path="./resources/end_game/p1.png";
				}
				else if(player2_select == 2) {
					player2 = new ImageIcon("./resources/players/player_2_intro.png").getImage();
					player2_path = "./resources/players/player_2_walking.png";
					Parameter.player2_path="./resources/end_game/p2.png";
				}
				else if(player2_select == 3) {
					player2 = new ImageIcon("./resources/players/player_3_intro.png").getImage();
					player2_path = "./resources/players/player_3_walking.png";
					Parameter.player2_path="./resources/end_game/p3.png";
				}
				else if(player2_select == 4) {
					player2 = new ImageIcon("./resources/players/player_4_intro.png").getImage();
					player2_path = "./resources/players/player_4_walking.png";
					Parameter.player2_path="./resources/end_game/p4.png";
				}
				else if(player2_select == 5) {
					player2 = new ImageIcon("./resources/players/player_5_intro.png").getImage();
					player2_path = "./resources/players/player_5_walking.png";
					Parameter.player2_path="./resources/end_game/p5.png";
				}
				else if(player2_select == 6) {
					player2 = new ImageIcon("./resources/players/player_6_intro.png").getImage();
					player2_path = "./resources/players/player_6_walking.png";
					Parameter.player2_path="./resources/end_game/p6.png";
				}




				map_path = "./resources/menu/map3.png";
			}
			else if(map_select == 3) {
				image = new ImageIcon("./resources/menu/map4.png").getImage();

				if(player1_select == 1) {
					player1 = new ImageIcon("./resources/players/player_1_intro.png").getImage();
					player1_path = "./resources/players/player_1_walking.png";
					Parameter.player1_path="./resources/end_game/p1.png";
				}
				else if(player1_select == 2) {
					player1 = new ImageIcon("./resources/players/player_2_intro.png").getImage();
					player1_path = "./resources/players/player_2_walking.png";
					Parameter.player1_path="./resources/end_game/p2.png";
				}
				else if(player1_select == 3) {
					player1 = new ImageIcon("./resources/players/player_3_intro.png").getImage();
					player1_path = "./resources/players/player_3_walking.png";
					Parameter.player1_path="./resources/end_game/p3.png";
				}
				else if(player1_select == 4) {
					player1 = new ImageIcon("./resources/players/player_4_intro.png").getImage();
					player1_path = "./resources/players/player_4_walking.png";
					Parameter.player1_path="./resources/end_game/p4.png";
				}
				else if(player1_select == 5) {
					player1 = new ImageIcon("./resources/players/player_5_intro.png").getImage();
					player1_path = "./resources/players/player_5_walking.png";
					Parameter.player1_path="./resources/end_game/p5.png";
				}
				else if(player1_select == 6) {
					player1 = new ImageIcon("./resources/players/player_6_intro.png").getImage();
					player1_path = "./resources/players/player_6_walking.png";
					Parameter.player1_path="./resources/end_game/p6.png";
				}



				if(player2_select == 1) {
					player2 = new ImageIcon("./resources/players/player_1_intro.png").getImage();
					player2_path = "./resources/players/player_1_walking.png";
					Parameter.player2_path="./resources/end_game/p1.png";
				}
				else if(player2_select == 2) {
					player2 = new ImageIcon("./resources/players/player_2_intro.png").getImage();
					player2_path = "./resources/players/player_2_walking.png";
					Parameter.player2_path="./resources/end_game/p2.png";
				}
				else if(player2_select == 3) {
					player2 = new ImageIcon("./resources/players/player_3_intro.png").getImage();
					player2_path = "./resources/players/player_3_walking.png";
					Parameter.player2_path="./resources/end_game/p3.png";
				}
				else if(player2_select == 4) {
					player2 = new ImageIcon("./resources/players/player_4_intro.png").getImage();
					player2_path = "./resources/players/player_4_walking.png";
					Parameter.player2_path="./resources/end_game/p4.png";
				}
				else if(player2_select == 5) {
					player2 = new ImageIcon("./resources/players/player_5_intro.png").getImage();
					player2_path = "./resources/players/player_5_walking.png";
					Parameter.player2_path="./resources/end_game/p5.png";
				}
				else if(player2_select == 6) {
					player2 = new ImageIcon("./resources/players/player_6_intro.png").getImage();
					player2_path = "./resources/players/player_6_walking.png";
					Parameter.player2_path="./resources/end_game/p6.png";
				}




				map_path = "./resources/menu/map4.png";
			}
			//game_state = true;
		}
			
		else if (currentChoice == 1 && enter_state == true) {
			image = new ImageIcon("./resources/menu/rule.png").getImage();		
		}
		
		draw.drawImage(image, 0, 0, null);
		if(map_chosen == true) {
			draw.drawImage(player1, 350, 100, null);
			draw.drawImage(player2, 50, 100, null);
		}
		
		g.setColor(Color.WHITE);
		if(enter_state == false)
			g.fillRoundRect(30, 250, 150, 160, 10, 10);
		
		g.setFont(font);
		if(enter_state == false) {
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.BLACK);
			}else {
				g.setColor(Color.RED);
			}
			    
			    g.drawString(options[i], 50, 300+i*32);
		}
		}
		
		if(enter_state == true && currentChoice == 0 && map_chosen == false) {
		for(int i = 0; i < map_list.length; i++) {
			if(i == map_select) {
				g.setColor(Color.BLACK);
			}else {
				g.setColor(Color.RED);
			}			
			    g.drawString(map_list[i], 50+i*150, 325);
		}
		}
		
		
		if(player1_state == true && player2_state == true && mode_state == false) {
			for(int i = 0; i < mode.length; i++) {
				if(i == game_mode) {
					g.setColor(Color.BLACK);
				}else {
					g.setColor(Color.RED);
				}			
				    g.drawString(mode[i], 180+i*200, 450);
			}
		}
		
		}
		else {
			this.setVisible(false);
			new GameState(map_path, player2_path, player1_path, game_mode);
		}
		
	}
	
	public void select() {
		if(currentChoice==0 && enter_state == false) {
			enter_state = true;
			
			
		}else if (currentChoice==1 && enter_state == false) {
			enter_state = true;
			
		}else if (currentChoice==2 && enter_state == false) {
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(game_state == false) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_ENTER && enter_state == false ) {
			select();
		}

		else if(key == KeyEvent.VK_UP && enter_state == false) {
			--currentChoice;
			if(currentChoice==-1) {
				currentChoice = 2;
			}
			
		}
		else if(key == KeyEvent.VK_DOWN && enter_state == false) {
			++currentChoice;
			if(currentChoice==3) {
				currentChoice = 0;
			}
			
		}
		else if(key == KeyEvent.VK_ESCAPE && enter_state == true && map_chosen == false) {
			image = new ImageIcon("./resources/menu.png").getImage();
			//enter_state = false;
			currentChoice = 0; 
			map_select = 0; 
			enter_state = false; 
			map_chosen = false;
		}
		
		
		else if(key == KeyEvent.VK_RIGHT && enter_state == true && currentChoice == 0 && map_chosen == false) {
			++map_select;
			if(map_select == 4)
				map_select = 0;
		}
		else if(key == KeyEvent.VK_LEFT && enter_state == true && currentChoice == 0 && map_chosen == false) {
			--map_select;
			if(map_select == -1)
				map_select = 3;
		}
		else if(key == KeyEvent.VK_ENTER && enter_state == true && currentChoice == 0 && map_chosen == false) {
			map_chosen = true;
		}
		else if(key == KeyEvent.VK_ESCAPE && map_chosen == true) {
			player1_select = 1;
			player1_state = false;
			player2_select = 1;
			player2_state = false;
			map_chosen = false;
		}

		else if(key == KeyEvent.VK_RIGHT && enter_state == true && currentChoice == 0 && map_chosen == true && player1_state == false) {
			player1_select++;
			if(player1_select == 7)
				player1_select = 1;
		}
		else if(key == KeyEvent.VK_LEFT && enter_state == true && currentChoice == 0 && map_chosen == true && player1_state == false) {
			player1_select--;
			if(player1_select == 0)
				player1_select = 6;
		}
		else if(key == KeyEvent.VK_ENTER && enter_state == true && currentChoice == 0 && map_chosen == true && player1_state == false){
			player1_state =true;
		}
		else if(key == KeyEvent.VK_D && enter_state == true && currentChoice == 0 && map_chosen == true && player1_state == true && player2_state ==false ) {
			player2_select++;
			if(player2_select == 7)
				player2_select = 1;
		}
		else if(key == KeyEvent.VK_A && enter_state == true && currentChoice == 0 && map_chosen == true && player1_state == true && player2_state ==false ) {
			player2_select--;
			if(player2_select == 0)
				player2_select = 6;
		}
		else if(key == KeyEvent.VK_ENTER && enter_state == true && currentChoice == 0 && map_chosen == true && player1_state == true && player2_state ==false ) {
			player2_state =true;
		}
		
		else if(key == KeyEvent.VK_RIGHT && map_chosen == true && player1_state == true && player2_state == true) {
			game_mode++;
			if(game_mode == 2)
				game_mode = 0;
		}
		else if(key == KeyEvent.VK_LEFT && map_chosen == true && player1_state == true && player2_state == true) {
			game_mode--;
			if(game_mode == -1)
				game_mode = 1;
		}
		else if(key == KeyEvent.VK_ENTER && map_chosen == true && player1_state == true && player2_state == true) {
			mode_state = true;
			game_state = true;
		}
		
		/*else if(key == KeyEvent.VK_ENTER && map_chosen == true && player1_state == true && player2_state == true && mode_state == true) {
			game_state = true;
		}*/
		 
		
		}		
		update();
	}
	 
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
}


