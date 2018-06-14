package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName;
            while (true) {
                fileName = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(fileName);
                if (fileInputStream.available() < 1000) {
                    reader.close();
                    fileInputStream.close();
                    throw new DownloadException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}
