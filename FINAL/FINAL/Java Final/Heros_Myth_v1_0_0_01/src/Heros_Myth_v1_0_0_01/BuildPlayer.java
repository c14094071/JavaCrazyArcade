package Heros_Myth_v1_0_0_01;

import Extension.Parameter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class BuildPlayer extends Parameter {
    public BuildPlayer(String map_path, String player1_path, String player2_path){
    	
    	System.out.println(map_path);
    	System.out.println(player1_path);
    	System.out.println(player2_path);
    	
    	
        int r=radius;
        try{// load Image: map
            BufferedImage img_map = ImageIO.read(new File(map_path));
            ImageIcon icon_map = new ImageIcon(img_map);
            JLabel jLabel_map = new JLabel(icon_map);
            // Set Image Locations
            Dimension size_map = jLabel_map.getPreferredSize();
            jLabel_map.setBounds(0, 0, size_map.width, size_map.height);


            // load Image: player_1
            BufferedImage img_player_1 = ImageIO.read(new File(player1_path));
            // Crop player RGB animations
            img_player_1_walk = new BufferedImage[4][3];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    img_player_1_walk[i][j] = img_player_1.getSubimage(r * j, r * i, r, r);
                }
            }
            ImageIcon icon_player_1 = new ImageIcon(img_player_1_walk[0][0]);
            jLabel_player_1 = new JLabel(icon_player_1);
            // Set Image Locations
            size_player_1 = jLabel_player_1.getPreferredSize();
            jLabel_player_1.setBounds(player_1_x, player_1_y, size_player_1.width, size_player_1.height);

            matrix[(int)(player_1_y/radius+0.5)][(int)(player_1_x/radius+0.5)]=0;//cancel person label from matrix

            // load Image: player_2
            BufferedImage img_player_2 = ImageIO.read(new File(player2_path));
            // Crop player RGB animations
            img_player_2_walk = new BufferedImage[4][3];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    img_player_2_walk[i][j] = img_player_2.getSubimage(r * j, r * i, r, r);
                }
            }
            ImageIcon icon_player_2 = new ImageIcon(img_player_2_walk[0][0]);
            jLabel_player_2 = new JLabel(icon_player_2);
            // Set Image Locations
            size_player_2 = jLabel_player_2.getPreferredSize();
            jLabel_player_2.setBounds(player_2_x, player_2_y, size_player_2.width, size_player_2.height);
            matrix[(int)(player_2_y/radius+0.5)][(int)(player_2_x/radius+0.5)]=0;//cancel person label from matrix


            // Stack JLabel onto JPanels
            jLayeredPane_main.add(jLabel_map, JLayeredPane.DEFAULT_LAYER);
            jLayeredPane_main.add(jLabel_player_1, JLayeredPane.POPUP_LAYER);
            jLayeredPane_main.add(jLabel_player_2, JLayeredPane.POPUP_LAYER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static JLabel buildBlock(int x,int y){
        int r=radius;
        try{
            ImageIcon image = new ImageIcon("./resources/block/block.png");

            JLabel tlabel=new JLabel(image);
            tlabel.setBounds(x * r, y * r, r, r);
            tlabel.setOpaque(false);
            return tlabel;
        }catch (Exception e) {
            JLabel tlabel = new JLabel();
            tlabel.setBounds(x * r, y * r, r, r);
            tlabel.setBackground(Color.BLACK);
            tlabel.setOpaque(true);
            return tlabel;
        }
    }
    public static JLabel buildTempBlock(int x,int y){
        int r=radius;
        Random r1 = new Random();
        String block_addr ;
        try{
        	switch(r1.nextInt(3) ) {
        	case 0:
        		block_addr = "./resources/block/tempblock.png";
        		break;
        	case 1:
        		block_addr = "./resources/block/tempblock_02.png";
        		break;
        	case 2:
        		block_addr = "./resources/block/tempblock_03.png";
        		break;
        	case 3:
        		block_addr = "./resources/block/tempblock_04.png";
        		break;
        	default:
        		block_addr = "./resources/block/tempblock.png";
        		break;
        	}

    		ImageIcon image = new ImageIcon( block_addr );
    		JLabel tlabel=new JLabel(image);
            tlabel.setBounds(x * r, y * r, r, r);
            tlabel.setOpaque(false);
            return tlabel;
        }
        catch(Exception e){
            JLabel tlabel = new JLabel();
            tlabel.setBounds(x * r, y * r, r, r);
            tlabel.setBackground(Color.GREEN);
            tlabel.setOpaque(true);
            return tlabel;
        }
    }
}
