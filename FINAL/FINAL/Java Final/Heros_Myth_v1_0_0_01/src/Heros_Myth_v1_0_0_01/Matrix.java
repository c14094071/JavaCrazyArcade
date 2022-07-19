package Heros_Myth_v1_0_0_01;

import Extension.Node;
import Extension.Parameter;

public class Matrix extends Parameter {

    public Matrix(){};
    public Matrix(int x,int y){
        matrix=new int[x][y];//bound has been cancel in this matrix
    }

    public void setBlock(int x,int y){
        matrix[x][y]=-1;
    }

    public void setTempBlock(int x,int y){
        matrix[x][y]=-2;
    }
    public static int bombLinkAdjust(Node linklist, int ix, int iy, int px, int py){
        if (linklist==bombLink && ix==position(px) && iy==position(py)){
            return 0;
        }
        return -1;
    }
    public static boolean verifyBombStack(int x,int y,int radius){
        if (matrix[position(y)/radius][position(x)/radius]!=-32 && matrix[position(y)/radius][position(x)/radius]!=-31)
            return true;
        else
            return false;
    }

    public static int checkLinkedList(Node linklist,int px,int py,int directX,int directY){
        int verify=0;
        if (directX==1){
            for (Node i = linklist; i != null; i = i.next) {
                if ((py + radius*0.3 >= i.y && py + radius*0.3 <= i.y + radius )||(py + radius*0.9 >= i.y && py + radius*0.9 <= i.y + radius ))
                    if((px/radius)*radius == i.x - radius) {
                        verify = bombLinkAdjust(linklist,i.x,i.y,px,py);
                        break;
                    }
            }
        }
        else if (directX==-1){
            for (Node i = linklist; i != null; i = i.next) {
                if ((py + radius*0.3 >= i.y && py + radius*0.3 <= i.y + radius )||(py + radius*0.9 >= i.y && py + radius*0.9 <= i.y + radius ))
                    if ((px/radius)*radius==i.x) {
                        verify = bombLinkAdjust(linklist,i.x,i.y,px,py);
                        break;
                    }
            }
        }
        else if (directY==1){
            for (Node i = linklist; i != null; i = i.next) {
                if ((px + radius*0.3 >= i.x && px + radius*0.3 <= i.x + radius )||(px + radius*0.9 >= i.x && px + radius*0.9 <= i.x + radius ))
                    if ((py/radius)*radius==i.y-radius){
                        verify = bombLinkAdjust(linklist,i.x,i.y,px,py);
                        break;
                    }
            }
        }
        else if (directY==-1){
            for (Node i = linklist; i != null; i = i.next) {
                if ((px + radius*0.3 >= i.x && px + radius*0.3 <= i.x + radius )||(px + radius*0.9 >= i.x && px + radius*0.9 <= i.x + radius ))
                    if ((py/radius)*radius==i.y){
                        verify = bombLinkAdjust(linklist,i.x,i.y,px,py);
                        break;
                    }
            }
        }
        return verify;
    }
    public static int checkMove(int px,int py,int directX,int directY){
        int v1,v2,v3;
        v1=v2=v2=0;
        v1=checkLinkedList(tempBlockLink,px,py,directX,directY);
        v2=checkLinkedList(blockLink,px,py,directX,directY);
        v3=checkLinkedList(bombLink,px,py,directX,directY);
        if (v1==-1||v2==-1||v3==-1)
            return -1;
        else
            return 0;
    }
    public static boolean verifyMove(int player,int directX,int directY){
        int verify=0;
        if(player==1){
            verify=checkMove(player_1_x,player_1_y,directX,directY);
        }
        else if (player==2){
            verify=checkMove(player_2_x,player_2_y,directX,directY);
        }
        if (verify!=-1){
            return true;
        }else
            return false;
    }

    public boolean verifyBuild(int coordinateX,int coordinateY){
        if (matrix[coordinateY][coordinateX]!=-1 && matrix[coordinateY][coordinateX]!=-2)
            return true;
        else
            return false;
    }

    public static int clearDataAndRestart(int timesBlock,int timesTempBLock,int x,int y){
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                matrix[i][j]=0;
            }
        }

        new RandomMapBlock(timesBlock,timesTempBLock,y,x);
        PlayerStartPosition playerStartPosition1=new PlayerStartPosition(1,x,y,radius);
        PlayerStartPosition playerStartPosition2=new PlayerStartPosition(2,x,y,radius);
        if (playerStartPosition1.positionX!=404 && playerStartPosition2.positionX!=404){
            return 1;
        }
        else
            return -1;
    }

}
