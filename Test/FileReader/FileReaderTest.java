package FileReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fr = new FileReader();
        fr.setFileName("D:\\input.txt");
        System.out.println(fr.getFileContent());
    }
}

class FileReader {

    private String fileName;


    public void setFileName(String fullFileName) {
        fileName = fullFileName;
    }


    public String getFileContent() {
        BufferedReader fileReader;
        String s;
        String outS = "";

        try {
            fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while ((s = fileReader.readLine()) != null) {
                outS += s + " ";
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outS;
    }
}
