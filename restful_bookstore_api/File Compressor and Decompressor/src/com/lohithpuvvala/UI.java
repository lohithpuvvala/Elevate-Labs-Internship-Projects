package com.lohithpuvvala;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class UI extends JFrame{
    private JTextArea fileListArea;
    private File[] selectedFiles;

    public UI(){
        setTitle("File Compressor & Decompressor");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //File list display
        fileListArea = new JTextArea();
        fileListArea.setEditable(false);
        add(new JScrollPane(fileListArea), BorderLayout.CENTER);

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

        // TODO: Add actions for selectZipBtn, compressBtn, decompressBtn in next commits.
        setVisible(true);
    }
}
