/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import lesson9quanly.DatabaseControl;

/**
 *
 * @author thiennd
 */
public class Main {

    public static void main(String[] args) {
//        Thread th1 = new Thread(new Luong1());
//        Thread th2 = new Thread(new Luong2());
//        th1.start();
//        th2.start();
//        Control myControl = new Control();
//        Model myModel = new Model();
//        View mainView = new View(myControl, myModel);
        ArrayList<Integer> danhsach = new ArrayList();
        danhsach.add(14); //0
        danhsach.add(15); //1
        danhsach.add(16); //2
        danhsach.add(1, 20);
        Integer[] a;
        a = (Integer[]) danhsach.toArray();
        System.out.println(danhsach.toString());

        HashMap<String, Integer> hm = new HashMap();
        hm.put("khong", 100);
        hm.put("mot", 101);
        hm.put("hai", 102);

    }
}

class Email {

    String sender;
    String receiver;
    long timeStamp;
}

class Luong1 implements Runnable {

    @Override
    public void run() {
        DatabaseControl db = DatabaseControl.getInstance();
        while (true) {
            DatabaseControl.isUsed = true;
            int x = db.getData() + 1;
            db.setData(x);
            System.out.println("Luong 1: " + db.getData());
            DatabaseControl.isUsed = false;
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Luong1.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

}

class Luong2 implements Runnable {

    @Override
    public void run() {
        DatabaseControl db = DatabaseControl.getInstance();
        while (true) {
            DatabaseControl.isUsed = true;

            int x = db.getData() + 2;
            db.setData(x);
            System.out.println("Luong 2: " + db.getData());

            DatabaseControl.isUsed = false;
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Luong2.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

}
