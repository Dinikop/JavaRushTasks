package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        Path path = Paths.get(reader.readLine());

        if (Files.isDirectory(path)) {

            FileWatcher fileWatcher = new FileWatcher();
            Files.walkFileTree(path, fileWatcher);

            System.out.println("Всего папок - " + fileWatcher.getNumberOfDirectories());
            System.out.println("Всего файлов - " + fileWatcher.getNumberOfFiles());
            System.out.println("Общий размер - " + fileWatcher.getNumberOfBytes());

        }

        System.out.println(path + " - не папка");

    }

    static class FileWatcher extends SimpleFileVisitor<Path> {

        private int numberOfDirectories = -1;
        private int numberOfFiles = 0;
        private long numberOfBytes = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            numberOfFiles++;
            numberOfBytes += Files.readAllBytes(file).length;

            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            numberOfDirectories++;
            return super.preVisitDirectory(dir, attrs);
        }

        public int getNumberOfDirectories() {
            return numberOfDirectories;
        }

        public int getNumberOfFiles() {
            return numberOfFiles;
        }

        public long getNumberOfBytes() {
            return numberOfBytes;
        }
    }
}
