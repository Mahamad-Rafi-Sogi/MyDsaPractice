package com.rafi.practice;

import java.io.File;

public class FindTxtFiles {

    public static void main(String[] args) {
        String rootFolder = "/Users/mahamadrafisogi/Desktop/MyProjects";

        findTxtFiles(new File(rootFolder));
    }

    public static void findTxtFiles(File folder) {
    
        if (folder.isDirectory()) {
            
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    
                    if (file.isDirectory()) {
                        findTxtFiles(file);
                    } 
                    
                    else if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                        System.out.println("Found .txt file: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("The specified path is not a directory: " + folder.getAbsolutePath());
        }
    }
}