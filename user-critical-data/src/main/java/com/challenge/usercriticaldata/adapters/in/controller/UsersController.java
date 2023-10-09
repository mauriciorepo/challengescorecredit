package com.challenge.usercriticaldata.adapters.in.controller;

import com.challenge.usercriticaldata.adapters.in.controller.mapper.UserMapper;
import com.challenge.usercriticaldata.adapters.in.controller.request.UserRequest;
import com.challenge.usercriticaldata.application.ports.in.FindUserByCpfInputPort;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private FindUserByCpfInputPort findUserByCpfInputPort;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("{cpf}/find")
    public ResponseEntity<UserRequest> find(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok(userMapper.toUserRequest(findUserByCpfInputPort.find(cpf)));

    }
}
