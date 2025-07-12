package com.lohithpuvvala;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UI extends JFrame{
    private JTextArea fileListArea;
    private File[] selectedFiles;
    private File zipFileToExtract;
    private JProgressBar progressBar;

    public UI(){
        setTitle("File Compressor & Decompressor");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //File list display
        fileListArea = new JTextArea();
        fileListArea.setEditable(false);
        add(new JScrollPane(fileListArea), BorderLayout.CENTER);

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);//Initially Hidden
        add(progressBar, BorderLayout.SOUTH);

        //Buttons Panel
        JPanel buttonPanel = new JPanel();
        JButton selectFilesButton = new JButton("Select files to compress");
        JButton selectZipBtn = new JButton("Select Zip to Extract");
        JButton compressBtn = new JButton("Compress");
        JButton decompressBtn = new JButton("Decompress");

        //Add Buttons
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        buttonPanel.add(selectFilesButton);
        buttonPanel.add(selectZipBtn);
        buttonPanel.add(compressBtn);
        buttonPanel.add(decompressBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        selectFilesButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            int result = fileChooser.showOpenDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                selectedFiles = fileChooser.getSelectedFiles();
                fileListArea.setText("");
                for(File file : selectedFiles){
                    fileListArea.append(file.getAbsolutePath() + "\n");
                }
            }
        });

        compressBtn.addActionListener(e -> {
            if(selectedFiles == null || selectedFiles.length == 0){
                JOptionPane.showMessageDialog(this, "Please select files to compress!");
                return;
            }else{
                JFileChooser saveChooser = new JFileChooser();
                saveChooser.setDialogTitle("Save Compressed File");
                saveChooser.setSelectedFile(new File("compressed.zip"));
                int result = saveChooser.showSaveDialog(this);

                if(result == JFileChooser.APPROVE_OPTION){
                    File zipFile = saveChooser.getSelectedFile();
                    try {
                        Compressor.compressFiles(selectedFiles, zipFile);
                        JOptionPane.showMessageDialog(this, "Compressed Successfully!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error compressing file: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
        });

        selectZipBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select a Zip File to Extract");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int result = chooser.showOpenDialog(this);
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = chooser.getSelectedFile();
                if(!selectedFile.getName().endsWith(".zip")){
                    JOptionPane.showMessageDialog(this, "Please select a valid Zip File!");
                    return;
                }

                zipFileToExtract = selectedFile;
                fileListArea.append("Zip File Selected: " + zipFileToExtract.getAbsolutePath() + "\n\n");
            }
        });

        decompressBtn.addActionListener( e -> {
            if (zipFileToExtract == null || !zipFileToExtract.getName().endsWith(".zip")) {
                JOptionPane.showMessageDialog(this, "Please select a valid .zip file to extract.");
                return;
            }

            JFileChooser outputChooser = new JFileChooser();
            outputChooser.setDialogTitle("Select Destination Folder");
            outputChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int result = outputChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File outputDir = outputChooser.getSelectedFile();
                try {
                    Decompressor.decompressFiles(zipFileToExtract, outputDir);
                    JOptionPane.showMessageDialog(this, "Extraction completed successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error during extraction: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        setVisible(true);
    }
}
