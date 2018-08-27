package com.javarush.task.task31.task3112;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        String[] urlElements = url.toString().split("/");
        String fileName = urlElements[urlElements.length - 1];
        Path tempFile = Files.createTempFile(fileName, ".tmp");
        Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
        Path returnFile = Paths.get(downloadDirectory.toString() + File.separator + fileName);
        if (!Files.exists(downloadDirectory)) Files.createDirectories(downloadDirectory);
        Files.createFile(returnFile);
        Files.move(tempFile, returnFile, StandardCopyOption.REPLACE_EXISTING);
        return  returnFile;
        // implement this method
    }
}
