
import DigitalCertificate.Message;
import DigitalCertificate.VerifyMessage;
import java.io.BufferedReader;
import java.io.File;
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
        VerifyMessage ms = new VerifyMessage("data\\userdata\\Groups\\thu1\\(nguyenanninh2)data.txt"
                , "data\\admindata\\keyStore\\publicKeys\\nguyenanninh's_Public_Key.txt");

        
    }
    
}
