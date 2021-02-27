package com.technologi.techtest2.utility;/*
 * @created 25/02/2021 - 09:07
 * @project multi-contact-form
 * @author rajender
 * rajender created on 25/02/2021 inside the package - com.technologi.techtest2.utility
 */

import com.technologi.techtest2.dto.Contact;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileUtility {

    private static final String OUTPUT_FILE_NAME = "src/main/resources/contact.txt";

    public void saveContactToFile(Contact contact) throws Exception {

        //Create file if it doesn't exist
        createFile();

        try (PrintStream out = new PrintStream(new FileOutputStream(OUTPUT_FILE_NAME, true))) {
            out.println(contact.toString());
        } catch (Exception e) {
            throw e;
        }

    }

    private void createFile() throws IOException {
        File myObj = new File(OUTPUT_FILE_NAME);
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    public void removeContact(Contact contact) throws IOException {
        File myObj = new File(OUTPUT_FILE_NAME);
        if (myObj.exists()) {
            List<String> lines = FileUtils.readLines(myObj, Charset.defaultCharset());
            List<String> updatedLines = lines.stream().filter(s -> !s.contains("name=" + contact.getName() + ", email=" + contact.getEmail() + ", phonenumber=" + contact.getNumber())).collect(Collectors.toList());
            FileUtils.writeLines(myObj, updatedLines, false);
        }
    }
}
