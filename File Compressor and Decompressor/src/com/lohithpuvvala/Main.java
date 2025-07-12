package com.lohithpuvvala;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch (Exception ex){
            System.out.println("Failed to Initialize FlatLaf");
        }

        new UI();// Launches the UI
    }
}
