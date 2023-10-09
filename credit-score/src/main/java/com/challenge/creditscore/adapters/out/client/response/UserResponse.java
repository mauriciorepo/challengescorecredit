package com.challenge.creditscore.adapters.out.client.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private long id ;
    private String cpf;
    private String name;
    private String address;
    List<DebtResponse> list;
}
