/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Wind
 */
public class RoomInfo {

    int soPhong;
    String tenNguoiThue;
    File file;

    public RoomInfo(int id, String ten) throws IOException {
        soPhong = id;
        tenNguoiThue = ten;
        File f = new File("C:\\Users\\Wind\\Documents\\NetBeansProjects\\codese-basic-04\\QuanLyKhachSan\\dataPhong\\" + this.soPhong + ".txt");
        f.createNewFile();
        FileOutputStream fo2 = new FileOutputStream(f);
        String s = ten;
        fo2.write(s.getBytes());
        fo2.close();
        file = f;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public String getTenNguoiThue() {
        return tenNguoiThue;
    }

    public void setTenNguoiThue(String tenNguoiThue) throws IOException {
        this.tenNguoiThue = tenNguoiThue;
        FileOutputStream fo2 = new FileOutputStream(file);
        fo2.write(tenNguoiThue.getBytes());
        fo2.close();
    }

    void showInfo() {
        
    }

}
