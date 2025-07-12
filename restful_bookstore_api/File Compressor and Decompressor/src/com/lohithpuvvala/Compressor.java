package com.lohithpuvvala;

import javax.swing.*;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compressor {

    //Existing Method (no progress bar)
    public static void compressFiles(File[] inputFile, File outputZip) throws IOException {
        compressFiles(inputFile, outputZip, null);
    }

    //Overloaded Method with progress bar
    public static void compressFiles(File[] inputFiles, File outputZip, JProgressBar progressBar) throws IOException {
        try(
            FileOutputStream fos = new FileOutputStream(outputZip);
            ZipOutputStream zos = new ZipOutputStream(fos);
        ){
            int totalFiles = inputFiles.length;
            int currentFile = 0;

            for(File file: inputFiles){
                currentFile++;

                FileInputStream fis = new FileInputStream(file);
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zos.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while((length = fis.read(bytes)) >= 0){
                    zos.write(bytes, 0, length);
                }

                zos.closeEntry();
                fis.close();

                //Update Progress
                if(progressBar != null){
                    int progress = (int)(((double)currentFile / (double)totalFiles) * 100);
                    SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                }
            }
        }
    }
}
