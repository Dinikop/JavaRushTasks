import java.io.*;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {

        int mask = 2147483392;
        System.out.println(Integer.toString((255), 2));
        System.out.println(Integer.toString((255 >> 1) & 255, 2));
    }
}
