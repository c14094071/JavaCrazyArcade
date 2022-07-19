package Heros_Myth_v1_0_0_01;

import Extension.Node;
import Extension.Parameter;

import javax.swing.*;

public class LinkedList extends Parameter{
    public static void nextLink(String link,int x,int y){
        notDuplicate=200;
        switch(link){
            case "bomb":{
                if(bombLink==null){
                    bombLink=new Node();
                    bombLink.next=null;
                }else{
                    for (Node i=bombLink;;i=i.next){
                        if (i.next==null){
                            i.next = new Node();
                            i.next.next = null;
                            break;
                        }
                    }
                }
                break;
            }
            case "tempblock": {
                if(tempBlockLink==null){
                    tempBlockLink=new Node();
                    tempBlockLink.next=null;
                }else{
                    for (Node i=tempBlockLink;;i=i.next) {
                        if (i.next == null) {
                            i.next = new Node();
                            i.next.next = null;
                            break;
                        }
                    }
                }
                break;
            }
            case "block": {
                if (blockLink == null) {
                    blockLink = new Node();
                    blockLink.next = null;
                } else {
                    for (Node i = blockLink; ; i = i.next) {
                        if (i.next == null) {
                            i.next = new Node();
                            i.next.next = null;
                            break;
                        }
                    }
                }
                break;
            }
            case "clean": {
                if (cleanLink == null) {
                    cleanLink = new Node();
                    cleanLink.next = null;
                } else {
                    for (Node i = cleanLink; ; i = i.next) {
                        if (i.x==x && i.y==y){
                            notDuplicate=400;
                            break;
                        }
                        if (i.next == null) {
                            i.next = new Node();
                            i.next.next = null;
                            break;
                        }
                    }
                }
                break;
            }
        }
    }
    public static void setLink(String link, int x, int y,JLabel label,int player){
        nextLink(link,x,y);
        if (link.equals("bomb")){
            for (Node i=bombLink;i!=null;i=i.next) {
                if (i.next == null) {
                    i.x = x;
                    i.y = y;
                    i.label=label;
                    i.player=player;
                    i.time=System.currentTimeMillis();
                }
            }
        }else if (link.equals("tempblock")){
            for (Node i=tempBlockLink;i!=null;i=i.next) {
                if (i.next == null) {
                    i.x = x * radius;
                    i.y = y * radius;
                    i.label=label;
                }
            }
        }else if (link.equals("block")){
            for (Node i=blockLink;i!=null;i=i.next) {
                if (i.next == null) {
                    i.x = x * radius;
                    i.y = y * radius;
                    i.label=label;
                }
            }
        }
        else if (link.equals("clean")){
            if (notDuplicate==200){
                for (Node i = cleanLink; i != null; i = i.next) {
                    if (i.next == null) {
                        i.x = x;
                        i.y = y;
                        i.label = label;
                        i.player = player;
                        i.time = System.currentTimeMillis();
                    }
                }
            }
        }
    }
    public static Node getTheNode(int x,int y){
        for (Node i=bombLink;i!=null;i=i.next){
            if (i.x==x&&i.y==y)
                return i;
        }
        return null;
    }
    public static void getDetailsAndRemove(int coordinateX,int coordinateY) {
        for (Node i = tempBlockLink,j=null;i!=null; i = i.next) {
           if (j==null) {
               j=i;
               if (i.x/radius==coordinateX && i.y/radius==coordinateY) {
                   jLayeredPane_main.remove(i.label);
                   // edit 0529
                   Items.create(coordinateX, coordinateY);
                   jLayeredPane_main.repaint();
                   i=i.next;
                   tempBlockLink=i;
                   break;
               }
           }
           else if (i==j.next && i.x/radius==coordinateX && i.y/radius==coordinateY){
               jLayeredPane_main.remove(i.label);
               // edit 0529
               Items.create(coordinateX, coordinateY);
               jLayeredPane_main.repaint();
               j.next=j.next.next;
               tempBlockLink=j;
           }
           else if (i.next!=null && i.next.x/radius==coordinateX && i.next.y/radius==coordinateY){
               jLayeredPane_main.remove(i.next.label);
               // edit 0529
               Items.create(coordinateX, coordinateY);
               jLayeredPane_main.repaint();
               i.next=i.next.next;
               tempBlockLink=j;
               break;
           }
        }
    }
}
