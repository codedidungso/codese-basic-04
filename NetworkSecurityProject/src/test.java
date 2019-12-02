
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) throws IOException {
        String data = "admin1\nadmin2\nadmin3\n";
        for (String string : data.split("\n")) {
            System.out.println(string);
        }
    }
}
