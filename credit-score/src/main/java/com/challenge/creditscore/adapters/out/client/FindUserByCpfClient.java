package com.challenge.creditscore.adapters.out.client;

import com.challenge.creditscore.adapters.out.client.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient
        (
        name = "FindUserByCpfClient",
        url = "${critical-data.client.address.url}"
)
public interface FindUserByCpfClient {

    @GetMapping("/{cpf}/find")

    UserResponse find(@PathVariable  String cpf,
                      @RequestHeader("Authorization") String bearerToken
                      );
}
