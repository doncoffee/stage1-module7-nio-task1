package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.util.stream.Collectors;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0l;
        String[] arr = null;
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            arr = br.lines().collect(Collectors.joining(System.lineSeparator())).split("\\W+");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Name")) {
                name = arr[i + 1];
            }
            if (arr[i].equals("Age")) {
                age = Integer.parseInt(arr[i + 1]);
            }
            if (arr[i].equals("Email")) {
                email = arr[i + 1];
            }
            if (arr[i].equals("Phone")) {
                phone = Long.parseLong(arr[i + 1]);
            }
        }
        return new Profile(name, age, email, phone);
    }
}
