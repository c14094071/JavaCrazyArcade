package Heros_Myth_v1_0_0_01;

import Extension.Parameter;

public class PlayerStartPosition extends Parameter {
    int cal=0;
    int positionX=404;
    int positionY=404;
    public static int map(int i,int j,int directX,int directY){
        if (matrix[i+directX][j+directY]==0)
            return 1;
        else
            return 0;
    }
    public PlayerStartPosition(int player,int MapX,int MapY,int radius){
        if (player==1){
            loop1:
            for (int i = 0; i < MapX / 2; i++) {
                for (int j = 0; j < MapY / 2-3; j++) {
                    cal += map(i, j, 1, 0);
                    if (i!=0){
                        cal += map(i, j, -1, 0);
                    }
                    cal += map(i, j, 0, 1);
                    if (j!=0){
                        cal += map(i, j, 0, -1);
                    }
                    if (cal >= 3) {
                        positionY = j;
                        positionX = i;
                        break loop1;
                    } else {
                        cal = 0;
                        positionY=404;
                        positionX=404;
                    }
                }
            }
            if (positionX!=404&&positionY!=404){
                matrix[positionX][positionY]=1;
                player_1_y=positionX*radius;
                player_1_x=positionY*radius;
            }
        }
        else if (player==2){
            loop1:
            for (int i = 0; i < MapX/2 ; i++) {
                for (int j = MapY/2+3; j < MapY ; j++) {
                    cal += map(i, j, 1, 0);
                    if (i!=0){
                        cal += map(i, j, -1, 0);
                    }
                    if (j!=MapY-1){
                        cal += map(i, j, 0, 1);
                    }
                    if (j!=0){
                        cal += map(i, j, 0, -1);
                    }
                    if (cal >= 3) {
                        positionY = j;
                        positionX = i;
                        break loop1;
                    } {
                        cal = 0;
                        positionY=404;
                        positionX=404;
                    }
                }
            }
            if (positionX!=404&&positionY!=404){
                matrix[positionX][positionY]=2;
                player_2_y=positionX*radius;
                player_2_x=positionY*radius;
            }
        }

    }

}
