import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Test {
    public static void main(String[] args) {
        processIncomingMessage("дима: дата");

    }

    protected static void processIncomingMessage(String message) {
        if (message.contains(":")) {
            String name = message.split(":")[0];
            String customerRequest = message.split(":")[1].trim();
            Calendar cal = new GregorianCalendar();

            switch (customerRequest) {
                case "дата":
                    SimpleDateFormat format = new SimpleDateFormat("d.MM.YYYY");
                    System.out.println(format.format(cal.getTime()));
            }
        }
    }

}