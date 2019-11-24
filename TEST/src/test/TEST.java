/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Wind
 */
public class TEST {

    public static void main(String[] args) throws IOException {
        File dir = new File("data");
        dir.mkdir();
        File f = new File(dir.getAbsolutePath() + "/thang.txt");
        f.createNewFile();

    }
}
