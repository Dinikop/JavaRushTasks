package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

        try(InputStream inputStream = Files.newInputStream(source);
            ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile)))
        {
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zos.putNextEntry(zipEntry);

            int bufferSize = inputStream.available() > 64000 ? 64000 : inputStream.available();
            byte[] buffer = new byte[bufferSize];
            while (inputStream.available() > 0) {
                if (inputStream.available() < bufferSize) bufferSize = inputStream.available();

                inputStream.read(buffer, 0, bufferSize);
                zos.write(buffer);
            }
            zos.closeEntry();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
