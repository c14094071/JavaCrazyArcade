package Npc2;

import Extension.Parameter;

public class GetObjectDetails extends Parameter {
    public static double getPlayerDistance(int x,int y){
        int temp1,temp2;
        temp1=x-position(player_2_y)/ radius;
        temp2=y-position(player_2_x)/radius;
        return Math.sqrt(temp1*temp1+temp2*temp2);
    }
    public static boolean checkTheBomb(int x,int y){
        boolean temp=false;
        int i,j;
        i=x-5;
        j=x+5;
        if (j>=mapXSize-1)
            j=mapXSize-1;
        if (i<0)
            i=0;
        for (;i<j;i++){
            if (matrix[i][y]==-31){
                temp=true;
            }
        }
        i=y-5;
        j=x+5;
        if (j>=mapYSize-1)
            j=mapYSize-1;
        if (i<0)
            i=0;
        for (;i<j;i++){
            if (matrix[x][i]==-31){
                temp=true;
            }
        }
        return temp;
    }
    public static int getTheTempBlockNumber(){
        return calTempBlockNumber();
    }
}
