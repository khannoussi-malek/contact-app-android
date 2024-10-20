package com.example.gestiondecontact;

public class Contact {
    String name;
    String psedo;
    String phone;
    Number id;

    public Contact(Number id, String name, String psedo, String phone) {
        this.id = id;
        this.name = name;
        this.psedo = psedo;
        this.phone = phone;
    }

    public Contact(String name, String psedo, String phone) {
        this.phone = phone;
        this.psedo = psedo;
        this.name = name;
    }
}
