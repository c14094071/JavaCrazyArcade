package Heros_Myth_v1_0_0_01;

import Extension.Parameter;
import Extension.Item_Node;

import java.util.concurrent.TimeUnit;

import javax.swing.JLayeredPane;

public class Check_Items extends Parameter implements Runnable{
	
	public void run(){
		
		while(stopAllThread == -1){
			
			try {
	            TimeUnit.MILLISECONDS.sleep(150);//need to adjust according from LinkedList.java function
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
			
			// items check
			Item_Node now_node = first_node;
			while( now_node.next != null ) {
				if( (jLabel_player_1.getBounds().x > now_node.jLabel_this.getBounds().x - 30 ) &&
					(jLabel_player_1.getBounds().x < now_node.jLabel_this.getBounds().x + 10 ) &&
					(jLabel_player_1.getBounds().y > now_node.jLabel_this.getBounds().y - 30 ) &&
					(jLabel_player_1.getBounds().y < now_node.jLabel_this.getBounds().y + 10 ) ){

					switch( now_node.item_type ) {
					case 0: {
						p1Power += 1;
						Items.remove_item(now_node);
						wait_time_func();
						break;
					}
					case 1: {
						BombNumMax_p1 += 1;
						Items.remove_item(now_node);
						wait_time_func();
						break;
					}
					case 2: {
						if (p1Blood < 3) {
							p1Blood += 1;
						}
						
						if ( p1Blood == 3) {

							jLabel_heart1_1.setVisible(true);
							jLabel_heart1_2.setVisible(true);
							jLabel_heart1_3.setVisible(true);
						}
						
						Items.remove_item(now_node);
						wait_time_func();
						break;
					}
					default: {
						System.out.println("Judgement.java: items check ERROR");
						System.out.println("	Related files: Item_Node.java, IItems.java");
						break;
					}
					}
				}
				
				if( (jLabel_player_2.getBounds().x > now_node.jLabel_this.getBounds().x - 30 ) &&
						(jLabel_player_2.getBounds().x < now_node.jLabel_this.getBounds().x + 10 ) &&
						(jLabel_player_2.getBounds().y > now_node.jLabel_this.getBounds().y - 30 ) &&
						(jLabel_player_2.getBounds().y < now_node.jLabel_this.getBounds().y + 10 ) ){

						switch( now_node.item_type ) {
						case 0: {
							p2Power += 1;
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						case 1: {
							BombNumMax_p2 += 1;
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						case 2: {
							if (p2Blood < 3) {
								p2Blood += 1;
							}
							
							if ( p2Blood == 3) {

								jLabel_heart2_1.setVisible(true);
								jLabel_heart2_2.setVisible(true);
								jLabel_heart2_3.setVisible(true);
							}
							
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						default: {
							System.out.println("Judgement.java: items check ERROR");
							System.out.println("	Related files: Item_Node.java, IItems.java");
							break;
						}
						}
					}
				if(Npc1px*radius==now_node.position_Y && Npc1py*radius==now_node.position_X){
					switch( now_node.item_type ) {
						case 0: {
							Npc1power += 1;
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						case 1: {
							BombNumMax_NPC1 += 1;
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						case 2: {
							if (npc1Blood < 3) {
								npc1Blood += 1;
							}
							if ( npc1Blood == 3) {

								jLabel_heart_npc1_1.setVisible(true);
								jLabel_heart_npc1_2.setVisible(true);
								jLabel_heart_npc1_3.setVisible(true);
							}
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						default: {
							System.out.println("Judgement.java: items check ERROR");
							System.out.println("	Related files: Item_Node.java, IItems.java");
							break;
						}
					}
				}
				if(Npc2px*radius==now_node.position_Y && Npc2py*radius==now_node.position_X){
					switch( now_node.item_type ) {
						case 0: {
							Npc2power += 1;
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						case 1: {
							BombNumMax_NPC2 += 1;
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						case 2: {
							if (npc2Blood < 3) {
								npc2Blood += 1;
							}
							if ( npc2Blood == 3) {

								jLabel_heart_npc2_1.setVisible(true);
								jLabel_heart_npc2_2.setVisible(true);
								jLabel_heart_npc2_3.setVisible(true);
							}
							Items.remove_item(now_node);
							wait_time_func();
							break;
						}
						default: {
							System.out.println("Judgement.java: items check ERROR");
							System.out.println("	Related files: Item_Node.java, IItems.java");
							break;
						}
					}
				}
				now_node = now_node.next;
			} 
		}
			
	}
	public void wait_time_func() {
		try {
            TimeUnit.NANOSECONDS.sleep(100);//need to adjust according from LinkedList.java function
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
	}
}
