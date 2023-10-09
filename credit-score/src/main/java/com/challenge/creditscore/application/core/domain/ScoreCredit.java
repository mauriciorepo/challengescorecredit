package com.challenge.creditscore.application.core.domain;

import java.util.List;

public class ScoreCredit {

    public ScoreCredit(String id, String address, String sourceOfIncome, List<Assets> assets, String cpf) {
        this.id = id;
        this.address = address;
        this.sourceOfIncome = sourceOfIncome;
        this.assets = assets;
        this.cpf = cpf;
    }

    public ScoreCredit() {
    }

    private String id;
    private String address;
    private String sourceOfIncome;
    List<Assets> assets;
    private String cpf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }

    public List<Assets> getAssets() {
        return assets;
    }

    public void setAssets(List<Assets> assets) {
        this.assets = assets;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
