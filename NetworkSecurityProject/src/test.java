
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class test {

    public static void main(String[] args) throws IOException {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.getDay() + 1 + "/" + (date.getMonth() + 1) + "/" + date.getYear());
       
    }
}
