package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try(var br = new BufferedReader(new java.io.FileReader(file));) {
           String line = null;
           while ((line = br.readLine()) != null) {
               String[] property = line.split(":");
               String field = property[0].trim();
               String value = property[1].trim();

               if (field.equals("Name")) {
                   profile.setName(value);
               }
               if (field.equals("Age")) {
                   profile.setAge(Integer.valueOf(value));
               }
               if (field.equals("Email")) {
                   profile.setEmail(value);
               }
               if (field.equals("Phone")) {
                   profile.setPhone(Long.valueOf(value));
               }

           }
        } catch (IOException e) {
            throw new ProfileFileException("Error while reading file: " + file.getName(), e);
        }
        return profile;
    }
}
