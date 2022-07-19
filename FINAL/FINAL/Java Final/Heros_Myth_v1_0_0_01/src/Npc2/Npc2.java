package Npc2;

import Extension.Parameter;
import Heros_Myth_v1_0_0_01.Image_Tookies;
import Heros_Myth_v1_0_0_01.Matrix;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Npc2 extends Parameter implements Runnable{
    public static JLabel label;
    public static long time;
    public static int step=4;
    public static int printingCmd;
    public Npc2(){
        time=System.currentTimeMillis();
        Neuron.setRanTime(time);
        Npc2px= mapXSize-1;
        Npc2py=mapYSize-1;
        matrix[Npc2px][Npc2py]=0;
        matrix[Npc2px-1][Npc2py]=0;
        matrix[Npc2px][Npc2py-1]=0;
        ImageIcon item_icon = new ImageIcon("resources/items/NPC_02.png");
		label = new JLabel(item_icon);
        label.setBounds(Npc2py*radius,Npc2px*radius,radius,radius);
        jLayeredPane_main.add(label,JLayeredPane.POPUP_LAYER);
    }
    public static long lastMovingTime;
    public static void setLocation(int x,int y,int directX,int directY){
        lastMovingTime=System.currentTimeMillis();
        for (int i=0;i<radius;i++){
            label.setLocation(label.getX()+directY,label.getY()+directX);
            jFrame_main.repaint();
            try{TimeUnit.MICROSECONDS.sleep(10000/step);}catch (InterruptedException e){e.printStackTrace();}
        }
        Npc2px=x+directX;
        Npc2py=y+directY;
    }
    public static void putABombBesidesTempBlock(){
        int verify=0;
        if (Npc2px-1>=0 && matrix[Npc2px-1][Npc2py]==-2)
            verify=1;
        else if (Npc2py-1>=0 && matrix[Npc2px][Npc2py-1]==-2)
            verify=1;
        else if (Npc2px+1<=mapXSize-1 && matrix[Npc2px+1][Npc2py]==-2)
            verify=1;
        else if (Npc2py+1<=mapYSize-1 && matrix[Npc2px][Npc2py+1]==-2)
            verify=1;

        if (verify==1)
            putABomb();
    }
    public static int giveUpUp=-1;
    public static long putBombTime=0;
    public static int adjust=0;
    public static void putABomb() {
        if (putBombTime==0)
            putBombTime=System.currentTimeMillis();
        if( BombNumNow_NPC2 < BombNumMax_NPC2 ) {
    		
	        if (Matrix.verifyBombStack(Npc2py* radius,Npc2px*radius,radius)) {
	        	BombNumNow_NPC2 += 1;
	            try {
	                BufferedImage item_1 = ImageIO.read(new File("./resources/items/4.png"));
	                Image_Tookies imt = new Image_Tookies();
	                imt.add_item_withBufferedImage(item_1, Npc2py * radius, Npc2px * radius, 6722);
	            } catch (IOException e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            }
	        }
        }
    }
    public static boolean checkMove(int x,int y){
        if (x>=0 && x<=mapXSize-1 && y>=0 && y<=mapYSize-1 && matrix[x][y]==0)
            return true;
        else return false;
    }
    public static boolean verifyMove(int directX,int directY){
        if (directX==1){
            if (checkMove(Npc2px+1,Npc2py))
                return true;
        }else if (directX==-1){
            if (checkMove(Npc2px-1,Npc2py))
                return true;
        }else if (directY==1){
            if (checkMove(Npc2px,Npc2py+1))
                return true;
        }else if (directY==-1){
            if (checkMove(Npc2px,Npc2py-1))
                return true;
        }
        return false;
    }
    public static void getTheIdeaKillPlayer(int z){
        if (Npc2px+1<=mapXSize-1 && Npc2px-1>=0 && (matrix[Npc2px+1][Npc2py]==-1||matrix[Npc2px-1][Npc2py]==-1)){
            z=2+(int)(System.currentTimeMillis()-time)%2;
            adjust=0;
        }
        if (Npc2py-1>=0 && Npc2py+1<=mapYSize-1 &&( matrix[Npc2px][Npc2py+1]==-1||matrix[Npc2px][Npc2py-1]==-1)){
            z=(int)(System.currentTimeMillis()-time)%2;
            adjust=0;
        }
        if (z==0){
            if (GetObjectDetails.getPlayerDistance(Npc2px-1,Npc2py)<GetObjectDetails.getPlayerDistance(Npc2px,Npc2py)){
                if (verifyMove(-1,0)) {
                    setLocation(Npc2px, Npc2py, -1, 0);
                    adjust=0;
                }
            }else{
                if (adjust<1 && verifyMove(-1,0)) {
                    setLocation(Npc2px, Npc2py, -1, 0);
                    adjust++;
                }
            }
        }else if (z==1){
            if (GetObjectDetails.getPlayerDistance(Npc2px+1,Npc2py)<GetObjectDetails.getPlayerDistance(Npc2px,Npc2py)){
                if (verifyMove(1,0)) {
                    setLocation(Npc2px, Npc2py, 1, 0);
                }
            }else{
                if (adjust<1 && verifyMove(1,0)) {
                    setLocation(Npc2px, Npc2py, 1, 0);
                    adjust++;
                }
            }
        }else if (z==2){
            if (GetObjectDetails.getPlayerDistance(Npc2px,Npc2py-1)<GetObjectDetails.getPlayerDistance(Npc2px,Npc2py)){
                if (verifyMove(0,-1)) {
                    setLocation(Npc2px, Npc2py, 0, -1);
                }
            }else {
                if (adjust<1 && verifyMove(0,-1)) {
                    setLocation(Npc2px, Npc2py, 0, -1);
                    adjust++;
                }
            }
        }else if (z==3){
            if (GetObjectDetails.getPlayerDistance(Npc2px,Npc2py+1)<GetObjectDetails.getPlayerDistance(Npc2px,Npc2py)){
                if (verifyMove(0,1)) {
                    setLocation(Npc2px, Npc2py, 0, 1);
                }
            }else {
                if (adjust<1 && verifyMove(0,1)) {
                    setLocation(Npc2px, Npc2py, 0, 1);
                    adjust++;
                }
            }
        }
        putABombBesidesTempBlock();
        if (Npc2px*32>player_2_y-64&& Npc2px*32<player_2_y+64&&Npc2py*32>player_2_x-64 && Npc2py*32<player_2_x+64){
            putABomb();
        }
    }
    public static void tryToRunAway(){
        if (Npc2py-1>=0 && !GetObjectDetails.checkTheBomb(Npc2px,Npc2py-1)){
            if (verifyMove(0,-1))
                setLocation(Npc2px,Npc2py,0,-1);
        }
        if (Npc2py+1<=mapYSize-1 && !GetObjectDetails.checkTheBomb(Npc2px,Npc2py+1)){
            if (verifyMove(0,1))
                setLocation(Npc2px,Npc2py,0,1);
        }
        if (Npc2px-1>=0 && !GetObjectDetails.checkTheBomb(Npc2px-1,Npc2py)){
            if (verifyMove(-1,0))
                setLocation(Npc2px,Npc2py,-1,0);
        }
        if (Npc2px+1<=mapXSize-1 && !GetObjectDetails.checkTheBomb(Npc2px+1,Npc2py)){
            if (verifyMove(1,0))
                setLocation(Npc2px,Npc2py,1,0);
        }
    }
    public static void wannaBombTempBlock(int z){
        int i,j;
        i=j=0;
        if (Npc2px+1<=mapXSize-1 && Npc2px-1>=0 && (matrix[Npc2px+1][Npc2py]==-1||matrix[Npc2px-1][Npc2py]==-1)){
            i=2+(int)(System.currentTimeMillis()-time)%2;
        }
        if (Npc2py-1>=0 && Npc2py+1<=mapYSize-1 &&( matrix[Npc2px][Npc2py+1]==-1||matrix[Npc2px][Npc2py-1]==-1)){
            j=(int)(System.currentTimeMillis()-time)%2;
        }
        if (!(i!=0&&j!=0)){
            if (i!=0)
                z=i;
            else if (j!=0)
                z=j;
        }
        if (z==0) {
            if (Npc2px - 1 >= 0 && verifyMove(-1, 0))
                setLocation(Npc2px, Npc2py, -1, 0);
        }
        else if (z==1) {
            if (Npc2px + 1 <= mapXSize - 1 && verifyMove(1, 0))
                setLocation(Npc2px, Npc2py, 1, 0);
        }
        else if (z==2) {
            if (Npc2py - 1 >= 0 && verifyMove(-0, -1))
                setLocation(Npc2px, Npc2py, 0, -1);
        }
        else if (z==3)
            if (Npc2py+1<=mapYSize-1 && verifyMove(0,1))
                setLocation(Npc2px,Npc2py,0,1);
        putABombBesidesTempBlock();
    }
    public void run(){
        long timeStart=0;

        while (npc2Blood!=0 && stopAllThread==-1){
            int z=Neuron.takeAction();
            Neuron.setOpponentDistance((int) GetObjectDetails.getPlayerDistance(Npc2px,Npc2py));
            Neuron.setTempBlockNumber(GetObjectDetails.getTheTempBlockNumber());
            Neuron.setHasABomb(GetObjectDetails.checkTheBomb(Npc2px,Npc2py));
            if (giveUpUp==-1 && z==0) {
                if (printingCmd!=0) {
                    printingCmd = 0;
                    System.out.println("try to kill player2 by NPC2");
                }
                if (timeStart==0)
                    timeStart=System.currentTimeMillis();
                if ((System.currentTimeMillis()-timeStart<5000+(System.currentTimeMillis()-time)*0.05)||GetObjectDetails.getTheTempBlockNumber()==0){
                    getTheIdeaKillPlayer((int) (System.currentTimeMillis()-time)%4);
                }else {
                    giveUpUp=1;
                    timeStart=System.currentTimeMillis();
                }
            }else if (z==1){
                if (printingCmd!=1) {
                    printingCmd = 1;
                    System.out.println("try to cleaning tempblock value by NPC2");
                }
                int direction= (int) (System.currentTimeMillis()-time)%4;
                wannaBombTempBlock(direction);
            }
            else if (z==3){
                if (printingCmd!=3) {
                    printingCmd = 3;
                    System.out.println("try to runaway from a bomb value by NPC2");
                }
                tryToRunAway();
            }
            if (z!=0 && System.currentTimeMillis()-timeStart>3000-(System.currentTimeMillis()-time)*0.0005||System.currentTimeMillis()-time>180000||GetObjectDetails.getTheTempBlockNumber()<25){
                giveUpUp=-1;
            }
            if (System.currentTimeMillis()-putBombTime>2500){
                putBombTime=0;
            }
            try{
                TimeUnit.MILLISECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
