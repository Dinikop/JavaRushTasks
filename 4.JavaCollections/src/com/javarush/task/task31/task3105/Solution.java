package com.javarush.task.task31.task3105;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Path file = Paths.get(args[0]);

        Map<String, ByteArrayOutputStream> zipStore = null;
        try (ZipInputStream zipInputStream = new ZipInputStream(
                new FileInputStream(args[1])
        ))
        {

            //Чтение из архива в zipStore

            zipStore = new HashMap<>();

            ZipEntry currentZipEntry;
            while ((currentZipEntry = zipInputStream.getNextEntry()) != null) {


//                System.out.println(currentZipEntry.getName() +
//                        currentZipEntry.getName().endsWith(file.getFileName().toString()));
                byte[] buffer = new byte[1024];
                int count = 0;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                if (currentZipEntry.getName().endsWith(file.getFileName().toString())) continue;

                while ((count = zipInputStream.read(buffer)) != -1 ) {

                    byteArrayOutputStream.write(buffer, 0, count);
                }
                zipStore.put(currentZipEntry.toString(), byteArrayOutputStream);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //запись из zipEntryStore

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1])))
        {

            for (Map.Entry<String, ByteArrayOutputStream> entry :zipStore.entrySet()) {
//                System.out.println(entry.toString());

                zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));
                zipOutputStream.write(entry.getValue().toByteArray());
            }
            zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getFileName().toString()));
            Files.copy(file, zipOutputStream);

            zipOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
