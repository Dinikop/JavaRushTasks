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

        Path file = Paths.get("in3\\test.zip");
        Path full = Paths.get("D:\\DEV\\JavaRushTasks\\Test\\in1\\in2\\", "in3\\test.zip");

        System.out.println(full);
        System.out.println(full.getParent());
    }

}