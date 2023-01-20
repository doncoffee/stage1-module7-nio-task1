package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0l;
        String[] arr = null;
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            name = br.readLine().substring("name: ".length());
            age = Integer.parseInt(br.readLine().substring("age: ".length()));
            email = br.readLine().substring("email: ".length());
            phone = Long.parseLong(br.readLine().substring("phone: ".length()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}
