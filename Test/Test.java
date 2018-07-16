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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class Test {
    public static void main(String[] args) {
        System.out.println(new AmigoThreadFactory().getNumberFactory().get());
        System.out.println(new AmigoThreadFactory().getNumberFactory().get());
        System.out.println(new AmigoThreadFactory().getNumberFactory().get());
        System.out.println(new AmigoThreadFactory().getNumberFactory().get());

    }




    public static class AmigoThreadFactory implements ThreadFactory {

        static AtomicInteger numberOfFactories = new AtomicInteger (1);

        final AtomicInteger numberFactory;

        public AmigoThreadFactory() {
            numberFactory = new AtomicInteger(numberOfFactories.getAndIncrement());
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread();

//            thread.setName(String.format("%s-pool-A-thread-B", Thread.currentThread().getThreadGroup().getName(), ));
            return null;
        }

        public AtomicInteger getNumberFactory() {
            return numberFactory;
        }
    }

}