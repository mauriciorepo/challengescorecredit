package com.challenge.creditscore.application.core.domain;

import java.util.List;


public class User {

    public User(long id, String cpf, String name, String address, List<Debt> list) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.address = address;
        this.list = list;
    }

    public User() {
    }

    private long id ;
    private String cpf;
    private String name;
    private String address;
    List<Debt> list;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Debt> getList() {
        return list;
    }

    public void setList(List<Debt> list) {
        this.list = list;
    }
}
