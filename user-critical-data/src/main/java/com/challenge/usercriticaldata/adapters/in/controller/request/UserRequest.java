package com.challenge.usercriticaldata.adapters.in.controller.request;

import com.challenge.usercriticaldata.application.core.domain.Debt;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private long id ;
    private String cpf;
    private String name;
    private String address;
    List<Debt> list;
}
