package com.lohithpuvvala;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compressor {
    public static void compressFiles(File[] inputFiles, File outputZip) throws IOException {
        try(
            FileOutputStream fos = new FileOutputStream(outputZip);
            ZipOutputStream zos = new ZipOutputStream(fos);
        ){
            for(File file: inputFiles){
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
            }
        }
    }
}
