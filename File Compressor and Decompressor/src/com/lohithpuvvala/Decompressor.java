package com.lohithpuvvala;

import javax.swing.*;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Decompressor {

    // Existing method (no progress bar)
    public static void decompressFiles(File zipFile, File outputDir) throws IOException {
        decompressFiles(zipFile, outputDir, null);
    }

    // Overloaded method with progress bar
    public static void decompressFiles(File zipFile, File outputDir, JProgressBar progressBar) throws IOException {
        if (!outputDir.exists()) {
            outputDir.mkdirs();//creates dir if it doesn't exist
        }
        try (
                FileInputStream fis = new FileInputStream(zipFile);
                ZipInputStream zis = new ZipInputStream(fis);
        ){
            int totalEntries = countZipEntries(zipFile);
            int currentEntry = 0;

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                currentEntry++;

                File outFile = new File(outputDir,entry.getName());

                //create parent directories if needed
                new File(outFile.getParent()).mkdirs();

                try(FileOutputStream fos = new FileOutputStream(outFile)){
                    byte[] bytes = new byte[1024];
                    int length;
                    while((length = zis.read(bytes)) >= 0){
                        fos.write(bytes, 0, length);
                    }
                }
                zis.closeEntry();

                // Update progress
                if (progressBar != null && totalEntries > 0) {
                    int progress = (int) (((double) currentEntry / totalEntries) * 100);
                    SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                }
            }
        }
    }

    // Helper method to count zip entries
    private static int countZipEntries(File zipFile) throws IOException {
        int count = 0;
        try (
                FileInputStream fis = new FileInputStream(zipFile);
                ZipInputStream zis = new ZipInputStream(fis)
        ) {
            while (zis.getNextEntry() != null) {
                count++;
            }
        }
        return count;
    }
}
