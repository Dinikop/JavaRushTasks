package com.javarush.task.task31.task3101;


import java.io.*;
import java.util.ArrayList;

import java.util.Comparator;


/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        File path = new File(args[0]);
        File sourceFile = new File(args[1]);
        File destinationFile = new File(sourceFile.getParent() + "\\allFilesContent.txt");
        if (FileUtils.isExist(destinationFile)) FileUtils.deleteFile(destinationFile);
        FileUtils.renameFile(sourceFile, destinationFile);

//        System.out.println(sourceFile);

        ArrayList<File> fileList = new ArrayList<>();
        getFilesInPath(path, fileList);
        fileList.sort(Comparator.comparing(File::getName));


        try (FileWriter fileWriter = new FileWriter(destinationFile)) {
            for (File file :fileList) {
                try (BufferedReader fileReader = new BufferedReader(
                        new FileReader(file)
                )) {
                    while (fileReader.ready()) {
                        fileWriter.write(fileReader.readLine());
                    }
                }
                fileWriter.write('\n');
                fileWriter.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void getFilesInPath(File path, ArrayList<File> files) {
        for (File file :path.listFiles()) {
            if (file.isDirectory()) getFilesInPath(file, files);
            else if (file.length() <= 50) files.add(file);
        }

    }
}
