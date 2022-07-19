package Heros_Myth_v1_0_0_01;

import Extension.Parameter;

import java.util.concurrent.TimeUnit;

public class CheckBomb extends Parameter implements Runnable{
    public void run(){
        while (stopAllThread==-1){
            long timeNow = System.currentTimeMillis();
            if (LinkedList.bombLink != null && timeNow - LinkedList.bombLink.time >= 3000) {
            	new Sound_Tookies("resources/sound/effects_placebomb.wav");
                LinkedList.setLink("clean",LinkedList.bombLink.x,LinkedList.bombLink.y,LinkedList.bombLink.label,LinkedList.bombLink.player);
                new Judgement(LinkedList.cleanLink);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1);//need to adjust according from LinkedList.java function
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
    }
}
