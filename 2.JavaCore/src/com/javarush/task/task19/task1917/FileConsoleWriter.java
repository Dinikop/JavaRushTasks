package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    public static void main(String[] args) throws IOException {
        String s = "sfgwefgw";
        char[] cbuf = s.toCharArray();
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("D:\\DEV\\JavaRushTasks\\Files\\data.txt");
        fileConsoleWriter.write(cbuf, 2, 5);
    }

    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        fileWriter.flush();
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        fileWriter.flush();
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        fileWriter.flush();
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        fileWriter.flush();
        System.out.println(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        fileWriter.flush();
        System.out.println(cbuf);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

}
