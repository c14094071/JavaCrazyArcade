package Extension;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Parameter {
    public static int judgement1=-1;
    public static int judgement2=-1;
    public static int judgementNPC1=-1;
    public static int judgementNPC2=-1;
    public final static int radius=32;
    public final static int timesBlock=5;
    public final static int timesTempBlock=15;
    public final static int mapXSize=14;
    public final static int mapYSize=20;
    public final static int player_1_step = 4;
    public final static int player_2_step = 4;
    public static int p1Power=1;
    public static int p2Power=1;


    public static int BombNumNow_p1 = 0;
    public static int BombNumNow_p2 = 0;
    public static int BombNumNow_NPC1 = 0;
    public static int BombNumNow_NPC2 = 0;
    public static int BombNumMax_p1 = 5;
    public static int BombNumMax_p2 = 5;
    public static int BombNumMax_NPC1 = 5;
    public static int BombNumMax_NPC2 = 5;
    public static int AnimeNumNow_p1 = 0;
    public static int AnimeNumNow_p2 = 0;
    public static int AnimeNumMax_p1 = 3;
    public static int AnimeNumMax_p2 = 3;

    // blood
    public static int p1Blood = 3;
    public static int p2Blood = 3;
    public static int npc1Blood = 3;
    public static int npc2Blood = 3;
    public static int mode = -1;
    public static int exit = 0;

    //!!! line 38 to 41 from ReadKeyboard class other from Main_App class !!!
    public final static int adjustBottomFrameSize = -radius - 38;//38 is the mainly adjust number
    public final static int adjustRightFrameSize = -radius - 14;//14 is the mainly adjust number
    public final static int frameSizeX=radius*mapYSize-adjustRightFrameSize-radius;//radius*mapSize need to adjust the adjust num is get from ReadKeyboard
    public final static int frameSizeY=radius*mapXSize-adjustBottomFrameSize-radius;

    //!!!from Blood class !!!
    // variable announce
    public static JLabel jLabel_heart1_1, jLabel_heart1_2, jLabel_heart1_3,
            jLabel_heart2_1, jLabel_heart2_2, jLabel_heart2_3,
            jLabel_heart_npc1_1, jLabel_heart_npc1_2, jLabel_heart_npc1_3,
            jLabel_heart_npc2_1, jLabel_heart_npc2_2, jLabel_heart_npc2_3;
    public static int width = 30;
    public static int height = 30;

    //!!! line 55 to 61 from BombAnimation!!!
    public static JLabel label1,label2,label3,label4,label5;
    public static int player;
    public static Node link;

    //!!! line 66 to 72 from BuildPlayer !!!
    public static BufferedImage[][] img_player_1_walk;
    public static BufferedImage[][] img_player_2_walk;

    public static JLabel jLabel_player_1;
    public static JLabel jLabel_player_2;
    public static Dimension size_player_1;
    public static Dimension size_player_2;

    //!!! line 75 to 76 from FrameSetting !!!
    public static JFrame jFrame_main = new JFrame();
    public static JLayeredPane jLayeredPane_main = new JLayeredPane();

    //!!! line 79 to 80 from items !!!
    public static Item_Node first_node = new Item_Node();
    public static Item_Node now_node = null;

    //!!! line 83 to 84 from Judgement!!!
    public static int coordinateX, coordinateY;//position of matrix
    public static Node tempLink;

    //!!! line 85 to 90 form KeyListen!!!
    public static int player_cmd_1 = -1;
    public static int player_cmd_2 = -1;
    public static int player1weapon=-1;
    public static int player2weapon=-1;
    public static int player_1_faceON = 0;
    public static int player_2_faceON = 0;

    //!!! line 93 to 97from LinkedList!!!
    public static Node bombLink;
    public static Node tempBlockLink;
    public static Node blockLink;
    public static Node cleanLink;
    public static int notDuplicate=200;
    public static int calTempBlockNumber(){
        int num=0;
        for (Node i=tempBlockLink;i!=null;i=i.next){
            num++;
        }
        return num;
    }//giving the npc package use

    //!!! line 100 to 104 from Matrix!!!
    public static int player_1_x ;//has been change to the coordinate in matrix
    public static int player_1_y ;//if who wish to get the coordinate in map can call player*radius
    public static int player_2_x ;
    public static int player_2_y ;
    public static int[][]matrix;//only use for the first time build label;

    //!!! line 107 to 127 from image_Tookies !!!
    public static int position(int position){
        double point=position;
        point/=radius;
        point+=0.5;
        int changeType=((int)point)*radius;
        return changeType;
    }
    public static int positionRound(int position){
        double point=position;
        point/=radius;
        point+=0.7;
        int changeType=((int)point)*radius;
        return changeType;
    }
    public static int positionNotRound(int position){
        double point=position;
        point/=radius;
        point+=0.3;
        int changeType=((int)point)*radius;
        return changeType;
    }

    //!!!line 137 to 138 from Npc1!!!
    public static int Npc1px,Npc1py;//matrix coordinate
    public static int Npc1power=1;

    //!!! line 141 to 142 from Npc2 !!!
    public static int Npc2px,Npc2py;//matrix coordinate
    public static int Npc2power=1;

    //by End_game
    public static int stopAllThread=-1;
    public static String player2_path,player1_path;
}

