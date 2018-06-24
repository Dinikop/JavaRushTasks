package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.*;

import java.util.HashMap;
import java.util.Map;

import static com.javarush.task.task31.task3110.Operation.*;

public class CommandExecutor {

    private static final Map<Operation, Command> allKnownCommandsMap;

    static {
        allKnownCommandsMap = new HashMap<>();
        allKnownCommandsMap.put(CREATE, new ZipCreateCommand());
        allKnownCommandsMap.put(ADD, new ZipAddCommand());
        allKnownCommandsMap.put(REMOVE, new ZipRemoveCommand());
        allKnownCommandsMap.put(EXTRACT, new ZipExtractCommand());
        allKnownCommandsMap.put(CONTENT, new ZipContentCommand());
        allKnownCommandsMap.put(EXIT, new ExitCommand());
    }

    public static void execute(Operation operation) {
        try {
            allKnownCommandsMap.get(operation).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private CommandExecutor(){}
}
