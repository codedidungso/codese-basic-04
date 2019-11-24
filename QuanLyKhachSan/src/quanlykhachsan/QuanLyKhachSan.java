/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class QuanLyKhachSan {
    
    public QuanLyKhachSan() {
        showMenu();
        
    }
    
    private void showMenu() {
        System.out.println("1.Xem thong tin phong");
        System.out.println("2.Thoat");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (i == 1) {
            xemThongTinPhong();
        } else {
            System.exit(0);
        }
    }

    private void xemThongTinPhong() {
        
        
         }
    public static void main(String[] args) throws IOException {
        new RoomInfo(20, "Le Duc Thang")    
    }
}
         