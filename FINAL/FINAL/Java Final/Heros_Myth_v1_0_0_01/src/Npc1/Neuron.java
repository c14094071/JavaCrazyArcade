package Npc1;

public class Neuron{
    private static double opponentDistance;
    private static double tempBlockNumber;
    private static double ranTime;
    private static double hasABomb;

    public static void setOpponentDistance(int x){
        opponentDistance=x;
    }
    public static void setTempBlockNumber(int x) {
        tempBlockNumber = x;
    }
    public static void setRanTime(long x) {
        ranTime = x;
    }
    public static void setHasABomb(Boolean bool){
        if (bool){
            hasABomb = 99999999;
            for (int i = 0; i < 5; i++) {
                hasABomb *= hasABomb;
            }
        }else
            hasABomb=0;
    }
    final private static double wOpponentDistance=4;
    final private static double wTempBlockNumber= 0.03;
    final private static double wRanTime=0.0001;

    private static double bGotoBombPlayer;
    private static double bGoToBombTempBlock;

    public static double []value=new double[4];
    public static int takeAction(){//1 bombplayer , 2 boomtempblock . 3 pickitem
        bGotoBombPlayer=(Math.exp(wOpponentDistance/(opponentDistance+0.5)))+Math.exp(wRanTime*(System.currentTimeMillis()-ranTime));
        if (Npc1.giveUpUp!=-1){
            bGotoBombPlayer=0;
        }
        bGoToBombTempBlock=(Math.exp(wTempBlockNumber*tempBlockNumber));
        value[0]=2*bGotoBombPlayer-bGoToBombTempBlock;
        value[1]=2*bGoToBombTempBlock-bGotoBombPlayer;
        value[2]=-999;
        value[3]=hasABomb;
        double temp=-1;
        int position=-1;
        for (int i=0;i<4;i++){
            if (temp==-1){
                temp=value[i];
                position=i;
            }
            else if (value[i]>temp){
                temp=value[i];
                position=i;
            }
        }
        return position;
    }
}