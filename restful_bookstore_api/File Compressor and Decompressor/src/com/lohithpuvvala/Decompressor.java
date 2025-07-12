package com.lohithpuvvala;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Decompressor {
    public static void decompressFiles(File zipFile, File outputDir) throws IOException {
        if (!outputDir.exists()) {
            outputDir.mkdirs();//creates dir if it doesn't exist
        }
        try (
                FileInputStream fis = new FileInputStream(zipFile);
                ZipInputStream zis = new ZipInputStream(fis);
        ){
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
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
            }
        }
    }
}
