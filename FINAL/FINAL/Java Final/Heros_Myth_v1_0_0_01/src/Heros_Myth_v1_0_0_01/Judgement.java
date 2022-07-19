package Heros_Myth_v1_0_0_01;

import Extension.Node;
import Extension.Parameter;

import java.util.concurrent.TimeUnit;

public class Judgement extends Parameter{
    public Judgement(Node tempLink){
        for (Node i=tempLink;i!=null;i=i.next){
            this.tempLink=i;
            run();
            if (i.x==LinkedList.bombLink.x && i.y==LinkedList.bombLink.y) {
                LinkedList.bombLink = LinkedList.bombLink.next;
            }
            else {
                for (Node j = LinkedList.bombLink,k=null; j != null; j = j.next) {
                    if (k==null)
                        k=j;
                    if (j.next.x==i.x && j.next.y==i.y){
                        j.next=j.next.next;
                        LinkedList.bombLink=k;
                        break;
                    }
                }
            }
        }
        LinkedList.cleanLink=null;
    }

    public static void run() {
        coordinateX =tempLink.y / radius;
        coordinateY = tempLink.x / radius;
        Thread bombAnimation=new Thread(new BombAnimation(tempLink));
        jLayeredPane_main.remove(tempLink.label);
        jLayeredPane_main.repaint();

        int power = 0;
        if (tempLink.player == 1)
            power = p1Power;
        else if (tempLink.player == 2)
            power = p2Power;
        else if (tempLink.player==6721)
            power = Npc1power;
        else if (tempLink.player==6722)
            power= Npc2power;

        bombAnimation.start();//who get bomb and hasOtherbomb judge in animation
        int d1x,d1y,d2x,d2y,d3x,d3y,d4x,d4y;
        d1x=d1y=d2x=d2y=d3x=d3y=d4y=d4x=-1;
        
        //left
        for (int i = 1; i <= power; i++) {
            if (coordinateY-i>=0 && matrix[coordinateX][coordinateY-i]==-2){
                LinkedList.getDetailsAndRemove(coordinateY-i,coordinateX);
                d1x=coordinateX;
                d1y=coordinateY-i;
                break;
            }
            else if (coordinateY-i>=0 && matrix[coordinateX][coordinateY-i]==-1)
                break;
        }
        //right
        for (int i = 1; i <= power; i++) {
            if (coordinateY+i<=mapYSize-1 && matrix[coordinateX][coordinateY+i]==-2){
                LinkedList.getDetailsAndRemove(coordinateY+i,coordinateX);
                
                d2x=coordinateX;
                d2y=coordinateY+i;
                break;
            }

            else if (coordinateY+i<=mapYSize-1 && matrix[coordinateX][coordinateY+i]==-1)
                break;
        }
        //top
        for (int i = 1; i <= power; i++) {
            if (coordinateX-i>=0 && matrix[coordinateX-i][coordinateY]==-2){
                LinkedList.getDetailsAndRemove(coordinateY,coordinateX-i);
                d3x=coordinateX-i;
                d3y=coordinateY;
                break;
            }
            else if (coordinateX-i>=0 && matrix[coordinateX-i][coordinateY]==-1)
                break;
        }
        //bottom
        for (int i = 1; i <= power; i++) {
            if (coordinateX+i<=mapXSize-1 && matrix[coordinateX+i][coordinateY]==-2){
                LinkedList.getDetailsAndRemove(coordinateY,coordinateX+i);
                d4x=coordinateX+i;
                d4y=coordinateY;
                break;
            }
            else if (coordinateX+i<=mapXSize-1 && matrix[coordinateX+i][coordinateY]==-1)
                break;
        }
        while (bombAnimation.isAlive()){
            try {
                TimeUnit.NANOSECONDS.sleep(1);
            }catch (InterruptedException e){e.printStackTrace();}
        }
        if (d1x!=-1 && d1y!=-1){
            matrix[d1x][d1y]=0;
        }
        if (d2x!=-1 && d2y!=-1){
            matrix[d2x][d2y]=0;
        }
        if (d3x!=-1 && d3y!=-1){
            matrix[d3x][d3y]=0;
        }
        if (d4x!=-1 && d4y!=-1){
            matrix[d4x][d4y]=0;
        }
        matrix[tempLink.y/radius][tempLink.x/radius]=0;
    }
}
