package com.technologi.techtest2.controller;/*
 * @created 25/02/2021 - 11:19
 * @project multi-contact-form
 * @author rajender
 * rajender created on 25/02/2021 inside the package - com.technologi.techtest2.controller
 */

import com.technologi.techtest2.dto.Contact;
import com.technologi.techtest2.utility.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ContactController {

    @Autowired
    FileUtility fileUtility;

    @GetMapping("/")
    public String getForm(Contact contact) {
        return "index";
    }

    @PostMapping("/save-contact")
    public String saveContact(@Valid Contact contact, Errors errors, Model model) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "index";
        } else {
            try {
                fileUtility.saveContactToFile(contact);
                model.addAttribute("successMsg", "Details saved successfully!!");
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                model.addAttribute("successMsg", "Error saving contact details");
            }
            return "result";

        }
    }

    @PostMapping("/remove-contact")
    public String removeContact(@Valid Contact contact, Errors errors, Model model) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "index";
        } else {
            try {
                fileUtility.removeContact(contact);
                model.addAttribute("successMsg", "Contact removed successfully!!");
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                model.addAttribute("successMsg", "Error removed contact details");
            }
            return "result";
        }
    }

}