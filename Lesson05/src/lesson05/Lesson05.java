/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson05;

import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Wind
 */
public class Lesson05{

    static int X, Y, ENDX, ENDY;
    static char[][] MAP = new char[5][5];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setVisible(true);
//        frame.setSize(300, 400);
//        frame.setLocationRelativeTo(null);
        X = 2;
        Y = 2;
        ENDX = (int) (Math.random() * 5);
        ENDY = (int) (Math.random() * 5);

//        char c = 'w';
//        int d = c;
//        System.out.println(d);
//        d = Integer.valueOf("13");
//        d = 65;
////        c = Character; tru thang nay khong co 
////        Double, Float, Boolean, String
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == X && j == Y) {
                    MAP[i][j] = 'X';
                } else if (i == ENDX && j == ENDY) {
                    MAP[i][j] = 'O';
                } else {
                    MAP[i][j] = '-';
                }
            }
        }

        while (true) {
            hienThiMap();
            char input = nhapPhimDiChuyen();
            thayDoiToaDo(input);
            boolean check = checkThangThua();
            if (check) {
                System.out.println("Thang roi");
                break;
            }

        }
    }

    public static void hienThiMap() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static char nhapPhimDiChuyen() {
        System.out.println("Nhap WASD:");
        String phimDiChuyen = sc.nextLine();
        char phimDiChuyenChar = phimDiChuyen.charAt(0);
        return phimDiChuyenChar;
    }

    public static void thayDoiToaDo(char c) {
        switch (c) {
            case 'A':
                if (Y == 0) {
                    MAP[X][Y] = '-';
                    Y = 4;
                    MAP[X][Y] = 'X';
                } else {
                    MAP[X][Y] = '-';
                    Y--;
                    MAP[X][Y] = 'X';
                }
                break;
            case 'S':
                if (X == 4) {
                    MAP[X][Y] = '-';
                    X = 0;
                    MAP[X][Y] = 'X';
                } else {
                    MAP[X][Y] = '-';
                    X++;
                    MAP[X][Y] = 'X';
                }
                break;
            case 'W':
                if (X == 0) {
                    MAP[X][Y] = '-';
                    X = 4;
                    MAP[X][Y] = 'X';
                } else {
                    MAP[X][Y] = '-';
                    X--;
                    MAP[X][Y] = 'X';
                }
                break;
            case 'D':
                if (Y == 4) {
                    MAP[X][Y] = '-';
                    Y = 0;
                    MAP[X][Y] = 'X';
                } else {
                    MAP[X][Y] = '-';
                    Y++;
                    MAP[X][Y] = 'X';
                }

        }

    }

    public static boolean checkThangThua() {
        if (X == ENDX && Y == ENDY) {
            return true;
        }
        return false;
    }

}
