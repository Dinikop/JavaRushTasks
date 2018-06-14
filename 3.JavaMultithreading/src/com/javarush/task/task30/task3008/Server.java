package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.task.task30.task3008.MessageType.*;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap();



    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message answer;
            while (true) {
                connection.send(new Message(NAME_REQUEST));
                answer = connection.receive();
                if ((answer.getType() == USER_NAME)) {
                    if (!answer.getData().isEmpty()) {
                        if (!connectionMap.containsKey(answer.getData())) {
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }

        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry :connectionMap.entrySet()) {
                if (userName.equals(entry.getKey())) continue;
                connection.send(new Message(USER_ADDED, entry.getKey()));
            }

        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message messageFromUser = connection.receive();
                if (messageFromUser.getType() == TEXT) {
                    sendBroadcastMessage(new Message(TEXT, userName + ": " + messageFromUser.getData()));
                }
                else ConsoleHelper.writeMessage("Принятое сообщение имеет некорректный тип");
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage(String.valueOf(socket.getRemoteSocketAddress()));
            try(Connection connection = new Connection(socket)) {

                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }

        }
    }


    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(ConsoleHelper.readInt()))
        {
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true) {
                Socket client = server.accept();
                new Handler(client).start();
            }

        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка");
        }

    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry :connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сообщение не доставлено!");
            }
        }

    }
}
