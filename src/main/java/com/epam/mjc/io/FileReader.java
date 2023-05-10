package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        Profile profile = new Profile();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] keyValue = line.split(": ");

                switch (keyValue[0]) {
                    case "Name":
                        profile.setName(keyValue[1]);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(keyValue[1]));
                        break;
                    case "Email":
                        profile.setEmail(keyValue[1]);
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(keyValue[1]));
                        break;
                    default:
                        break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;


    }
}
