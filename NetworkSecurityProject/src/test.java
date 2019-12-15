
import DigitalCertificate.Message;
import DigitalCertificate.VerifyMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javafx.stage.PopupWindow;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import networksecurityproject.FileDialog;

public class test extends Thread {

    public test() {
        System.out.println("test run");
    }

    public static void main(String[] args) throws IOException, Exception {
        File f = new File("G:\\DataDigitalSignatureProject\\tuan123\\yyy.docx");
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(f));
//            String noti = "";
//            String line = reader.readLine();
//            System.out.println(line);
//            while (line != null) {
//                noti += line + "\n";
//                line = reader.readLine();
//                System.out.println(line);
//            }
//
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {

            Scanner scanner = new Scanner(f);
            System.out.println("start");
            System.out.println(scanner.hasNext());
            System.out.println("end");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
