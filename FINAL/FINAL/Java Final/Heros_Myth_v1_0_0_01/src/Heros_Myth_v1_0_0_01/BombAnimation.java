package Heros_Myth_v1_0_0_01;

import Extension.Node;
import Extension.Parameter;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BombAnimation extends Parameter implements Runnable{
    public static int tempJudgement1;
    public static int tempJudgement2;
    public static int tempjudgementNPC1;
    public static int tempjudgementNPC2;
    public BombAnimation(Node link){
    	tempJudgement1=-1;
    	tempJudgement2=-1;
    	tempjudgementNPC1=-1;
    	tempjudgementNPC2=-1;
        this.player=link.player;
        this.link=link;
    }

    public static JLabel buildAnimation(int player){
        JLabel tlabel=new JLabel();
        if (player == 1) {
            tlabel.setBackground(new Color(0,0,225,255));
            // BombNumNow_p1 -= 1;
            
        }else if(player==2){
            tlabel.setBackground(new Color(255,0,0,255));
            // BombNumNow_p2 -= 1;
            
        }else if(player==6721){
            tlabel.setBackground(new Color(0,255,255));
            
        }
        tlabel.setBounds(link.x,link.y,radius,radius);
        tlabel.setOpaque(true);
        return tlabel;
    }
    public static int getPowerDistance(int power,int coordinateX,int coordinateY,int directX,int directY){
        int adjustPower=power;
        if (coordinateX<0)
            coordinateX=0;
        if (coordinateY<0)
            coordinateY=0;
        if (directX==-1){
            for (int i = 0; i < power; i++) {
                if (coordinateX-i>=0){
                    if (matrix[coordinateX - i][coordinateY] == -1 || matrix[coordinateX - i][coordinateY] == -2) {
                        return i;
                    }
                }else
                    return i;
            }
        }
        else if (directX==1){
            for (int i = 0; i < power; i++) {
                if (coordinateX + i <= mapXSize - 1 ){
                    if ( matrix[coordinateX + i][coordinateY] == -1 || matrix[coordinateX + i][coordinateY] == -2) {
                        return  i ;
                    }
                }else
                    return i;
            }
        }else if (directY==-1){
            for (int i = 0; i < power; i++) {
                if (coordinateY - i >=0){
                    if ( matrix[coordinateX ][coordinateY-i] == -1 || matrix[coordinateX ][coordinateY- i] == -2) {
                        return  i ;
                    }
                }else return i;
            }
        }
        else if (directY==1){
            for (int i = 0; i < power; i++) {
                if (coordinateY + i <= mapYSize - 1 ){
                    if ( matrix[coordinateX ][coordinateY+ i] == -1 || matrix[coordinateX ][coordinateY+ i] == -2) {
                        return  i ;
                    }
                }else return i;
            }
        }
        return adjustPower;
    }
    public static void player1(){
        if (tempJudgement1==-1){
            if (player == 1)
                tempJudgement1 = 11;
            else if (player == 2)
                tempJudgement1 = 21;
            else if (player == 6721)
                tempJudgement1 = 67211;
            else if (player == 6722)
                tempJudgement2 = 67221;
        }
    }
    public static void player2(){
        if (tempJudgement2==-1){
            if (player == 1)
                tempJudgement2 = 12;
            else if (player == 2)
                tempJudgement2 = 22;
            else if (player == 6721)
                tempJudgement2 = 67212;
            else if (player == 6722)
                tempJudgement2 = 67222;
        }
    }
    public static void Npc1(){
        if (tempjudgementNPC1==-1){
            if (player == 1)
                tempjudgementNPC1 = 16721;
            else if (player == 2)
                tempjudgementNPC1 = 26721;
            else if (player == 6721 || player == 6722) {
                System.out.println("NPC Can't kill themselves By Npc1");
            }
        }
    }
    public static void Npc2(){
        if (tempjudgementNPC2==-1){
            if (player == 1)
                tempjudgementNPC2 = 16722;
            else if (player == 2)
                tempjudgementNPC2 = 26722;
            else if (player == 6722 || player == 6721) {
                System.out.println("NPC Can't kill themselves By Npc2");
            }
        }
    }
    public void run(){
        label1=buildAnimation(player);//top
        label2=buildAnimation(player);//bottom
        label3=buildAnimation(player);//left
        label4=buildAnimation(player);//right
        label5=buildAnimation(player);//middle

        int power=0;
        if (player==1){
            power=p1Power;
        }else if (player==2){
            power=p2Power;
        }else if (player==6721)
            power= Npc1power;
        else if(player==6722)
            power=Npc2power;
        int p1x,p1y,p2x,p2y;
        int p1xR,p1yR,p2xR,p2yR;
        int p1xA,p1yA,p2xA,p2yA;
        p1x=positionNotRound(player_1_x);
        p1xR=positionRound(player_1_x);
        p1xA=position(player_1_x);
        p1y=positionNotRound(player_1_y);
        p1yR=positionRound(player_1_y);
        p1yA=position(player_1_y);

        p2x=positionNotRound(player_2_x);
        p2xR=positionRound(player_2_x);
        p2xA=position(player_2_x);
        p2y=positionNotRound(player_2_y);
        p2yR=positionRound(player_2_y);
        p2yA=position(player_2_y);



        int adjustedPower;
        //up
        adjustedPower=getPowerDistance(power,label1.getY()/radius,label1.getX()/radius,-1,0);
        label1.setBounds(label1.getX(),label1.getY()-adjustedPower*radius,radius,adjustedPower*radius);
        //player1
        if(condition(p1xA,p1y,p1yR,label1,"updown")){
            player1();
        }
        //player2
        if(condition(p2xA,p2y,p2yR,label1,"updown")){
            player2();
        }
        if (Npc1px*radius>=label1.getY() && Npc1px*radius<label1.getY()+label1.getHeight() && Npc1py*radius==label1.getX()){
            Npc1();
        }
        if (Npc2px*radius>=label1.getY() && Npc2px*radius<label1.getY()+label1.getHeight() && Npc2py*radius==label1.getX()){
            Npc2();
        }
        for (int i=1;i<=adjustedPower;i++){
            if (link.y/radius-i>=0){
                if (matrix[link.y / radius - i][link.x / radius]==-31||matrix[link.y / radius - i][link.x / radius]==-32) {
                    Node temp=LinkedList.getTheNode(link.x,link.y-i*radius);
                    LinkedList.setLink("clean",temp.x,temp.y,temp.label,temp.player);
                }
            }else
                break;
        }//bomb another

        //down
        adjustedPower=getPowerDistance(power,label2.getY()/radius,label2.getX()/radius,1,0);
        label2.setBounds(label2.getX(),label2.getY()+radius,radius,adjustedPower*radius);
        if(condition(p1xA,p1y,p1yR,label2,"updown")){
            player1();
        }
        if(condition(p2xA,p2y,p2yR,label2,"updown")){
            player2();
        }
        if (Npc1px*radius>=label2.getY() && Npc1px*radius<label2.getY()+label2.getHeight() && Npc1py*radius==label2.getX()){
            Npc1();
        }
        if (Npc2px*radius>=label2.getY() && Npc2px*radius<label2.getY()+label2.getHeight() && Npc2py*radius==label2.getX()){
            Npc2();
        }
        for (int i=1;i<=adjustedPower;i++){
            if (link.y/radius+i<=mapXSize-1){
                if (matrix[link.y / radius + i][link.x / radius]==-31||matrix[link.y / radius + i][link.x / radius]==-32) {
                    Node temp=LinkedList.getTheNode(link.x,link.y+i*radius);
                    LinkedList.setLink("clean",temp.x,temp.y,temp.label,temp.player);
                }
            }else
                break;
        }

        //left
        adjustedPower=getPowerDistance(power,label3.getY()/radius,label3.getX()/radius,0,-1);
        label3.setBounds(label3.getX()-adjustedPower*radius,label3.getY(),adjustedPower*radius,radius);
        if(condition(p1yA,p1x,p1xR,label3,"leftright")){
            player1();
        }
        if(condition(p2yA,p2x,p2xR,label3,"leftright")){
            player2();
        }
        if (Npc1py*radius>=label3.getX() && Npc1py*radius<label3.getX()+label3.getWidth() && Npc1px*radius==label3.getY()){
            Npc1();
        }
        if (Npc2py*radius>=label3.getX() && Npc2py*radius<label3.getX()+label3.getWidth() && Npc2px*radius==label3.getY()){
            Npc2();
        }
        for (int i=1;i<=adjustedPower;i++){
            if (link.x/radius-i>=0){
                if (matrix[link.y / radius ][link.x / radius-i]==-31||matrix[link.y / radius ][link.x / radius- i]==-32) {
                    Node temp=LinkedList.getTheNode(link.x-i*radius,link.y);
                    LinkedList.setLink("clean",temp.x,temp.y,temp.label,temp.player);
                }
            }else
                break;
        }
        //right
        adjustedPower=getPowerDistance(power,label4.getY()/radius,label4.getX()/radius,0,1);
        label4.setBounds(label4.getX()+radius,label4.getY(),adjustedPower*radius,radius);
        if(condition(p1yA,p1x,p1xR,label4,"leftright")){
            player1();
        }
        if(condition(p2yA,p2x,p2xR,label4,"leftright")){
            player2();
        }
        if (Npc1py*radius>=label4.getX() && Npc1py*radius<label4.getX()+label4.getWidth() && Npc1px*radius==label4.getY()){
            Npc1();
        }
        if (Npc2py*radius>=label4.getX() && Npc2py*radius<label4.getX()+label4.getWidth() && Npc2px*radius==label4.getY()){
            Npc2();
        }
        for (int i=1;i<=adjustedPower;i++){
            if (link.x/radius+i<=mapYSize-1){
                if (matrix[link.y / radius ][link.x / radius+ i]==-31||matrix[link.y / radius ][link.x / radius+ i]==-32) {
                    Node temp=LinkedList.getTheNode(link.x+i*radius,link.y);
                    LinkedList.setLink("clean",temp.x,temp.y,temp.label,temp.player);
                }
            }else
                break;
        }

        if((player_1_x+radius*0.8>=link.x &&player_1_x<=link.x+radius) && (player_1_y+radius*0.2>=link.y&& player_1_y<=link.y+radius)){
            player1();
        }
        if((player_2_x+radius*0.8>=link.x &&player_2_x<=link.x+radius)&& (player_2_y+radius*0.2>=link.y&& player_2_y<=link.y+radius)){
            player2();
        }
        if ((Npc1py*radius>=link.x && Npc1py*radius<=link.x+radius )&&(Npc1px*radius>=link.y &&Npc1px*radius<=link.y+radius) ){
            Npc1();
        }
        if ((Npc2py*radius>=link.x && Npc2py*radius<=link.x+radius )&&(Npc2px*radius>=link.y &&Npc2px*radius<=link.y+radius) ) {
            Npc2();
        }
        showAndDisappear();

    }
    public static boolean condition(int n1,int n2,int n3,JLabel label,String string){
        if (string.equals("updown")){
            if (n1 == label.getX() && ((n2 >= label.getY() && n2 < label.getY() + label.getHeight()) || (n3 >= label.getY() && n3 <label.getY() + label.getHeight())))
                return true;
        }
        else if (string.equals("leftright")){
            if (n1==label.getY()&&((n2>=label.getX()&&n2<label.getX()+label.getWidth())||(n3>=label.getX()&&n3<label.getX()+label.getWidth())))
                return true;
        }
        return false;
    }
    public static void showAndDisappear(){
        jLayeredPane_main.add(label1, JLayeredPane.POPUP_LAYER);
        jLayeredPane_main.add(label2, JLayeredPane.POPUP_LAYER);
        jLayeredPane_main.add(label3, JLayeredPane.POPUP_LAYER);
        jLayeredPane_main.add(label4,JLayeredPane.POPUP_LAYER);
        jLayeredPane_main.add(label5, JLayeredPane.POPUP_LAYER);
        jLayeredPane_main.repaint();
        for (int i=255;i>0;i-=5){
            bombEndAnimation(player,label1,i);
            bombEndAnimation(player,label2,i);
            bombEndAnimation(player,label3,i);
            bombEndAnimation(player,label4,i);
            bombEndAnimation(player,label5,i);
            jLayeredPane_main.repaint();
            if (i%15==0){
                try {
                    TimeUnit.NANOSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        jLayeredPane_main.remove(label1);
        jLayeredPane_main.remove(label2);
        jLayeredPane_main.remove(label3);
        jLayeredPane_main.remove(label4);
        jLayeredPane_main.remove(label5);
        judgement1=tempJudgement1;
        judgement2=tempJudgement2;
        judgementNPC1=tempjudgementNPC1;
        judgementNPC2=tempjudgementNPC2;
        if (player == 1) {
            BombNumNow_p1 -= 1;
            
        }else if(player==2){
            BombNumNow_p2 -= 1;
            
        }else if(player==6721){
            BombNumNow_NPC1 -= 1;
        }else if(player==6722){
            BombNumNow_NPC2 -= 1;
        }
    }

    public static void bombEndAnimation(int player,JLabel label,int i){
        if (player==1)
            label.setBackground(new Color(0,0,255,i));
        else if (player==2)
            label.setBackground(new Color(255,0,0,i));
        else if (player==6721)
            label.setBackground(new Color(0,255,255,i));
    }
}
