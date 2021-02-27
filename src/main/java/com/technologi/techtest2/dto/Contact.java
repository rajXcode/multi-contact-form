package com.technologi.techtest2.dto;/*
 * @created 25/02/2021 - 09:53
 * @project multi-contact-form
 * @author rajender
 * rajender created on 25/02/2021 inside the package - com.technologi.techtest2.dto
 */

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class Contact {

    @NotEmpty(message = "Name can not be empty")
    @Pattern(regexp = "^[A-Za-z]|[A-Za-z][A-Za-z\\s]*[A-Za-z]$", message = "Name must contain only alphabets and space")
    private String name;

    @NotEmpty(message = "Email can not be empty!!")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotEmpty(message = "Number can not be empty")
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message = "Please provide valid number")
    private String number;

    public Contact() {
    }

    public Contact(@NotEmpty(message = "Name can not be empty") @Pattern(regexp = "^[A-Za-z]|[A-Za-z][A-Za-z\\s]*[A-Za-z]$", message = "Name must contain only alphabets and space") String name, @NotEmpty(message = "Email can not be empty!!") @Email(message = "Please provide a valid email address") String email, @NotEmpty(message = "Number can not be empty") @Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message = "Please provide valid number") String number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact [name=" + name + ", email=" + email + ", phonenumber=" + number
                + "]";
    }

}