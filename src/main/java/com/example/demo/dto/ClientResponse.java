package com.example.demo.dto;

public class ClientResponse {
    private int id;
    private String name;
    private String email;

    public ClientResponse(int id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }
}
