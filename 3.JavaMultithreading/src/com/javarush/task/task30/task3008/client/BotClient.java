package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + ((int) (Math.random()*100));
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(":")) {
                String name = message.split(":")[0];
                String customerRequest = message.split(":")[1].trim();
                Calendar cal = new GregorianCalendar();
                SimpleDateFormat dateFormat = new SimpleDateFormat();

                switch (customerRequest) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(cal.getTime())));
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d");
                        sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(cal.getTime())));
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM");
                        sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(cal.getTime())));
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("YYYY");
                        sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(cal.getTime())));
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(cal.getTime())));
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H");
                        sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(cal.getTime())));
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m");
                        sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(cal.getTime())));
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s");
                        sendTextMessage(String.format("Информация для %s: %s", name, dateFormat.format(cal.getTime())));
                        break;
                }

            }
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
        System.out.println(botClient.getUserName());
    }
}
