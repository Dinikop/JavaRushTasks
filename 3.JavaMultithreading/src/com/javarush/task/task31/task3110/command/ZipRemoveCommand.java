package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {

    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла");
//        ConsoleHelper.writeMessage("Из какого архива будем удалять?");
//        Path zipFile = Paths.get(ConsoleHelper.readString());

        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Какой файл будем удалять?");
        Path removedFile = Paths.get(ConsoleHelper.readString());

        zipFileManager.removeFile(removedFile);

        ConsoleHelper.writeMessage("Файл был удален");
    }
}
