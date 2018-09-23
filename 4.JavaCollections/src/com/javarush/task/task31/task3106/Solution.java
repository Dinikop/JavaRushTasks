package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Vector;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {


        String[] names = new String[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            names[i - 1] = args[i];
        }

        Arrays.sort(names);

        Vector<InputStream> vector = new Vector<>();

        for (int i = 0; i < names.length; i++) {
            try {
                vector.add(new FileInputStream(names[i]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

//        Path outputFile = Paths.get(args[0]);

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(vector.elements()));
             FileOutputStream fileOutputStream = new FileOutputStream(args[0])) {
            zipInputStream.getNextEntry();

            byte[] buffer = new byte[8 * 1024];
            int len;
            while ((len = zipInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
