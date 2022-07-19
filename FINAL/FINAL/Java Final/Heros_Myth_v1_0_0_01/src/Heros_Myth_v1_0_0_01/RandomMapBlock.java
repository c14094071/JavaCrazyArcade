package Heros_Myth_v1_0_0_01;
import Extension.Parameter;

import javax.swing.*;
import java.util.Random;

public class RandomMapBlock extends Parameter{
    RandomMapBlock(int timesBlock,int timesTempBLock,int X,int Y) {
        Random randomX = new Random();//pick two random

        Random randomY = new Random();
        Matrix matrix=new Matrix();

        for (int i = 0; i < timesBlock; i++) {
            int y = randomY.nextInt(Y);
            int x = randomX.nextInt(X);
            if (matrix.verifyBuild(x%(X/2),y%(Y/2))){
                matrix.setBlock(y % (Y / 2), x % (X / 2));
            }
            else
                i--;
        }//left top
        for (int i = 0; i < timesBlock; i++) {
            int y = randomY.nextInt(Y);
            int x = randomX.nextInt(X);
            if (matrix.verifyBuild((x % (X / 2)) + (X / 2),y % (Y / 2))){
                matrix.setBlock(y % (Y / 2), (x % (X / 2)) + (X / 2));
            }
            else i--;
        }//right top
        for (int i = 0; i < timesBlock; i++) {
            int y = randomY.nextInt(Y);
            int x = randomX.nextInt(X);
            if(matrix.verifyBuild(x % (X / 2),(y % (Y / 2)) + (Y / 2))){
                matrix.setBlock((y % (Y / 2)) + (Y / 2), x % (X / 2));
            }
            else i--;
        }//left bottom
        for (int i = 0; i < timesBlock; i++) {
            int y = randomY.nextInt(Y);
            int x = randomX.nextInt(X);
            if (matrix.verifyBuild((x % (X / 2)) + (X / 2),(y % (Y / 2)) + (Y / 2))){
                matrix.setBlock((y % (Y / 2)) + (Y / 2), (x % (X / 2)) + (X / 2));
            }
            else
                i--;
        }//right bottom

        for (int i = 0; i < timesTempBLock; i++) {
            int y = randomY.nextInt(Y);
            int x = randomX.nextInt(X);
            if (matrix.verifyBuild(x%(X/2),y%(Y/2))){
                matrix.setTempBlock(y % (Y / 2), x % (X / 2));
            }
            else
                i--;
        }//left top
        for (int i = 0; i < timesTempBLock; i++) {
            int y = randomY.nextInt(Y);
            int x = randomX.nextInt(X);
            if (matrix.verifyBuild((x % (X / 2)) + (X / 2),y % (Y / 2))){
                matrix.setTempBlock(y % (Y / 2), (x % (X / 2)) + (X / 2));
            }
            else i--;
        }//right top
        for (int i = 0; i < timesTempBLock; i++) {
            int y = randomY.nextInt(Y);
            int x = randomX.nextInt(X);
            if(matrix.verifyBuild(x % (X / 2),(y % (Y / 2)) + (Y / 2))){
                matrix.setTempBlock((y % (Y / 2)) + (Y / 2), x % (X / 2));
            }
            else i--;
        }//left bottom
        for (int i = 0; i < timesTempBLock; i++) {
            int y = randomY.nextInt(Y);
            int x = randomX.nextInt(X);
            if (matrix.verifyBuild((x % (X / 2)) + (X / 2),(y % (Y / 2)) + (Y / 2))){
                matrix.setTempBlock((y % (Y / 2)) + (Y / 2), (x % (X / 2)) + (X / 2));
            }
            else
                i--;
        }//right bottom

    }
    public static void showBlock(){
        int r=radius;
        for (int i = 0; i < mapXSize ; i++) {
            for (int j = 0; j < mapYSize ; j++) {
                if (Matrix.matrix[i][j] == -1) {
                    if (i == 0 || i == mapXSize-1 || j == 0 || j == mapYSize-1) {
                        System.out.println();
                        Matrix.matrix[i][j] = -2;
                        JLabel label=BuildPlayer.buildTempBlock(j, i);
                        LinkedList.setLink("tempblock",j,i,label,-1);
                        jLayeredPane_main.add(label,JLayeredPane.POPUP_LAYER);
                    } else {
                        JLabel label=BuildPlayer.buildBlock(j, i);
                        LinkedList.setLink("block",j,i,label,-1);
                        jLayeredPane_main.add(label, JLayeredPane.POPUP_LAYER);
                    }

                } else if (Matrix.matrix[i][j] == -2) {
                    JLabel label=BuildPlayer.buildTempBlock(j, i);
                    LinkedList.setLink("tempblock",j,i,label,-1);
                    jLayeredPane_main.add(label, JLayeredPane.POPUP_LAYER);
                }
            }
        }
    }
}
