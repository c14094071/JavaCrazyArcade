package Heros_Myth_v1_0_0_01;

import Extension.Parameter;
import Extension.Item_Node;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.imageio.ImageIO;

public class Items extends Parameter {
	public static void get_Last_Node() {
		now_node = first_node;
		while( now_node.next != null ) {
			now_node = now_node.next;
		}
	}
	
	public static void put_item_to_Node(JLabel jLabel, int position_X, int position_Y, int item_type) {
		now_node.jLabel_this = jLabel;
		now_node.position_X = position_X;
		now_node.position_Y = position_Y;
		now_node.item_type = item_type;
		now_node.next = new Item_Node();
	}
	
	public static void create(int coordinateX,int coordinateY) {
		Random rand = new Random();
		int position_X = coordinateX * 32;
		int position_Y = coordinateY * 32;
		int num = rand.nextInt(5);	// random integer 0 ~ 4
		if( num == 4 ) {			// if num == 4, create item ( 1/5 chance to create item )
			int num2 = rand.nextInt(3);
			try {
				switch( num2 ) {
					case 0:
						BufferedImage attack_range = ImageIO.read(new File("./resources/items/attack_range.png"));
						ImageIcon icon_range = new ImageIcon(attack_range);
						JLabel range_1 = new JLabel(icon_range);
						range_1.setBounds(position_X, position_Y, 28, 28);
						// Matrix.matrix[coordinateY][coordinateX] = -10;
						jLayeredPane_main.add(range_1, JLayeredPane.POPUP_LAYER);
						get_Last_Node();
						put_item_to_Node( range_1, position_X, position_Y, 0);
						break;
					case 1:
						BufferedImage attack_num = ImageIO.read(new File("./resources/items/attack_num.png"));
						ImageIcon icon_num = new ImageIcon(attack_num);
						JLabel num_1 = new JLabel(icon_num);
						num_1.setBounds(position_X, position_Y, 28, 28);
						// Matrix.matrix[coordinateY][coordinateX] = -11;
						jLayeredPane_main.add(num_1, JLayeredPane.POPUP_LAYER);
						get_Last_Node();
						put_item_to_Node( num_1, position_X, position_Y, 1);
						break;
					case 2:
						BufferedImage attack_heal = ImageIO.read(new File("./resources/items/attack_heal.png"));
						ImageIcon icon_heal = new ImageIcon(attack_heal);
						JLabel heal_1 = new JLabel(icon_heal);
						heal_1.setBounds(position_X, position_Y, 28, 28);
						// Matrix.matrix[coordinateY][coordinateX] = -12;
						jLayeredPane_main.add(heal_1, JLayeredPane.POPUP_LAYER);
						get_Last_Node();
						put_item_to_Node( heal_1, position_X, position_Y, 2);
						break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void remove_item( Item_Node to_be_removed ) {
		Item_Node now_node = first_node;
		Item_Node prev_node = first_node;
		if( now_node.next == null ) {
			jLayeredPane_main.remove(now_node.jLabel_this);
			now_node.jLabel_this = null;
			now_node.position_X = 0;
			now_node.position_Y = 0;
			now_node.item_type = 0;
		}
		
		while( now_node.next != null ) {
			if( now_node == to_be_removed ) {
				prev_node.next = ( now_node.next == null ) ? null : now_node.next;
				jLayeredPane_main.remove(now_node.jLabel_this);
				break;
			}
			prev_node = now_node;
			now_node = now_node.next;
		}

	}

	public static void check_items(int x, int y) {
		
	}
}
