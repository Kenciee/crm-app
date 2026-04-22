package com.example.demo.model;

public class Client {
    private int id;
    private String name;
    private String email;

    public Client(int id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }

    public void setEmail(){
        this.email = email;
    }
}
