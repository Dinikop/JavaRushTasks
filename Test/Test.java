import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class Test {
    public static void main(String[] args) {
        Path pathOfZipFile = Paths.get("D:\\DEV\\JavaRushTasks\\Test\\test.zip");
        Path pathPack = Paths.get("D:\\DEV\\JavaRushTasks\\Test\\equals\\wefwef.txt");
        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(pathOfZipFile));
             InputStream is = Files.newInputStream(pathPack)) {
            ZipEntry zipEntry = new ZipEntry(pathPack.toString());
            zos.putNextEntry(zipEntry);

            copyData(is, zos);

            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyData(InputStream in, OutputStream out) throws Exception {

        int bufferSize = in.available() > 64000 ? 64000 : in.available();
        byte[] buffer = new byte[bufferSize];
        while (in.available() > 0) {
            if (in.available() < bufferSize) bufferSize = in.available();

            in.read(buffer, 0, bufferSize);
            out.write(buffer);
        }
    }

}