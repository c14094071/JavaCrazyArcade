package Heros_Myth_v1_0_0_01;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Extension.Parameter;
import Npc1.Npc1;
import Npc2.Npc2;

public class GameState extends Parameter{
	public static Thread npc1;
	public static Thread npc2;
	public GameState(String map_path, String player1_path, String player2_path, int game_mode) {
	new Matrix(mapXSize,mapYSize);//build a matrix and can access with public

	// put JPanels onto JFrame
	new RandomMapBlock(timesBlock, timesTempBlock, mapYSize, mapXSize);//the times is only for one corner,and the x and y should same with the matrix(y change to x,and x change to y)

	new PlayerStartPosition(1, mapXSize, mapYSize,radius);
	new PlayerStartPosition(2, mapXSize, mapYSize,radius);
	while (true) {
		int verify = Matrix.clearDataAndRestart(timesBlock, timesTempBlock, mapXSize, mapYSize);
		if (verify == 1)
			break;
	}
	mode=game_mode;
	System.out.println("mode"+mode);
	Blood.init();
	
	new BuildPlayer(map_path, player1_path, player2_path);//build map,player,block
	if(game_mode == 0) {
		npc1 = new Thread(new Npc1());
		npc2 = new Thread(new Npc2());
	}
	
	RandomMapBlock.showBlock();
	
	jFrame_main.add(jLayeredPane_main, BorderLayout.CENTER);
	// Show JFrame
	jFrame_main.setVisible(true);
	// Add listener to listen keyboard
	jFrame_main.addKeyListener(new KeyListen());
	
	Thread readKeyboard=new Thread(new ReadKeyboard());
	Thread checkBomb=new Thread(new CheckBomb());
	checkBomb.start();
	readKeyboard.start();

	
	if(game_mode == 0) {
		
		npc1.start();
		npc2.start();
	}
	
	
	new Sound_Tookies("resources/sound/music_game_02.wav");
	// new Sound_Tookies("resources/sound/BestSong.wav");
	
	  
	// blood
	
	
	// items
	// items.Start();
	Thread checkItem = new Thread( new Check_Items() );
	checkItem.start();
	
	if(Menu.player1_select == 1 || Menu.player2_select == 1) {
		Thread actr_thread = new Thread( new ActionThread(8,8,8,8) );
		actr_thread.start();
	}
	if(Menu.player1_select == 2 || Menu.player2_select == 2) {
		Thread actr_thread_1 = new Thread( new ActionThread_1(8,8,8,8) );
		actr_thread_1.start();
	}
	if(Menu.player1_select == 3 || Menu.player2_select == 3) {
		Thread actr_thread_2 = new Thread( new ActionThread_2(8,8,8,8) );
		actr_thread_2.start();
	}
	if(Menu.player1_select == 4 || Menu.player2_select == 4) {
		Thread actr_thread_3 = new Thread( new ActionThread_3(8,8,8,8) );
		actr_thread_3.start();
	}
	if(Menu.player1_select == 5 || Menu.player2_select == 5) {
		Thread actr_thread_4 = new Thread( new ActionThread_4(8,8,8,8) );
		actr_thread_4.start();
	}
	if(Menu.player1_select == 6 || Menu.player2_select == 6) {
		Thread actr_thread_5 = new Thread( new ActionThread_5(8,8,8,8) );
		actr_thread_5.start();
	}
	
	
	
	
	
	
	
	
	}
}
