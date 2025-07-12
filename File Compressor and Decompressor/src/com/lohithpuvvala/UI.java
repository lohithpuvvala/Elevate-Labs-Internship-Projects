package com.lohithpuvvala;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UI extends JFrame {
    private final JTable fileTable;
    private final DefaultTableModel tableModel;
    private final JProgressBar progressBar;

    private File[] selectedFiles;
    private File zipFileToExtract;

    private boolean isCompressionMode = true;

    // Buttons for different actions
    private final JButton selectFilesButton = new JButton("Select Files to Compress");
    private final JButton selectZipButton = new JButton("Select Zip to Extract");
    private final JButton compressButton = new JButton("Compress");
    private final JButton decompressButton = new JButton("Decompress");
    private final JButton discardButton = new JButton("Discard Selection");

    public UI() {
        super("File Compressor & Decompressor");
        FlatLightLaf.setup(); // Apply FlatLaf Look and Feel
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Toggle switch (JToggleButton)
        JToggleButton modeToggle = new JToggleButton("Mode: Compression");
        modeToggle.addActionListener(e -> {
            isCompressionMode = !isCompressionMode;
            modeToggle.setText("Mode: " + (isCompressionMode ? "Compression" : "Decompression"));
            clearSelection();
            updateButtonVisibility();
        });
        add(modeToggle, BorderLayout.NORTH);

        // File table with S.No, File Name, File Path
        String[] columns = {"S.No", "File Name", "File Path"};
        tableModel = new DefaultTableModel(columns, 0);
        fileTable = new JTable(tableModel);
        fileTable.getColumnModel().getColumn(0).setPreferredWidth(50); // S.No column
        fileTable.getColumnModel().getColumn(1).setPreferredWidth(200); // File Name
        fileTable.getColumnModel().getColumn(2).setPreferredWidth(400); // File Path
        add(new JScrollPane(fileTable), BorderLayout.CENTER);

        // Progress bar
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);
        add(progressBar, BorderLayout.SOUTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(selectFilesButton);
        buttonPanel.add(selectZipButton);
        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);
        buttonPanel.add(discardButton);
        add(buttonPanel, BorderLayout.PAGE_END);

        // Button Actions

        selectFilesButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(true);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                selectedFiles = chooser.getSelectedFiles();
                updateFileTable(selectedFiles);
                updateButtonVisibility();
            }
        });

        selectZipButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selected = chooser.getSelectedFile();
                if (!selected.getName().endsWith(".zip")) {
                    JOptionPane.showMessageDialog(this, "Please select a valid .zip file.");
                    return;
                }
                zipFileToExtract = selected;
                updateFileTable(new File[]{zipFileToExtract});
                updateButtonVisibility();
            }
        });

        compressButton.addActionListener(e -> {
            if (selectedFiles == null || selectedFiles.length == 0) {
                JOptionPane.showMessageDialog(this, "No files selected.");
                return;
            }

            JFileChooser chooser = new JFileChooser();
            chooser.setSelectedFile(new File("compressed.zip"));
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File zipFile = chooser.getSelectedFile();
                new Thread(() -> {
                    try {
                        SwingUtilities.invokeLater(() -> {
                            progressBar.setValue(0);
                            progressBar.setVisible(true);
                        });
                        Compressor.compressFiles(selectedFiles, zipFile, progressBar);
                        JOptionPane.showMessageDialog(this, "Compression successful!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                        ex.printStackTrace();
                    } finally {
                        SwingUtilities.invokeLater(() -> progressBar.setVisible(false));
                    }
                }).start();
            }
        });

        decompressButton.addActionListener(e -> {
            if (zipFileToExtract == null) {
                JOptionPane.showMessageDialog(this, "No zip file selected.");
                return;
            }

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File outputDir = chooser.getSelectedFile();
                new Thread(() -> {
                    try {
                        SwingUtilities.invokeLater(() -> {
                            progressBar.setValue(0);
                            progressBar.setVisible(true);
                        });
                        Decompressor.decompressFiles(zipFileToExtract, outputDir, progressBar);
                        JOptionPane.showMessageDialog(this, "Decompression complete!");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                        ex.printStackTrace();
                    } finally {
                        SwingUtilities.invokeLater(() -> progressBar.setVisible(false));
                    }
                }).start();
            }
        });

        discardButton.addActionListener(e -> {
            clearSelection();
            updateButtonVisibility();
        });

        updateButtonVisibility();
        setVisible(true);
    }

    private void updateFileTable(File[] files) {
        tableModel.setRowCount(0);
        for (int i = 0; i < files.length; i++) {
            tableModel.addRow(new Object[]{i + 1, files[i].getName(), files[i].getAbsolutePath()});
        }
    }

    private void clearSelection() {
        selectedFiles = null;
        zipFileToExtract = null;
        tableModel.setRowCount(0);
    }

    private void updateButtonVisibility() {
        boolean hasFiles = selectedFiles != null && selectedFiles.length > 0;
        boolean hasZip = zipFileToExtract != null;

        if (isCompressionMode) {
            selectFilesButton.setVisible(!hasFiles);
            selectZipButton.setVisible(false);
            compressButton.setVisible(hasFiles);
            decompressButton.setVisible(false);
            discardButton.setVisible(hasFiles);
        } else {
            selectZipButton.setVisible(!hasZip);
            selectFilesButton.setVisible(false);
            decompressButton.setVisible(hasZip);
            compressButton.setVisible(false);
            discardButton.setVisible(hasZip);
        }
    }
}
