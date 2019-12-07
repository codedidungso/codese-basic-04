
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
import javax.swing.JFileChooser;

public class test {

    public static void main(String[] args) throws IOException {
        JFileChooser j = new JFileChooser("C:\\Users\\Wind\\Documents\\NetBeansProjects\\codese-basic-04\\NetworkSecurityProject");
        int result = j.showOpenDialog(j);
    }

    public void removeLine(String lineContent, File f) throws IOException {
        File file = f;
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void replaceLine(int line, String replace, File f) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        ArrayList<String> data = new ArrayList<>();
        String l = reader.readLine();
        data.add(l);
        while (l != null) {
            l = reader.readLine();
            data.add(l);
        }
        reader.close();
        data.set(line, replace);
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
        String result = "";
        for (int i = 0; i < data.size(); i++) {
            if (i == data.size() - 1) {
                continue;
            }
            result += data.get(i) + "\n";

        }
        FileWriter fr = new FileWriter(f, false);
        fr.write(result);
        fr.flush();
        fr.close();

    }

}
