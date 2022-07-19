package Extension;

import javax.swing.JLabel;

public class Item_Node{
	public int position_X = 0;
	public int position_Y = 0;
	public int item_type = 0;
	public JLabel jLabel_this = null;
	public Item_Node next = null;

	public Item_Node(){
		position_X = 0;
		position_Y = 0;
		item_type = 0;
		jLabel_this = null;
		next = null;
	}
}