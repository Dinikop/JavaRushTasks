package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;
import java.io.IOException;
import static com.javarush.task.task31.task3110.Operation.*;

public class Archiver {

    public static void main(String[] args) throws Exception {
        Operation operation;
        while (true) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
                if (operation == EXIT) break;
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        }
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        ConsoleHelper.writeMessage(CREATE.ordinal() + " - упаковать файлы в архив");
        ConsoleHelper.writeMessage(ADD.ordinal() + " - добавить файл в архив");
        ConsoleHelper.writeMessage(REMOVE.ordinal() + " - удалить файл из архива");
        ConsoleHelper.writeMessage(EXTRACT.ordinal() + " - распаковать архив");
        ConsoleHelper.writeMessage(CONTENT.ordinal() + " - просмотреть содержимое архива");
        ConsoleHelper.writeMessage(EXIT.ordinal() + " - выход");


        int numberOfOperation = ConsoleHelper.readInt();

        switch (numberOfOperation){
            case 0: return CREATE;
            case 1: return ADD;
            case 2: return REMOVE;
            case 3: return EXTRACT;
            case 4: return CONTENT;
            case 5: return EXIT;
            default: return EXIT;
        }

    }
}
