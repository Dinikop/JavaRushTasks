package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

        if (Files.notExists(zipFile.getParent())) {
            Files.createDirectory(zipFile.getParent());
        }

        try(ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isRegularFile(source)) {
                addNewZipEntry(zos, source.getParent(), source.getFileName());
            } else if (Files.isDirectory(source)) {
                FileManager fileManager = new FileManager(source);
                ArrayList<Path> fileNames = new ArrayList<>(fileManager.getFileList());
                for (Path path : fileNames) {
                    addNewZipEntry(zos, source, path);
                }
            }
            else throw new PathIsNotFoundException();
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {

        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);
            copyData(inputStream, zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {

        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public static void main(String[] args) throws Exception {

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get("D:\\DEV\\JavaRushTasks\\Test\\test.zip"));
        zipFileManager.createZip(Paths.get("D:\\DEV\\JavaRushTasks\\Files"));
    }
}
