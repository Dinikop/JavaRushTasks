import java.io.*;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(3));
        }

    }

    private static char generateDigit() {
        return (char) ThreadLocalRandom.current().nextInt(2);
    }
}
